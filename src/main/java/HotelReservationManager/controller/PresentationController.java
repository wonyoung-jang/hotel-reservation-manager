package HotelReservationManager.controller;

import HotelReservationManager.convertor.TimeZoneConvertor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/presentation")
public class PresentationController {

    @GetMapping("/time")
    public ResponseEntity<Map<String, String>> getPresentationTime() {
        Map<String, String> presentationTimes = new HashMap<>();
        LocalDateTime presentationTimeUTC = LocalDateTime.now(ZoneId.of("UTC"));

        // Convert to Eastern Time (ET)
        LocalDateTime presentationTimeET = TimeZoneConvertor.convertTimeZone(presentationTimeUTC, "UTC", "America/New_York");

        // Convert to Mountain Time (MT)
        LocalDateTime presentationTimeMT = TimeZoneConvertor.convertTimeZone(presentationTimeUTC, "UTC", "America/Denver");

        // Format times
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        presentationTimes.put("ET", presentationTimeET.format(formatter) + " ET");
        presentationTimes.put("MT", presentationTimeMT.format(formatter) + " MT");
        presentationTimes.put("UTC", presentationTimeUTC.format(formatter) + " UTC");

        return ResponseEntity.ok(presentationTimes);
    }
}
