package com.project.translator.common;

import com.project.translator.controller.TranslatorController;
import com.project.translator.repository.WordRepository;
import com.project.translator.service.MerriamWebsterService;
import com.project.translator.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseControllerIT {

    @Autowired
    protected TranslatorController translatorController;

    @Autowired
    protected MerriamWebsterService merriamWebsterService;

}
