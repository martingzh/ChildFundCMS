package com.example.demo.models;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Child {

    private final String id;
    private final String firstName;
    private final String otherName;
    private final Integer age;
    private final LocalDate dateOfBirth;
    private final String sex;
    private final String lifeStage;
    private final String village;
    private final String school;
    private final String grade;
    private final String family;
    private final LocalDateTime updated;

    public Child(String id,
                 String firstName,
                 String otherName,
                 Integer age,
                 LocalDate dateOfBirth,
                 String sex,
                 String lifeStage,
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

    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getOtherName() { return otherName; }
    public Integer getAge() { return age; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public String getSex() { return sex; }
    public String getLifeStage() { return lifeStage;}
    public String getVillage() { return village; }
    public String getSchool() { return school; }
    public String getGrade() { return grade; }
    public String getFamily() { return family; }
    public LocalDateTime getUpdated() { return updated; }

    public String getName() {
        StringBuilder builder = new StringBuilder();
        builder.append(firstName);
        if (otherName != null) {
            builder.append(" ").append(otherName);
        }
        return builder.toString();
    }
}
