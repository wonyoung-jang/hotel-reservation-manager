package com.wjang.hotel_reservation_manager.repository;

import com.wjang.hotel_reservation_manager.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;



public interface RoomRepository extends CrudRepository<RoomEntity, Long> {

	//RoomEntity findById(Long id);
}
