package HotelReservationManager.convertor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import HotelReservationManager.entity.ReservationEntity;
import HotelReservationManager.model.response.ReservationResponse;
import org.springframework.lang.NonNull;

@Component
public class ReservationEntityToReservationResponseConverter implements Converter<ReservationEntity, ReservationResponse> {

    @Override
    public ReservationResponse convert(@NonNull ReservationEntity source) {

        ReservationResponse reservationResponse = new ReservationResponse();
        reservationResponse.setCheckin(source.getCheckin());
        reservationResponse.setCheckout(source.getCheckout());

        if (null != source.getRoomEntity())
            reservationResponse.setId(source.getRoomEntity().getId());

        return reservationResponse;
    }
}
