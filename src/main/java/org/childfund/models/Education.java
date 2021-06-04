package org.childfund.models;

public class Education {

  public enum SchoolStatus {
    IN_SCHOOL("In School"),
    NOT_IN_SCHOOL("Not in School"),
    UNSURE("Not Sure/Don't Know"),
    NOT_ANSWERED("Chose not to Answer");

    private final String displayText;

    private SchoolStatus(String displayText) {
      this.displayText = displayText;
    }

    public String getDisplayText() {
      return displayText;
    }
  }

  public enum NonAttendanceReason {
    NO_SCHOOL("We do not have a school here"),
    TOO_FAR("Would have to travel far to reach a school"),
    TOO_EXPENSIVE("Family cannot afford to send me to school"),
    WORK("Must stay home to help with household chores, work or care for others"),
    DISABILITY("Cannot attend because of my disability"),
    PREGNANCY("Cannot attend school because of my pregnancy"),
    SAFETY("I worry about my safety at school or traveling to and from school"),
    GRADUATED("I have graduated"),
    NO_OPTIONS("There are no options for primary or secondary school here"),
    NOT_IMPORTANT("Attending school is not important to me or to my parents"),
    FAMILY("Cannot attend school because I have to work to help my family"),
    OTHER("Other"),
    UNSURE("Not Sure/Don't Know"),
    NOT_ANSWERED("Chose not to answer");

    private final String displayText;

    NonAttendanceReason(String displayText) {
      this.displayText = displayText;
    }

    public String getDisplayText() {
      return displayText;
    }
  }

  private final SchoolStatus status;
  private final NonAttendanceReason reason;

  public Education(SchoolStatus status, NonAttendanceReason reason) {
    this.status = (status == null) ? SchoolStatus.NOT_ANSWERED : status;
    this.reason = (reason == null) ? NonAttendanceReason.NOT_ANSWERED : reason;
  }

  public SchoolStatus getStatus() {
    return status;
  }

  public NonAttendanceReason getReason() {
    return reason;
  }
}
