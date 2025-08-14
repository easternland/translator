package com.project.translator;

import com.project.translator.common.BaseControllerIT;
import com.project.translator.entity.Language;
import com.project.translator.entity.Word;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class WordControllerIT extends BaseControllerIT {

//    @Test
//    public void createWord_wordSaved(){
//        Word word = new Word(Language.RUSSIAN,
//                "ʌп❜иел❜с❜и́н",
//                new ArrayList<Word>(),
//                new ArrayList<String>());
//
//        Word createdWord = translatorController.addWordInDictionary(word);
//        Word dbWord = wordRepository.getReferenceById(createdWord.getId());
//        word.setSpelling("goyda");
//        assertEquals(word, dbWord);
//    }
}
