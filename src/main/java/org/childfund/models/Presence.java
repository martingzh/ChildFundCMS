package org.childfund.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Presence {

  public enum PresenceStatus {
    PRESENT("Yes", "yes"),
    NOT_PRESENT("No", "no"),
    INTERVIEW_REFUSED("Child or caregiver refuses interview", "interview_refused");

    private final String displayText;
    private final String choiceValue;

    PresenceStatus(String displayText, String choiceValue) {
      this.displayText = displayText;
      this.choiceValue = choiceValue;
    }

    public String getDisplayText() {
      return displayText;
    }

    public static PresenceStatus getFromJson(String jsonValue) {
      for (PresenceStatus status : values()) {
        if (status.choiceValue.equals(jsonValue)) {
          return status;
        }
      }
      return null;
    }
  }

  public enum NotPresentReason {
    IN_BOARDING_SCHOOL("In boarding school", "boarding_school"),
    ABSENT_BUT_RETURNING(
        "is temporarily absent from the community, but due to return", "temporary_absence"),
    NO_LONGER_PRESENT("is no longer present in the community", "no_longer_present"),
    DECEASED("is deceased", "deceased"),
    IN_COMMUNITY(
        "Child was not verified during visit, but is present in the community",
        "present_unverified"),
    UNKNOWN("Child's presence unknown", "presence_unknown");

    private final String displayText;
    private final String choiceValue;

    NotPresentReason(String displayText, String choiceValue) {
      this.displayText = displayText;
      this.choiceValue = choiceValue;
    }

    public String getDisplayText() {
      return displayText;
    }

    public static NotPresentReason getFromJson(String jsonValue) {
      for (NotPresentReason reason : values()) {
        if (reason.choiceValue.equals(jsonValue)) {
          return reason;
        }
      }
      return null;
    }
  }

  @JsonProperty("group_interview/Child_Present_In_Community")
  private String status;

  public void setStatus(String status) {
    this.status = status;
  }

  public PresenceStatus getStatus() {
    return PresenceStatus.getFromJson(status);
  }

  public NotPresentReason getReason() {
    return NotPresentReason.getFromJson(status);
  }
}
