package org.childfund.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.Nullable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Health {

  @JsonProperty("group_health/Healthy")
  private String satisfactory;

  @Nullable
  @JsonProperty("group_health/Health_Issue")
  private String healthSituation;

  @Nullable
  @JsonProperty("group_health/Health_Issue_Remediation")
  private String healthRemediation;

  @Nullable
  @JsonProperty("group_interview/immunized")
  private String immunized;

  @Nullable
  @JsonProperty("group_interview/Date_of_immunization")
  private String immunizationDate;

  @Nullable
  @JsonProperty("group_interview/Nutrition_Counselling")
  private String nutritionAssessment;

  public boolean getSatisfactory() {
    return satisfactory.equalsIgnoreCase("yes");
  }

  @Nullable
  public String getHealthSituation() {
    return healthSituation;
  }

  @Nullable
  public String getHealthRemediation() {
    return healthRemediation;
  }

  @Nullable
  public boolean getImmunized() {
    return immunized != null && immunized.equalsIgnoreCase("yes");
  }

  @Nullable
  public String getImmunizationDate() {
    return immunizationDate;
  }

  @Nullable
  public boolean getNutritionAssessment() {
    return nutritionAssessment != null && nutritionAssessment.equalsIgnoreCase("yes");
  }
}
