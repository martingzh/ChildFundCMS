package org.childfund.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.Nullable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Safety {
  @JsonProperty("group_health/Danger")
  private String lifeThreateningSituation;

  @Nullable
  @JsonProperty("group_health/Danger_Situation")
  private String situationDescription;

  @Nullable
  @JsonProperty("group_health/Danger_Situation_Remediation")
  private String actionTaken;

  public void setLifeThreateningSituation(String lifeThreateningSituation) {
    this.lifeThreateningSituation = lifeThreateningSituation;
  }

  public String getLifeThreateningSituation() {
    return lifeThreateningSituation;
  }

  public boolean isLifeThreatened() {
    return lifeThreateningSituation.equalsIgnoreCase("yes");
  }

  public void setSituationDescription(String situationDescription) {
    this.situationDescription = situationDescription;
  }

  @Nullable
  public String getSituationDescription() {
    return situationDescription;
  }

  public void setActionTaken(String actionTaken) {
    this.actionTaken = actionTaken;
  }

  @Nullable
  public String getActionTaken() {
    return actionTaken;
  }
}
