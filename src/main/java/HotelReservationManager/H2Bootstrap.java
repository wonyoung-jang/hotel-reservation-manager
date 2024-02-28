package HotelReservationManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import HotelReservationManager.entity.RoomEntity;
import HotelReservationManager.repository.RoomRepository;

@Component
public class H2Bootstrap implements CommandLineRunner {

	@Autowired
	RoomRepository roomRepository;
	
	@Override
	public void run(String... args) throws Exception {		
		System.out.println("Bootstrapping data: ");
		RoomEntity room1= new RoomEntity(405, "200");
		room1.setId(1L);
		
		roomRepository.save(room1);

		RoomEntity room2= new RoomEntity(406, "220");
		room2.setId(2L);

		roomRepository.save(room2);

		RoomEntity room3= new RoomEntity(407, "260");
		room3.setId(3L);

		roomRepository.save(room3);

		Iterable<RoomEntity> itr = roomRepository.findAll();
		
		System.out.println("Printing out data: ");
		for(RoomEntity room : itr) {
			System.out.println(room.getRoomNumber());
		}
	}
}
