package org.childfund.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import org.apache.tomcat.jni.Local;
import org.childfund.models.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.childfund.models.Partner.LocalPartner;


@Service
public class ImmediateAttentionChildrenImpl implements ImmediateAttentionChildren {

  @Autowired private UserDao userDao;

  public List<Child> getRecentSurveyedChildren(int numberOfDaysToGoBack) {
    return getRecentSurveyedChildren(LocalDateTime.now().minusDays(numberOfDaysToGoBack));
  }

  public List<Child> getRecentSurveyedChildren(LocalDateTime startDateOfSubmission) {
    return userDao.getAllImmediateAttentionChildren(startDateOfSubmission);
  }

  public List<Child> createHardCodedImmediateAttentionChildren() {
    String idKey = "001";
    ArrayList<Child> children = new ArrayList<Child>();
    Random randomGen = new Random();

    // Two children for each local partner
    for (LocalPartner partner : LocalPartner.values()) {
      Child firstChild = new Child();
      firstChild.setId(idKey + "1" + partner.toString());
      firstChild.setFirstName(getRandomString());
      firstChild.setAge(randomGen.nextInt(10));
      firstChild.setDateOfBirth("2015-01-16");
      firstChild.setSex("Male");
      firstChild.setVillage("San Francisco");
      firstChild.setSchool("San Francisco High");
      firstChild.setFamily("Winston");
      firstChild.setPartnerName(partner.getValue());

      Child secondChild = new Child();
      secondChild.setId(idKey + "5" + partner.toString());
      secondChild.setFirstName(getRandomString());
      secondChild.setAge(randomGen.nextInt(10));
      secondChild.setDateOfBirth("2014-01-16");
      secondChild.setSex("Female");
      secondChild.setVillage("Oakland");
      secondChild.setSchool("Oakland High");
      secondChild.setFamily("Brees");
      secondChild.setPartnerName(partner.getValue());

      children.add(firstChild);
      children.add(secondChild);
    }
    return children;
  }

  private String getRandomString() {
    String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    StringBuilder salt = new StringBuilder();
    Random rnd = new Random();
    while (salt.length() < 8) { // length of the random string.
      int index = (int) (rnd.nextFloat() * SALTCHARS.length());
      salt.append(SALTCHARS.charAt(index));
    }
    String saltStr = salt.toString();
    return saltStr;

  }

}
