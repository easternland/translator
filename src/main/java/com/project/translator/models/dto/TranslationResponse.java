package com.project.translator.models.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record TranslationResponse(
        @NotNull
        String translation,
        @NotNull
        WordInfo wordInfo
){}