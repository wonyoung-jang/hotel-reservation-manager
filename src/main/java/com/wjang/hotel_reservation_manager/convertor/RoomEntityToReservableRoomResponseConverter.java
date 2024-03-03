package com.wjang.hotel_reservation_manager.convertor;

import com.wjang.hotel_reservation_manager.entity.RoomEntity;

import com.wjang.hotel_reservation_manager.model.Links;
import com.wjang.hotel_reservation_manager.model.Self;
import com.wjang.hotel_reservation_manager.model.response.ReservableRoomResponse;
import com.wjang.hotel_reservation_manager.rest.ResourceConstants;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoomEntityToReservableRoomResponseConverter implements Converter<RoomEntity, ReservableRoomResponse>{

	@Override
	public ReservableRoomResponse convert(RoomEntity source) {
		
		ReservableRoomResponse reservationResponse = new ReservableRoomResponse();
		if(null != source.getId())
			reservationResponse.setId(source.getId());
		reservationResponse.setRoomNumber(source.getRoomNumber());
		reservationResponse.setPrice( Integer.valueOf(source.getPrice()) );
		
		Links links = new Links();
		Self self = new Self();
		self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" + source.getId());
		links.setSelf(self);
		
		reservationResponse.setLinks(links);
		
		return reservationResponse;
	}

	
	
}
