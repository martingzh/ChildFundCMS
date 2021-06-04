package org.childfund.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.tomcat.util.json.JSONParser;
import org.childfund.models.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class UserService {

  @Autowired private UserDao userDao;
  public static final String DATE_FORMATTER = "yyyy-MM-dd'T'HH:mm:ss";

  private ObjectMapper mapper = new ObjectMapper();

  public void storeQuestionnaire(String payload) {
    String id = getChildId(payload);
    userDao.insertQuestionnaireBlob(id, payload);
  }

  public Child getChildById(String childId) {
    List<Child> childInfo = userDao.getChildAllQuestionnaires(childId);
    if (CollectionUtils.isEmpty(childInfo)) {
      return new Child();
    }
    Child child = getChildByLatestSubmission(childInfo);
    return child;
  }

  private Child getChildByLatestSubmission(List<Child> childInfos) {
    childInfos.sort(this::sortBySubmissionDate);
    return childInfos.get(0);
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

  private int sortBySubmissionDate(Child child1, Child child2) {
    try {
      long lDate1 = DateUtils.parseDate(child1.getSubmissionTime(), DATE_FORMATTER).getTime();
      long lDate2 = DateUtils.parseDate(child2.getSubmissionTime(), DATE_FORMATTER).getTime();
      return lDate2 > lDate1 ? 1 : -1;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0;
  }

  public List<Child> getAllChildrenData() {
    return userDao.getAllChildrenData();
  }

  public String getAllChildQuestionnaires(String childId) {

    List<Child> childInfo = userDao.getChildAllQuestionnaires(childId);
    try {
      return mapper.writeValueAsString(childInfo);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return "";
  }
}
