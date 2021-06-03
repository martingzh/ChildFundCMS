package org.childfund.models;

import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.List;

public class Health {

    private final boolean satisfactory;
    @Nullable
    private final String healthSituation;
    @Nullable
    private final String healthRemediation;
    @Nullable
    final Boolean immunized;
    @Nullable
    private final LocalDate immunizationDate;
    @Nullable
    private final Boolean nutritionAssessment;
    private final List<Score> scores;

    public Health(
            boolean satisfactory,
            @Nullable String healthSituation,
            @Nullable String healthRemediation,
            @Nullable Boolean immunized,
            @Nullable LocalDate immunizationDate,
            @Nullable Boolean nutritionAssessment,
            List<Score> scores
    ) {
        this.satisfactory = satisfactory;
        this.healthSituation = healthSituation;
        this.healthRemediation = healthRemediation;
        this.immunized = immunized;
        this.immunizationDate = immunizationDate;
        this.nutritionAssessment = nutritionAssessment;
        this.scores = scores;
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

    public List<Score> getScores() {
        return scores;
    }

    public static class Score {
        private final LocalDate date;
        private final int score;

        public Score(LocalDate date, int score) {
            this.date = date;
            this.score = score;
        }

        public LocalDate getDate() {
            return date;
        }

        public int getScore() {
            return score;
        }
    }
}
