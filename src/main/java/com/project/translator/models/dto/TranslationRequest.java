package com.project.translator.models.dto;

import com.project.translator.entity.Language;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

public record TranslationRequest(
        @NotNull
        Language sourceLanguage,
        @NotNull
        Language targetLanguage,
        @NotNull
        String sourceWord,
        @Nullable
        String instructions,
        @Nullable
        String adaptation
){}