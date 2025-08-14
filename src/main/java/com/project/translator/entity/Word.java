package com.project.translator.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Arrays;
import java.util.List;

@Entity
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    int id;

    @NotNull
    Language lang;

    @NotNull
    String spelling;

    @Nullable
    byte[] pronunciation;

    @Nullable
    List<String> usageExample;

    @NotNull
    List<String> synonym;

    @NotNull
    List<String> antonym;

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    List<Word> translation;

    public Word(){    }

    public Word(Language lang, String spelling, List<Word> translation,
                List<String> usageExample, byte[] pronunciation, List<String> synonym, List<String> antonym){
        this.lang = lang;
        this.spelling = spelling;
        this.translation = translation;
        this.usageExample = usageExample;
        this.pronunciation = pronunciation;
        this.synonym = synonym;
        this.antonym = antonym;
    }

    public Word(Language lang, String spelling, List<Word> translation,
                List<String> usageExample, List<String> synonym, List<String> antonym){
        this.lang = lang;
        this.spelling = spelling;
        this.translation = translation;
        this.usageExample = usageExample;
        this.synonym = synonym;
        this.antonym = antonym;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getUsageExample() {
        return usageExample;
    }

    public void setUsageExample(List<String> usageExample) {
        this.usageExample = usageExample;
    }

    public List<Word> getTranslation() {
        return translation;
    }

    public void setTranslation(List<Word> translation) {
        this.translation = translation;
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    public Language getLang() {
        return lang;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", lang=" + lang +
                ", spelling='" + spelling + '\'' +
                ", pronunciation=" + Arrays.toString(pronunciation) +
                ", synonym=" + synonym +
                ", antonym=" + antonym +
                ", translation=" + translation +
                ", usageExample=" + usageExample +
                '}';
    }
}
