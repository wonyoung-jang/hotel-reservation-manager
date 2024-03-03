package com.wjang.hotel_reservation_manager.convertor;

import java.util.List;

import com.wjang.hotel_reservation_manager.entity.RoomEntity;

public interface RoomService {
    public RoomEntity findById(long theId);
   // public Page<RoomEntity> findAvailableRooms(LocalDate checkin, LocalDate checkout, Pageable page);
    public List<RoomEntity> findAll();

}
