package ru.yandex.yandexlavka.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetCourierMetaInfoResponse {
    @JsonProperty(value = "courier_id", required = true)
    private long courierId;
    @JsonProperty(value = "courier_type", required = true)
    private String courierType;
    @JsonProperty(value = "regions", required = true)
    private List<Integer> regions;
    @JsonProperty(value = "working_hours", required = true)
    private List<String> workingHours;
    @JsonProperty("rating")
    private Integer rating;
    @JsonProperty("earnings")
    private Integer earnings;
}
