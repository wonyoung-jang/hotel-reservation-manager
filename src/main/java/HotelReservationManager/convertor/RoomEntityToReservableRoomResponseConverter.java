package HotelReservationManager.convertor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import HotelReservationManager.entity.RoomEntity;
import HotelReservationManager.model.Links;
import HotelReservationManager.model.Self;
import HotelReservationManager.model.response.ReservableRoomResponse;
import HotelReservationManager.rest.ResourceConstants;
import lombok.NonNull;

@Component
public class RoomEntityToReservableRoomResponseConverter implements Converter<RoomEntity, ReservableRoomResponse>{

	@SuppressWarnings("null")
	@Override
	public ReservableRoomResponse convert(@NonNull RoomEntity source) {
		
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
