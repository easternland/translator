package com.project.translator.models.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.SortedSet;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Meta (
        @JsonProperty("syns")
        List<List<String>> syns,
        @JsonProperty("ants")
        List<List<String>> ants
){}
