package com.sapient.assessment.data.reference;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum MaturityRating {
    REGRESSIVE(4, "Regressive (-1)", -1),
    REPEATABLE(5, "Repeatable (0)", 0),
    CONSISTENT(1, "Consistent (1)", 1),
    QUANTITATIVELY_MEASURED(3, "Quantitatively Measured (2)",2),
    OPTIMIZING(2, "Optimizing (3)", 3)
    ;

    private final int id;
    private final String description;
    private final int ratingScore;

    MaturityRating(int id, String description, int ratingScore) {
        this.id = id;

        this.description = description;
        this.ratingScore = ratingScore;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    public int getRatingScore() {
        return ratingScore;
    }

    public static MaturityRating byId(int id){
        for (MaturityRating maturityRating : values()) {
            if (maturityRating.ratingScore == id){
                return maturityRating;
            }

        }
        throw new RuntimeException("nothing");
    }
}