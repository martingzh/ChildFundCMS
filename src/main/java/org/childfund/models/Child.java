package org.childfund.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Child {

  public enum LifeStage {
    LS1("LS1 (Age 0-5)", "lifeStage1"),
    LS2("LS2 (Age 6-14)", "lifeStage2"),
    LS3("LS3 (Age 15-24)", "lifeStage3"),
    Adults("Adult", "adult");

    private final String displayText;
    private final String choiceValue;

    private LifeStage(String displayText, String choiceValue) {
      this.displayText = displayText;
      this.choiceValue = choiceValue;
    }

    public String getDisplayText() {
      return displayText;
    }

    public String getChoiceValue() {
      return choiceValue;
    }

    public static LifeStage getFromJson(String jsonValue) {
      for (LifeStage stage : values()) {
        if (stage.choiceValue.equals(jsonValue)) {
          return stage;
        }
      }
      return LifeStage.LS1;
    }
  }

  private final String id;
  private final String firstName;
  private final String otherName;
  private final Integer age;
  private final LocalDate dateOfBirth;
  private final String sex;
  private final LifeStage lifeStage;
  private final String village;
  private final String school;
  private final String grade;
  private final String family;
  private final LocalDateTime updated;

  public Child(
      String id,
      String firstName,
      String otherName,
      Integer age,
      LocalDate dateOfBirth,
      String sex,
      LifeStage lifeStage,
      String village,
      String school,
      String grade,
      String family,
      LocalDateTime updated) {
    this.id = id;
    this.firstName = firstName;
    this.otherName = otherName;
    this.age = age;
    this.dateOfBirth = dateOfBirth;
    this.sex = sex;
    this.lifeStage = lifeStage;
    this.village = village;
    this.school = school;
    this.grade = grade;
    this.family = family;
    this.updated = updated;
  }

  public String getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getOtherName() {
    return otherName;
  }

  public Integer getAge() {
    return age;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public String getSex() {
    return sex;
  }

  public LifeStage getLifeStage() {
    return lifeStage;
  }

  public String getVillage() {
    return village;
  }

  public String getSchool() {
    return school;
  }

  public String getGrade() {
    return grade;
  }

  public String getFamily() {
    return family;
  }

  public LocalDateTime getUpdated() {
    return updated;
  }

  public String getName() {
    StringBuilder builder = new StringBuilder();
    builder.append(firstName);
    if (otherName != null) {
      builder.append(" ").append(otherName);
    }
    return builder.toString();
  }
}
