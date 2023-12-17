package com.wspfeiffer.mfaserver.services.impl;

import com.wspfeiffer.mfaserver.dto.nps.model.Activity;
import com.wspfeiffer.mfaserver.dto.nps.model.ActivityPark;

import java.util.List;

public interface NationParksService {

    Activity getActivities();

    ActivityPark getParksForActivities(List<String> ids);
}
