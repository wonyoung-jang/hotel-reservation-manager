package com.wjang.hotel_reservation_manager.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wjang.hotel_reservation_manager.convertor.TimeZoneConvertor;

@RestController
@RequestMapping("/presentation")
public class PresentationController {

    @Autowired
    private TimeZoneConvertor timeZoneConvertor;

    @GetMapping("/time")
    public ResponseEntity<Map<String, String>> getPresentationTime() {
        Map<String, String> presentationTimes = new HashMap<>();
        LocalDateTime presentationTimeUTC = LocalDateTime.now(ZoneId.of("UTC"));

        // Convert to Eastern Time (ET)
        LocalDateTime presentationTimeET = timeZoneConvertor.convertTimeZone(presentationTimeUTC, "UTC", "America/New_York");

        // Convert to Mountain Time (MT)
        LocalDateTime presentationTimeMT = timeZoneConvertor.convertTimeZone(presentationTimeUTC, "UTC", "America/Denver");

        // Format times
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        presentationTimes.put("ET", presentationTimeET.format(formatter) + " ET");
        presentationTimes.put("MT", presentationTimeMT.format(formatter) + " MT");
        presentationTimes.put("UTC", presentationTimeUTC.format(formatter) + " UTC");

        return ResponseEntity.ok(presentationTimes);
    }
}
