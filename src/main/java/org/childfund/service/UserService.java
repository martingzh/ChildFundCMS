package org.childfund.service;

<<<<<<< HEAD
import org.childfund.models.Child;
import org.childfund.models.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

=======
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

>>>>>>> 84f4404... Integration with postgres - part2
@Component
public class UserService implements CrudRepository<Child, Community> {

  private ObjectMapper objectMapper = new ObjectMapper();
  @Autowired private UserDao userDao;

  public void storeQuestionnaire(String payload) {
    String id = getChildId(payload);
    userDao.insertQuestionnaireBlob(id, payload);
  }

  private String getChildId(String payload) {
    String childId = "N/A";
    JSONParser parser = new JSONParser(payload);
    try {
      childId = parser.object().get("group_childInfo/Child_number").toString();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
<<<<<<< HEAD


    @Override
    public String create(Child child) {
        return null;
    }

    @Override
    public Child get(String Id) {
        return null;
    }

    @Override
    public List<Child> getAll() {
        return null;
    }

    @Override
    public void update(Child child, String[] params) {

    }

    @Override
    public void delete(String Id) {

    }
=======
    return childId;
  }
>>>>>>> 84f4404... Integration with postgres - part2
}
