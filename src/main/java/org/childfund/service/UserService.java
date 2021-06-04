package org.childfund.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.tomcat.util.json.JSONParser;
import org.childfund.models.Child;
import org.childfund.models.Community;
import org.childfund.models.FormSubmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService implements CrudRepository<Child, Community> {

  @Autowired private UserDao userDao;
  public static final String DATE_FORMATTER = "yyyy-MM-dd'T'HH:mm:ss";

  private ObjectMapper mapper = new ObjectMapper();

  public void storeQuestionnaire(String payload) {
    String id = getChildId(payload);
    userDao.insertQuestionnaireBlob(id, payload);
  }

  public Child getChildQuestionnaire(String childId) throws JsonProcessingException {
    List<Child> childInfo = userDao.getChildQuestionnaires(childId);
    Child child = getLatestSubmission(childInfo);
    return child;
  }

  public FormSubmission getLatestSubmission(String childId) {
    List<FormSubmission> submissions = userDao.getFormSubmissions(childId);
    submissions.sort(this::sortBySubmissionDate);
    return submissions.get(0);
  }

  private Child getLatestSubmission(List<Child> childInfos) {
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

  private int sortBySubmissionDate(FormSubmission child1, FormSubmission child2) {
    try {
      long lDate1 = DateUtils.parseDate(child1.getSubmissionTime(), DATE_FORMATTER).getTime();
      long lDate2 = DateUtils.parseDate(child2.getSubmissionTime(), DATE_FORMATTER).getTime();
      return lDate2 > lDate1 ? 1 : -1;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0;
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

  public String getAllChildQuestionnaires(String childId) {

    List<Child> childInfo = userDao.getChildQuestionnaires(childId);
    try {
      return mapper.writeValueAsString(childInfo);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return "";
  }
}
