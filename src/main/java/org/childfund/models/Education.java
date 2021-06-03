package org.childfund.models;

import java.time.LocalDate;
import java.util.List;

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
  private List<Score> scores;

  public Education(SchoolStatus status, List<Score> scores) {
    this.status = status;
    this.scores = scores;
  }

  public SchoolStatus getStatus() {
    return status;
  }

  public List<Score> getScores() {
    return scores;
  }

  public static class Score {
    private final LocalDate date;
    private final int score;

    public Score(LocalDate date, int score) {
      this.date = date;
      this.score = score;
    }

    public LocalDate getDate() {
      return date;
    }

    public int getScore() {
      return score;
    }
  }
}
