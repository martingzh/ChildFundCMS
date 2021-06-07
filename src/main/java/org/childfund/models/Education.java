package org.childfund.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.Nullable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Education {

  public enum SchoolStatus {
    IN_SCHOOL("In School", "yes"),
    NOT_IN_SCHOOL("Not in School", "no"),
    UNSURE("Not Sure/Don't Know", "not_sure"),
    NOT_ANSWERED("Chose not to Answer", "chose_not_to_answer");

    private final String displayText;
    private final String choiceValue;

    SchoolStatus(String displayText, String choiceValue) {
      this.displayText = displayText;
      this.choiceValue = choiceValue;
    }

    public String getDisplayText() {
      return displayText;
    }

    public static SchoolStatus getFromJson(String jsonValue) {
      for (SchoolStatus status : values()) {
        if (status.choiceValue.equals(jsonValue)) {
          return status;
        }
      }
      return NOT_ANSWERED;
    }
  }

  public enum NonAttendanceReason {
    NO_SCHOOL("We do not have a school here", "no_school_available"),
    TOO_FAR("Would have to travel far to reach a school", "school_too_far"),
    TOO_EXPENSIVE("Family cannot afford to send me to school", "school_too_expensive"),
    WORK("Must stay home to help with household chores, work or care for others", "needed_at_home"),
    DISABILITY("Cannot attend because of my disability", "disability"),
    PREGNANCY("Cannot attend school because of my pregnancy", "pregnancy"),
    SAFETY("I worry about my safety at school or traveling to and from school", "safety"),
    GRADUATED("I have graduated", "graduated"),
    NO_OPTIONS("There are no options for primary or secondary school here", "no_options"),
    NOT_IMPORTANT("Attending school is not important to me or to my parents", "not_important"),
    FAMILY("Cannot attend school because I have to work to help my family", "working"),
    OTHER("Other", "other"),
    UNSURE("Not Sure/Don't Know", "not_sure"),
    NOT_ANSWERED("Chose not to answer", "chose_not_to_answer");

    private final String displayText;
    private final String choiceValue;

    NonAttendanceReason(String displayText, String choiceValue) {
      this.displayText = displayText;
      this.choiceValue = choiceValue;
    }

    public String getDisplayText() {
      return displayText;
    }

    public static NonAttendanceReason getFromJson(String jsonValue) {
      for (NonAttendanceReason reason : values()) {
        if (reason.choiceValue.equals(jsonValue)) {
          return reason;
        }
      }
      return NOT_ANSWERED;
    }
  }

  public enum SchoolType {
    PRIVATE("Private", "private"),
    PUBLIC("Public", "public"),
    OTHER("Other", "other");

    private final String displayText;
    private final String choiceValue;

    SchoolType(String displayText, String choiceValue) {
      this.displayText = displayText;
      this.choiceValue = choiceValue;
    }

    public String getDisplayText() {
      return displayText;
    }

    public static SchoolType getFromJson(String jsonValue) {
      for (SchoolType status : values()) {
        if (status.choiceValue.equals(jsonValue)) {
          return status;
        }
      }
      return null;
    }
  }

  public enum Grade {
    PRE_KINDERGARTEN("Pre-Kindergarten", "pre_kindergarten"),
    KINDERGARTEN("Kindergarten", "kindergarten"),
    FIRST("1st Grade", "1"),
    SECOND("2nd Grade", " 2"),
    THIRD("3rd Grade", "3"),
    FOURTH("4th Grade", "4"),
    FIFTH("5th Grade", "5"),
    SIXTH("6th Grade", "6"),
    SEVENTH("7th Grade", "7"),
    SECONDARY("Secondary School", "secondary_school"),
    VOCATIONAL("Vocational School", "vocational_school"),
    COLLEGE("Community College/University", "community_college_university"),
    NOT_SURE("Not Sure/Don't Know", "not_sure"),
    NOT_ANSWERED("Chose not to answer", "chose_not_to_answer");

    private final String displayText;
    private final String choiceValue;

    Grade(String displayText, String choiceValue) {
      this.displayText = displayText;
      this.choiceValue = choiceValue;
    }

    public String getDisplayText() {
      return displayText;
    }

    public static Grade getFromJson(String jsonValue) {
      for (Grade grade : values()) {
        if (grade.choiceValue.equals(jsonValue)) {
          return grade;
        }
      }
      return null;
    }
  }

  @JsonProperty("group_education/Child_In_School")
  private String status;

  @Nullable
  @JsonProperty("group_education/School_Not_Attending")
  private String reason;

  @Nullable
  @JsonProperty("group_education/School_Type")
  private String type;

  @Nullable
  @JsonProperty("group_education/School_Grade")
  private String grade;

  public void setStatus(String status) {
    this.status = status;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public SchoolStatus getStatus() {
    return SchoolStatus.getFromJson(status);
  }

  public NonAttendanceReason getReason() {
    return NonAttendanceReason.getFromJson(reason);
  }

  @Nullable
  public SchoolType getType() {
    return SchoolType.getFromJson(type);
  }

  @Nullable
  public Grade getGrade() {
    return Grade.getFromJson(grade);
  }
}
