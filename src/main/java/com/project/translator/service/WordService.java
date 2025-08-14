package com.project.translator.service;

import com.project.translator.entity.Word;
import com.project.translator.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WordService {

    private final WordRepository wordRepository;

    @Autowired
    public WordService(WordRepository WordRepository) {
        this.wordRepository = WordRepository;
    }

    public Word saveWord (Word word) {
        return wordRepository.save(word);
    }

    public Word getWordById (int id) {
        return wordRepository.getReferenceById(id);
    }

    public void deleteWord (int id) {
        wordRepository.deleteById(id);
    }

    public void deleteWord (Word word) {
        wordRepository.delete(word);
    }




    /*
    Unit test:
    - (how?) we create the object of the tested service by hands, using mock dependencies
    - start <100ms
    - behavior of the service


    Integration test:
    - (how?) we start the whole spring context with services, (potentially) db, repositories etc.
    - start (with "real" db) >30s
    - integration of the service with other services


    WordService
    UserDictionaryService

    Как будет "апельсин" на английском? - Orange (also added to my dictionary)


     */
}
