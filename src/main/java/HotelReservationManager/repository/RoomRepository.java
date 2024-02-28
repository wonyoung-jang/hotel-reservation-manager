package HotelReservationManager.repository;

import org.springframework.data.repository.CrudRepository;
import HotelReservationManager.entity.RoomEntity;

public interface RoomRepository extends CrudRepository<RoomEntity, Long> {
}
