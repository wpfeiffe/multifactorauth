package com.wspfeiffer.mfaserver.resource;

import com.wspfeiffer.mfaserver.dto.nps.model.Activity;
import com.wspfeiffer.mfaserver.dto.nps.model.ActivityPark;
import com.wspfeiffer.mfaserver.services.impl.NationParksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/nps")
public class ParkServiceResource {

    private final NationParksService nationParksService;

    @GetMapping("/activities")
    public Activity getActivities() {
        return nationParksService.getActivities();
    }

    @GetMapping("/activities/{activityId}/parks")
    public ActivityPark getParksForActivity(@PathVariable("activityId") String activityId) {
        List<String> ids = List.of(activityId);
        return nationParksService.getParksForActivities(ids);
    }
}
