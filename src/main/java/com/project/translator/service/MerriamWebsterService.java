package com.project.translator.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.translator.feignclients.MerriamDictionaryClient;
import com.project.translator.feignclients.MerriamThesaurusClient;
import com.project.translator.models.dto.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MerriamWebsterService {

    private final MerriamDictionaryClient merriamDictionaryClient;
    private final MerriamThesaurusClient merriamThesaurusClient;

     private final String merriamDictionaryApiKey;
     private final String merriamThesaurusApiKey;
    //ctrl + b чтобы посмотреть класс
     @Autowired
     public MerriamWebsterService(MerriamDictionaryClient mdc,
                                  MerriamThesaurusClient mtc,
                                  @Value("${merriam.dictionary.api.key}") String merriamDictionaryApiKey,
                                  @Value("${merriam.thesaurus.api.key}") String merriamThesaurusApiKey) {
        this.merriamDictionaryClient = mdc;
         this.merriamThesaurusClient = mtc;
         this.merriamDictionaryApiKey = merriamDictionaryApiKey;
         this.merriamThesaurusApiKey = merriamThesaurusApiKey;
     }

    private ThesaurusResponse getThesaurusResponse (String word){
        return merriamThesaurusClient.getThesaurusEntries(word, merriamThesaurusApiKey).get(0);
    }

    private String getDictionaryResponse (String word){
         return merriamDictionaryClient.getDictionaryEntries(word, merriamDictionaryApiKey);
    }

    public SortedSet<String> getUsageExamples(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(json);

        SortedSet<String> usageExamples = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        for (JsonNode entry : root) {
            JsonNode defArr = entry.path("def");
            for (JsonNode def : defArr) {
                JsonNode sseqArr = def.path("sseq");
                for (JsonNode outer : sseqArr) {
                    for (JsonNode inner : outer) {
                        if (inner.size() >= 2 && "sense".equals(inner.get(0).asText())) {
                            JsonNode senseNode = inner.get(1);
                            JsonNode dtArr = senseNode.path("dt");
                            for (JsonNode dt : dtArr) {
                                if (dt.size() >= 2 && "vis".equals(dt.get(0).asText())) {
                                    JsonNode visArr = dt.get(1);
                                    for (JsonNode vis : visArr) {
                                        String text = vis.path("t").asText("").trim();
                                        if (!text.isEmpty()) {
                                            usageExamples.add(text);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return usageExamples;
    }



    private SortedSet<String> getSynonyms(ThesaurusResponse thesaurusResponse){
        return new TreeSet<>(
                thesaurusResponse.meta().syns()
                .stream()
                .flatMap(List::stream)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toSet())
        );
    }

    private SortedSet<String> getAntonyms(ThesaurusResponse thesaurusResponse){
        return new TreeSet<>(
                thesaurusResponse.meta().ants()
                .stream()
                .flatMap(List::stream)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toSet())
        );
    }

    public WordInfo getWordInfo(@NotNull String word) {

        ThesaurusResponse thesaurusResponse = getThesaurusResponse(word);
        SortedSet<String> synonyms = getSynonyms(thesaurusResponse);
        SortedSet<String> antonyms = getAntonyms(thesaurusResponse);

        String json = getDictionaryResponse(word);
        SortedSet<String> usageExamples = null;
        try{usageExamples = getUsageExamples(json);}
        catch(Exception e){System.out.println(e.getMessage());}

        return new WordInfo(word, synonyms, antonyms, usageExamples);
    }
}





         /*
         var thesaurusResponse = getThesaurusResponse(word);
         var synonyms = getSynonyms(thesaurusResponse);
         var antonyms = getAntonyms(thesaurusResponse)

         var dictionaryResponse = getDictionaryResponse(word);
         var usageExamples = usageExamples(dictionaryResponse);

         return WordInfo(
         ...
         )
          */


        /*
        {
              "data": {
                  "id": 101,
                  "name": "John Doe",
                  "email": "john.doe@example.com",
                  "age": 35,
                  "active": true
              }
              "colors": [
                  "red",
                  "black",
                  "blue"
              ]
         }


        public class Response {
            Data data;
        }

        public class Data {
                int id;
                String name;
                String email;
                int age;
                boolean active;
        }

        / API Client, endpoint api.com/users/id
        Response response = client.get(id)
        response.synonym.mainsynonym
        @Jsonfield("data.name")

         */

