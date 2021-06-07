package org.childfund.models;

public class FormSubmission {
  private final Child child;
  private final Safety safety;
  private final Health health;
  private final Education education;
  private final Participation participation;

  public FormSubmission(
      Child child, Safety safety, Health health, Education education, Participation participation) {
    this.child = child;
    this.safety = safety;
    this.health = health;
    this.education = education;
    this.participation = participation;
  }

  public Child getChild() {
    return child;
  }

  public Safety getSafety() {
    return safety;
  }

  public Health getHealth() {
    return health;
  }

  public Education getEducation() {
    return education;
  }

  public Participation getParticipation() {
    return participation;
  }

  public String getSubmissionTime() {
    return child.getSubmissionTime();
  }
}
