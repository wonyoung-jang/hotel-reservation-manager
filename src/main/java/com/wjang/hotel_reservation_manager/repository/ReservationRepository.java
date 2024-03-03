package com.wjang.hotel_reservation_manager.repository;


import com.wjang.hotel_reservation_manager.entity.ReservationEntity;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {
}