package org.sid.msproduct.Service;

import org.sid.msproduct.Entity.EngagementDuration;
import org.sid.msproduct.Repository.EngagementDurationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EngagementDurationService {

    @Autowired
    private EngagementDurationRepo engagementDurationRepo;

    public EngagementDuration saveEngagementDuration(EngagementDuration engagementDuration) {
        return engagementDurationRepo.save(engagementDuration);
    }
}
