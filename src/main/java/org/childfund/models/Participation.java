package org.childfund.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Participation {

  enum Benefit {
    RELEVANT_TO_LIFE_STAGE(
        "Child participated in a ChildFund-supported activity relevant to his or her Life Stage",
        "activity_relevant_to_life_stage"),
    POSITIVE_CHANGE(
        "Caregiver participated in a ChildFund-supported activity to make a positive change in the child's life",
        "activity_positive_change"),
    PEOPLE_OR_INSTITUTIONS(
        "People or institutions responsible for education, health, protection, or well-being participated in a ChildFund-supported activity",
        "people_or_institutions"),
    PHYSICAL_ENVIRONMENT(
        "ChildFund supported an activity to make a positive change in the physical environment or community",
        "actvivity_physical_environment"),
    ACCESS_TO_SERVICES(
        "ChildFund supported an activity to improve access to services", "activity_service_access"),
    NONE("Not since July 1, 2019", "none");

    private final String displayText;
    private final String choiceValue;

    Benefit(String displayText, String choiceValue) {
      this.displayText = displayText;
      this.choiceValue = choiceValue;
    }

    public String getDisplayText() {
      return displayText;
    }

    public static Benefit getFromJson(String jsonValue) {
      for (Benefit benefit : values()) {
        if (benefit.choiceValue.equals(jsonValue)) {
          return benefit;
        }
      }
      return NONE;
    }
  }

  enum Activity {
    PARENTING_WORKSHOPS("Parenting workshops", "parenting_workshops"),
    CHILDRENS_CLUBS("Children's clubs", "childrens_clubs"),
    YOUTH_CLUBS("Youth clubs", "youth_clubs"),
    SCHOOL_GOVERNANCE("School governance/ Leadership", "school_governance"),
    HEALTH_SERVICES("Health services", "health_services"),
    VIOLENCE_PREVENTION("School Based violence prevention", "school_based_violence_prevention"),
    CHILD_PROTECTION("Child Protection", "child_protection"),
    DISASTER_PREPAREDNESS("Disaster preparedness/ Risk reduction", "disaster_preparedness"),
    EMERGENCY_RESPONSE("Emergency Response", "emergency_response"),
    LIVELIHOOD("Livelihood", "livelihood"),
    LIFE_SKILLS("Life Skills", "life_skills"),
    WASH("Wash", "wash"),
    COMMUNITY_ADVOCACY("Community Advocacy", "community_advocacy"),
    OTHER("Other", "other");

    private final String displayText;
    private final String choiceValue;

    Activity(String displayText, String choiceValue) {
      this.displayText = displayText;
      this.choiceValue = choiceValue;
    }

    public String getDisplayText() {
      return displayText;
    }

    public static Activity getFromJson(String jsonValue) {
      for (Activity activity : values()) {
        if (activity.choiceValue.equals(jsonValue)) {
          return activity;
        }
      }
      return OTHER;
    }
  }

  @JsonProperty("group_interview/Benefit_Activities")
  private String benefited;

  @JsonProperty("group_interview/Reason_for_non_participation")
  private String reason;

  @JsonProperty("group_interview/Participated_Activities")
  private String activities;

  public void setBenefited(String benefited) {
    this.benefited = benefited;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public void setParticipatedActivities(String activities) {
    this.activities = activities;
  }

  public List<Benefit> getBenefits() {
    if (benefited == null) {
      return Collections.emptyList();
    }
    return Arrays.stream(benefited.split(" "))
        .map(Benefit::getFromJson)
        .collect(Collectors.toList());
  }

  public String getNonParticipationReason() {
    return reason;
  }

  public List<Activity> getParticipatedActivities() {
    if (activities == null) {
      return Collections.emptyList();
    }
    return Arrays.stream(activities.split(" "))
        .map(Activity::getFromJson)
        .collect(Collectors.toList());
  }
}
