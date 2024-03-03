package com.wjang.hotel_reservation_manager.convertor;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
@Service
public class TimeZoneConvertor {

    public static LocalDateTime convertTimeZone(LocalDateTime time, String fromZone, String toZone) {
        return time.atZone(ZoneId.of(fromZone)).withZoneSameInstant(ZoneId.of(toZone)).toLocalDateTime();
    }
}
