package com.wjang.hotel_reservation_manager.convertor;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.wjang.hotel_reservation_manager.entity.ReservationEntity;
import com.wjang.hotel_reservation_manager.model.response.ReservationResponse;

@Component
public class ReservationEntityToReservationResponseConverter implements Converter<ReservationEntity, ReservationResponse> {

    @Override
    public ReservationResponse convert(ReservationEntity source) {

        ReservationResponse reservationResponse = new ReservationResponse();
        reservationResponse.setCheckin(source.getCheckin());
        reservationResponse.setCheckout(source.getCheckout());

        if (null != source.getRoomEntity())
            reservationResponse.setId(source.getRoomEntity().getId());

        return reservationResponse;
    }
}