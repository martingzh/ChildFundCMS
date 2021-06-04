package org.childfund.service;

import java.util.List;
import org.apache.tomcat.util.json.JSONParser;
import org.childfund.models.Child;
import org.childfund.models.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService implements CrudRepository<Child, Community> {

  @Autowired private UserDao userDao;

  public void storeQuestionnaire(String payload) {
    String id = getChildId(payload);
    userDao.insertQuestionnaireBlob(id, payload);
  }

  public String getQuestionnaire(String childId) {
    return userDao.getQuestionnaireBlob(childId);
  }

  private String getChildId(String payload) {
    String childId = "N/A";
    JSONParser parser = new JSONParser(payload);
    try {
      childId = parser.object().get("group_childInfo/Child_number").toString();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return childId;
  }

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
  public void update(Child child, String[] params) {}

  @Override
  public void delete(String Id) {}
}
