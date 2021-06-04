package org.childfund.models;

public class FormSubmission {
  private final Child child;
  private final Safety safety;
  private final Health health;
  private final Education education;

  public FormSubmission(Child child, Safety safety, Health health, Education education) {
    this.child = child;
    this.safety = safety;
    this.health = health;
    this.education = education;
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

  public String getSubmissionTime() {
    return child.getSubmissionTime();
  }
}
