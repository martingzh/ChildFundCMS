package org.childfund.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Child {

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Attachment {
    @JsonProperty("download_url")
    private String url;

    public void setUrl(String url) {
      this.url = url;
    }

    public String getUrl() {
      return url;
    }
  }

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

  @JsonProperty("group_childInfo/Child_number")
  private String id;

  @JsonProperty("group_childInfo/Child_first_name")
  private String firstName;

  @JsonProperty("group_childInfo/Child_other_name")
  private String otherName;

  @JsonProperty("group_childInfo/Child_Age")
  private Integer age;

  @JsonProperty("group_childInfo/Child_date_of_birth")
  private String dateOfBirth;

  @JsonProperty("group_childInfo/Child_Sex")
  private String sex;

  @JsonProperty("group_childInfo/Child_Life_Stage")
  private String lifeStageString;

  @JsonProperty("group_general/Village")
  private String village;

  @JsonProperty("group_education/Child_In_School")
  private String school;

  @JsonProperty("group_education/School_Grade")
  private String grade;

  @JsonProperty("group_childInfo/Child_Cluster_Family_Group")
  private String family;

  @JsonProperty("_attachments")
  private List<Attachment> attachments;

  @JsonProperty("_submission_time")
  private String submissionTime;

  @JsonProperty("group_general/Local_Partner_Name")
  private String partnerName;

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

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public String getSex() {
    return sex;
  }

  public LifeStage getLifeStage() {
    return LifeStage.getFromJson(lifeStageString);
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

  public String getPartnerName() {
    return partnerName;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setOtherName(String otherName) {
    this.otherName = otherName;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getLifeStageString() {
    return lifeStageString;
  }

  public void setLifeStageString(String lifeStageString) {
    this.lifeStageString = lifeStageString;
  }

  public String getSubmissionTime() {
    return submissionTime;
  }

  public void setSubmissionTime(String submissionTime) {
    this.submissionTime = submissionTime;
  }

  public void setVillage(String village) {
    this.village = village;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public void setFamily(String family) {
    this.family = family;
  }

  public void setPartnerName(String partnerName) {
    this.partnerName = partnerName;
  }

  public List<Attachment> getAttachments() {
    return attachments;
  }

  public String getPhotoUrl() {
    if (attachments != null && !attachments.isEmpty()) {
      return attachments.get(0).url;
    }
    return null;
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
