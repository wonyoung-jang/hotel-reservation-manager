package HotelReservationManager.convertor;

import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import HotelReservationManager.entity.ReservationEntity;
import HotelReservationManager.entity.RoomEntity;
import HotelReservationManager.model.request.ReservationRequest;
import org.springframework.lang.NonNull;

@Component
public class ReservationRequestToReservationEntityConverter implements Converter<ReservationRequest, ReservationEntity> {
private final ApplicationContext context;

    public ReservationRequestToReservationEntityConverter(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public ReservationEntity convert(@NonNull ReservationRequest source) {

        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setCheckin(source.getCheckin());
        reservationEntity.setCheckout(source.getCheckout());
        RoomService repository=context.getBean(RoomServiceImpl.class);
        RoomEntity associatedRoom=repository.findById(source.getRoomId());

        reservationEntity.setRoomEntity(associatedRoom);
        if (null != source.getId())
            reservationEntity.setId(source.getId());

        return reservationEntity;
    }
}
