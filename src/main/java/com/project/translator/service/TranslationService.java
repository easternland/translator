package com.project.translator.service;

import com.project.translator.models.dto.TranslationRequest;
import com.project.translator.entity.Language;
import com.translated.lara.Credentials;
import com.translated.lara.errors.LaraException;
import com.translated.lara.translator.TextResult;
import com.translated.lara.translator.TranslateOptions;
import com.translated.lara.translator.Translator;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

@Service
public class TranslationService {

    private static final String LARA_ACCESS_KEY_ID = "A8U18HFI6ATV89A66EDIHF3EGL";
    private static final String LARA_ACCESS_KEY_SECRET = "BoKJxpoBxqJodZTByYIZ_gs6jGex-fsoXU3tDykSxYk";
    public Credentials credentials = new Credentials(LARA_ACCESS_KEY_ID, LARA_ACCESS_KEY_SECRET);
    Translator translator = new Translator(credentials);
//    TextBlock[] textBlocks = {};
//    enum CONTEXT_MODE.ON / .OFF

    @NotNull
    public String translate(@NotNull TranslationRequest translationRequest) throws LaraException {

            TranslateOptions options = new TranslateOptions()
                    .setInstructions(translationRequest.instructions())
                    .setAdaptTo(translationRequest.adaptation());
//                .setStyle(); ???

            TextResult res = translator.translate(
                    translationRequest.sourceWord(),
                    translationRequest.sourceLanguage().getTranslatorEnum(),
                    translationRequest.targetLanguage().getTranslatorEnum()
//                    options
            );
            return res.getTranslation();
    }
}
