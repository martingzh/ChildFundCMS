package org.childfund.models;

import java.time.LocalDate;
import org.springframework.lang.Nullable;

public class Health {

  private final boolean satisfactory;
  @Nullable private final String healthSituation;
  @Nullable private final String healthRemediation;
  @Nullable final Boolean immunized;
  @Nullable private final LocalDate immunizationDate;
  @Nullable private final Boolean nutritionAssessment;

  public Health(
      boolean satisfactory,
      @Nullable String healthSituation,
      @Nullable String healthRemediation,
      @Nullable Boolean immunized,
      @Nullable LocalDate immunizationDate,
      @Nullable Boolean nutritionAssessment) {
    this.satisfactory = satisfactory;
    this.healthSituation = healthSituation;
    this.healthRemediation = healthRemediation;
    this.immunized = immunized;
    this.immunizationDate = immunizationDate;
    this.nutritionAssessment = nutritionAssessment;
  }

  public boolean getSatisfactory() {
    return satisfactory;
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
  public Boolean getImmunized() {
    return immunized;
  }

  @Nullable
  public LocalDate getImmunizationDate() {
    return immunizationDate;
  }

  @Nullable
  public Boolean getNutritionAssessment() {
    return nutritionAssessment;
  }
}
