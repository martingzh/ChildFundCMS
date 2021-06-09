package org.childfund.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.childfund.models.Child;

public interface ImmediateAttentionChildren {

  public List<Child> getRecentSurveyedChildren(int numberOfDaysToGoBack);

  public List<Child> getRecentSurveyedChildren(
          LocalDateTime startDateOfSubmission);
}
