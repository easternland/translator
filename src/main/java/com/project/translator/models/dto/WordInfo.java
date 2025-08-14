package com.project.translator.models.dto;

import java.util.SortedSet;

public record WordInfo(
        String spelling,
        SortedSet<String> synonym,
        SortedSet<String> antonym,
        SortedSet<String> usageExample
//        byte[] pronunciation
){}