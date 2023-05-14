package com.dataportfolio.labor.domain.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimeSeriesResponse {
    private String status;
    private Integer responseTime;
    private List<String> message;
    @JsonProperty("Results")
    private Result Results;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Result {
        private List<SeriesData> series;

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class SeriesData {
            @JsonProperty("seriesID")
            private String seriesID;
            private List<SeriesDataPoint> data;

            @Data
            @Builder
            @AllArgsConstructor
            @NoArgsConstructor
            public static class SeriesDataPoint {
                private String year;
                private String period;
                private String periodName;
                private String latest;
                private String value;
                private List<FootNote> footnotes;

                @Data
                @Builder
                @AllArgsConstructor
                @NoArgsConstructor
                @JsonInclude(JsonInclude.Include.NON_NULL)
                public static class FootNote {
                    private String code;
                    private String text;
                }
            }
        }
    }

}
