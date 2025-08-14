package com.project.translator.service;

import com.project.translator.entity.Word;
import com.project.translator.repository.UserDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDictionaryService {

    UserDictionaryRepository userDictionaryRepository;

    @Autowired
    public UserDictionaryService(UserDictionaryRepository userRepository) {
        this.userDictionaryRepository = userRepository;
    }

    public void saveWordInDictionary(Word word) {
        userDictionaryRepository.save(word);
    }

    public Word getWordFromDictionary(int id){
        return userDictionaryRepository.getReferenceById(id);
    }

    public List<Word> getAllWordsFromDictionary(){
        return userDictionaryRepository.findAll();
    }

    public void updateWordInDictionary(Word updatedWord){
        userDictionaryRepository.save(updatedWord);
    }

    public void deleteWordFromDictionary(int id){
        userDictionaryRepository.deleteById(id);
    }

    public void deleteWordFromDictionary(Word w){
        userDictionaryRepository.delete(w);
    }

    public void deleteAllWordsInDictionary(){
        userDictionaryRepository.deleteAll();
    }
}
