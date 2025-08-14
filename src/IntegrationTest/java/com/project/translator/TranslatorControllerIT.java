package com.project.translator;

import com.project.translator.common.BaseControllerIT;
import com.project.translator.controller.TranslatorController;
import com.project.translator.models.dto.TranslationRequest;
import com.project.translator.models.dto.TranslationResponse;
import com.project.translator.entity.Language;
import com.project.translator.entity.Word;
import com.translated.lara.errors.LaraException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TranslatorControllerIT extends BaseControllerIT {
//
//    @Test
//    public void getSynonyms_synonymsFound() throws LaraException, IOException {
//
//        private final TranslatorController;
//
//        Word word = new Word(Language.ru_RU,
//                "apple",
//                null,
//                null,
//                null,
//                null
//        );
//
//        TranslationRequest translationRequest = new TranslationRequest(Language.ru_RU, Language.en_US,
//                word.toString(), null, null);
//
//        List<String> synonyms = merriamWebsterService.getSynonyms(translationRequest.sourceWord());
//        List<String> antonyms
//
//        System.out.println(word.toString());
//        System.out.println(translationResponse.translation());
//
//        assertEquals(word.toString(), translationResponse.translation());
//    }

//    @Test
//    public void translateWord_wordFullTranslatedWithSynAntEtc() throws LaraException, IOException {
//    }
}
