package com.project.translator.feignclients;

import com.project.translator.models.dto.DictionaryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "dictionaryClient", url = "https://www.dictionaryapi.com/api/v3/references/collegiate/json")
public interface MerriamDictionaryClient {
    @GetMapping("/{word}")
    String getDictionaryEntries(@PathVariable("word") String word, @RequestParam("key") String apiKey);
}
