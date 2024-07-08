package org.sid.msproduct.Controller;

import org.sid.msproduct.Entity.EngagementDuration;
import org.sid.msproduct.Service.EngagementDurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/engagement-durations")
public class EngagementDurationController {

    @Autowired
    private EngagementDurationService engagementDurationService;

    @PostMapping
    public ResponseEntity<EngagementDuration> createEngagementDuration(@RequestBody EngagementDuration engagementDuration) {
        EngagementDuration savedEngagementDuration = engagementDurationService.saveEngagementDuration(engagementDuration);
        return new ResponseEntity<>(savedEngagementDuration, HttpStatus.CREATED);
    }
}
