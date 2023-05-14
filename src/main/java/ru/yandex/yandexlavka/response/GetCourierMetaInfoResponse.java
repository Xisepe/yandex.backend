package ru.yandex.yandexlavka.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetCourierMetaInfoResponse {
    @JsonProperty("courier_id")
    private long courierId;
    @JsonProperty("courier_type")
    private String courierType;
    @JsonProperty("regions")
    private List<Integer> regions;
    @JsonProperty("working_hours")
    private List<String> workingHours;
    @JsonProperty("rating")
    private Integer rating;
    @JsonProperty("earnings")
    private Integer earnings;
}
