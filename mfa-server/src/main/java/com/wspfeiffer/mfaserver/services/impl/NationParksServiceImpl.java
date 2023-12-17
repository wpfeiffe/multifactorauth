package com.wspfeiffer.mfaserver.services.impl;

import com.wspfeiffer.mfaserver.dto.nps.model.Activity;
import com.wspfeiffer.mfaserver.dto.nps.model.ActivityPark;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class NationParksServiceImpl implements NationParksService {
    private final String BASE_URI = "https://developer.nps.gov/api/v1";
    @Value("${application.nps-api-key}")
    private String API_KEY;

    @Override
    public Activity getActivities() {

        RestClient restClient = RestClient.builder()
                .baseUrl(this.BASE_URI)
                .build();
        Activity result = restClient.get()
                .uri("/activities?" + getApiKeyParam())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(Activity.class);
        return result;
    }

    @Override
    public ActivityPark getParksForActivities(List<String> ids) {
        String idList = ids.isEmpty() ? "" : "&id=" + String.join(",", ids);
        RestClient restClient = RestClient.builder()
                .baseUrl(this.BASE_URI)
                .build();
        ActivityPark result = restClient.get()
                .uri("/activities/parks?" + getApiKeyParam() + idList)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(ActivityPark.class);
        return result;
    }


    private String getApiKeyParam() {
        return "api_key=" + this.API_KEY;
    }
}
