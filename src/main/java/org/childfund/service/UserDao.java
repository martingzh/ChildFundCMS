package org.childfund.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.childfund.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

  private static final String USER_QUESTIONNAIRE_TABLE = "user_questionnaire";
  private ObjectMapper mapper = new ObjectMapper();

  private static final String sql =
      "INSERT into "
          + USER_QUESTIONNAIRE_TABLE
          + "(child_id,questionnaire_jsonb) VALUES (?,?::json)";

  private static final String get_sql =
      "Select questionnaire_jsonb from " + USER_QUESTIONNAIRE_TABLE + " where child_id=?";

  @Autowired private DataSource dataSource;

  public void insertQuestionnaireBlob(final String id, final String payload) {
    try {
      PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
      preparedStatement.setString(1, id);
      preparedStatement.setString(2, payload);
      preparedStatement.execute();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  public List<Child> getChildQuestionnaires(String childId) {
    List<Child> children = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(get_sql);
      preparedStatement.setString(1, childId);
      ResultSet ret = preparedStatement.executeQuery();
      while (ret.next()) {
        children.add(convertToChildObj(ret.getString("questionnaire_jsonb")));
      }
    } catch (Exception throwables) {
      throwables.printStackTrace();
    }
    return children;
  }

  public List<FormSubmission> getFormSubmissions(String childId) {
    List<FormSubmission> submissions = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(get_sql);
      preparedStatement.setString(1, childId);
      ResultSet ret = preparedStatement.executeQuery();
      while (ret.next()) {
        String json = ret.getString("questionnaire_jsonb");
        Child child = mapper.readValue(json, Child.class);
        Safety safety = mapper.readValue(json, Safety.class);
        Health health = mapper.readValue(json, Health.class);
        Education education = mapper.readValue(json, Education.class);

        submissions.add(new FormSubmission(child, safety, health, education));
      }
    } catch (Exception throwables) {
      throwables.printStackTrace();
    }
    return submissions;
  }

  private Child convertToChildObj(final String questionnaireJSONb) throws JsonProcessingException {
    return mapper.readValue(questionnaireJSONb, Child.class);
  }

  @PostConstruct
  private void initialize() {
    try {
      String sql =
          "CREATE TABLE IF NOT EXISTS "
              + USER_QUESTIONNAIRE_TABLE
              + " ( id SERIAL PRIMARY KEY, child_id varchar(45), questionnaire_jsonb JSONB NOT NULL )";
      dataSource.getConnection().prepareStatement(sql).execute();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}
