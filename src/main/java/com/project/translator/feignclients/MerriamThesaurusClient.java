package com.project.translator.feignclients;

import com.project.translator.models.dto.ThesaurusResponse;
import com.project.translator.models.dto.WordInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "thesaurusClient", url = "https://www.dictionaryapi.com/api/v3/references/thesaurus/json")
public interface MerriamThesaurusClient {
    @GetMapping("/{word}")
    List<ThesaurusResponse> getThesaurusEntries(@PathVariable("word") String word, @RequestParam("key") String apiKey);
}