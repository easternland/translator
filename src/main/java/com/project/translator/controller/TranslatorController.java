package com.project.translator.controller;

import com.project.translator.models.dto.TranslationRequest;
import com.project.translator.models.dto.TranslationResponse;
import com.project.translator.models.dto.WordInfo;
import com.project.translator.service.MerriamWebsterService;
import com.project.translator.service.TranslationService;
import com.project.translator.service.UserDictionaryService;
import com.project.translator.service.WordService;
import com.translated.lara.errors.LaraException;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("translate/")
public class TranslatorController {

    private final UserDictionaryService dictionaryService;
    private final WordService wordService;
    private final TranslationService translationService;
    private final MerriamWebsterService merriamWebsterService;

    @Autowired
    public TranslatorController(WordService wordService, UserDictionaryService dictionaryService,
                                TranslationService translationService, MerriamWebsterService merriamWebsterService) {
        this.wordService = wordService;
        this.dictionaryService = dictionaryService;
        this.translationService = translationService;
        this.merriamWebsterService = merriamWebsterService;
    }

    @NotNull
    @PostMapping("")
    public TranslationResponse translate(@NotNull @RequestBody TranslationRequest translationRequest)
            throws LaraException, IOException {

        String translatedWord = translationService.translate(translationRequest);

        WordInfo wordInfo = merriamWebsterService.getWordInfo(translationRequest.sourceWord());

        System.out.println(translatedWord);
        System.out.println(wordInfo.spelling());
        System.out.println(wordInfo.synonym().toString());
        System.out.println(wordInfo.antonym().toString());
        System.out.println(wordInfo.usageExample().toString());

        return new TranslationResponse(translatedWord, wordInfo);
    }
}







    /*
     *  The most basic user flow:
     *
     * User picks source language, target language, types a word, clicks the button, gets back:
     * - the translation
     * - the pronunciation
     * - the usage examples
     *
     */


    /*
    Feature: translation history

    User can view the history of his translation requests in chronological order

    1. Entity - ?
    table - translation_history

    fields:
    - user (int)




     */