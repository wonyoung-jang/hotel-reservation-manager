package com.wjang.hotel_reservation_manager.convertor;

import com.wjang.hotel_reservation_manager.entity.ReservationEntity;
import java.util.List;

public interface ReservationService {
    public ReservationEntity findLast();
    public List<ReservationEntity> findAll();
}
