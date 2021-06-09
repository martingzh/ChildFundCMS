package org.childfund.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.childfund.models.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImmediateAttentionChildrenImpl implements ImmediateAttentionChildren {


  @Autowired
  private UserDao userDao;

  public List<Child> getRecentSurveyedChildren(int numberOfDaysToGoBack) {
    return getRecentSurveyedChildren(LocalDateTime.now().minusDays(numberOfDaysToGoBack));
  }

  public List<Child> getRecentSurveyedChildren(
      LocalDateTime startDateOfSubmission) {
    return userDao.getAllImmediateAttentionChildren(startDateOfSubmission);
  }
}
