package com.project.translator.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DictionaryResponse(
        List<DefWrapper> def
) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static record DefWrapper(
            List<List<SseqItem>> sseq // Массив массивов, внутри либо SseqItem, либо ещё массив
    ) {}

    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    public static record SseqItem(
            String type, // "sense", "pseq", "bsense" и т.д.
            Object content // Либо Sense, либо List<SseqItem>
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static record Sense(
            List<DtItem> dt
    ) {}

    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    public static record DtItem(
            String type, // "vis" или "text"
            Object content // Либо String, либо List<Vis>
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static record Vis(
            String t
    ) {}
}

