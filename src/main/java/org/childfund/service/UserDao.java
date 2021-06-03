package org.childfund.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

  private static final String sql =
      "INSERT into questionnaires set child_id=?, questionnaire_blob=?";

  @Autowired private DataSource dataSource;

  public void insertQuestionnaireBlob(final String id, final String payload) {
    try {
      PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
      preparedStatement.setString(1, id);
      preparedStatement.setString(2, payload);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  @PostConstruct
  private void initialize() {
    try {
      String sql =
          "CREATE TABLE IF NOT EXISTS user_questionnaire ( child_id varchar(45) PRIMARY KEY, questionnaire JSONB NOT NULL )";
      dataSource.getConnection().prepareStatement(sql).execute();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}
