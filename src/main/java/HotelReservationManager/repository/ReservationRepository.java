package HotelReservationManager.repository;

import org.springframework.data.repository.CrudRepository;
import HotelReservationManager.entity.ReservationEntity;

public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {
}
