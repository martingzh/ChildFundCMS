package org.childfund.service;

import com.google.gson.JsonArray;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

  private static final String USER_QUESTIONNAIRE_TABLE = "user_questionnaire";

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

  public String getQuestionnaireBlob(String childId) {
    JsonArray jsonArray = new JsonArray();
    try {
      PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(get_sql);
      preparedStatement.setString(1, childId);
      ResultSet ret = preparedStatement.executeQuery();
      while (ret.next()) {
        jsonArray.add(ret.getString("questionnaire_jsonb"));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return jsonArray.toString();
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
