package com.project.translator;

import com.project.translator.controller.TranslatorController;
import com.project.translator.entity.Language;
import com.project.translator.entity.Word;
import com.project.translator.repository.UserDictionaryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class WordControllerServerIT{
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    TranslatorController translatorController;
//
//    @Autowired
//    UserDictionaryRepository userDictionaryRepository;
//
//    @TestConfiguration
//    static class TestConfig {
//        @Bean
//        public TestRestTemplate restTemplate() {
//            return new TestRestTemplate();
//        }
//    }
//    @Autowired
//    TestRestTemplate restTemplate;
//
//    protected void runInTransaction(Runnable function){
//        try{
//            function.run();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void addWordInDictionary_wordAdded(){
//
//        Word word = new Word(Language.RUSSIAN,
//                "ʌп❜иел❜с❜и́н",
//                new ArrayList<Word>(),
//                new ArrayList<String>());
//
//        runInTransaction(() -> userDictionaryRepository.save(word));
//
//        restTemplate.postForObject("/words", word.getId(), Void.class);
//
//        runInTransaction(() -> {
//            Word word1 = userDictionaryRepository.getReferenceById(word.getId());
//            assertEquals(word, word1);
//        });
//    }
}
