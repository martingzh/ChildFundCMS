package org.childfund.models;

import java.time.LocalDate;

public class Score {

    private final LocalDate date;
    private final int safety;
    private final int health;
    private final int education;
    private final int participation;

    public Score(
            LocalDate date,
            int safety,
            int health,
            int education,
            int participation
    ) {
        this.date = date;
        this.safety = safety;
        this.health = health;
        this.education = education;
        this.participation = participation;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getSafety() {
        return safety;
    }

    public int getHealth() {
        return health;
    }

    public int getEducation() {
        return education;
    }

    public int getParticipation() {
        return participation;
    }

}
