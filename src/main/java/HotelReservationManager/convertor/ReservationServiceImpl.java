package HotelReservationManager.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import HotelReservationManager.entity.ReservationEntity;
import HotelReservationManager.repository.ReservationRepository;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

    private ReservationRepository reservationRepository;

    @Autowired
    public  ReservationServiceImpl(ReservationRepository reservationRepository){
        this.reservationRepository=reservationRepository;
    }
    @Override
    public ReservationEntity findLast() {
        List<ReservationEntity> allReservations= (List<ReservationEntity>) reservationRepository.findAll();
        return allReservations.get(allReservations.size()-1);
    }

    @Override
    public List<ReservationEntity> findAll(){
        return (List<ReservationEntity>) reservationRepository.findAll();
    }
}
