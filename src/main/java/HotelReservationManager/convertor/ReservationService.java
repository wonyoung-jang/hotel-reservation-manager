package HotelReservationManager.convertor;

import HotelReservationManager.entity.ReservationEntity;
import java.util.List;

public interface ReservationService {
    public ReservationEntity findLast();
    public List<ReservationEntity> findAll();
}
