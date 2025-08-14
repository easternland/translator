package com.project.translator.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Language {
    ru_RU,
    en_US;

    @JsonCreator
    public static Language fromJson(String shortCode) {
        return switch (shortCode.toLowerCase()) {
            case "ru" -> ru_RU;
            case "en" -> en_US;
            default -> throw new IllegalArgumentException("Unknown language code: " + shortCode);
        };
    }
    public String getTranslatorEnum(){
        if (this.equals(ru_RU)){return "ru";}
        if (this.equals(en_US)){return "en";}
        return null;
    }
}
