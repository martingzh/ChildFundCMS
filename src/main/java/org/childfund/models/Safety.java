package org.childfund.models;

import org.springframework.lang.Nullable;

public class Safety {
  private final boolean lifeThreateningSituation;
  @Nullable private final String situationDescription;
  @Nullable private final String actionTaken;

  public Safety(
      boolean lifeThreateningSituation,
      @Nullable String situationDescription,
      @Nullable String actionTaken) {
    this.lifeThreateningSituation = lifeThreateningSituation;
    this.situationDescription = situationDescription;
    this.actionTaken = actionTaken;
  }

  public boolean getLifeThreateningSituation() {
    return lifeThreateningSituation;
  }

  @Nullable
  public String getSituationDescription() {
    return situationDescription;
  }

  @Nullable
  public String getActionTaken() {
    return actionTaken;
  }
}
