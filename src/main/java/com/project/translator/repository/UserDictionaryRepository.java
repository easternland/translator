package com.project.translator.repository;

import com.project.translator.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDictionaryRepository extends JpaRepository<Word, Integer> {
}
