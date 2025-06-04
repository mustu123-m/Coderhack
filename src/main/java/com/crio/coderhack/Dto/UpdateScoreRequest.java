package com.crio.coderhack.Dto;

//package com.crio.coderhack.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = false) // ❌ Reject unknown fields
public class UpdateScoreRequest {

    @NotNull(message = "Score is required")
    private Integer score;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
