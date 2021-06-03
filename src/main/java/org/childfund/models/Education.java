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


    private SchoolStatus status;

    public Education(
            SchoolStatus status
    ) {
        this.status = status;
    }

    public SchoolStatus getStatus() {
        return status;
    }
}
