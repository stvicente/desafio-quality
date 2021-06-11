package com.desafio.quality;

import com.desafio.quality.dto.PropertyDTO;
import com.desafio.quality.dto.RoomDTO;
import com.desafio.quality.service.PropertyService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class QualityApplicationTests {
	PropertyService propertyService = new PropertyService();
	static PropertyDTO propertyDTO;

	@BeforeAll
	static void init(){
		propertyDTO = new PropertyDTO();
		List<RoomDTO> rooms = new ArrayList<>();
		rooms.add(new RoomDTO("Bedroom", 7.5, 8));
		rooms.add(new RoomDTO("Living room", 10, 5));
		rooms.add(new RoomDTO("Dining room", 5, 4));
		propertyDTO.setPropName("Casa da Rita");
		propertyDTO.setPropDistrict("BNH");
		propertyDTO.setRooms(rooms);
	}


	@Test
	void shouldCalculateCorrectPropertySize() {
		double correctPropertySize = propertyService.totalSize(propertyDTO.getRooms());
		assertEquals(correctPropertySize, 130);
	}

	@Test
	void shouldReturnExceptionIfDistrictIsInvalid(){
		assertThrows(Exception.class, () -> {
			propertyDTO.setPropDistrict("Jacutinga");
			propertyService.districtValue(propertyDTO);
		});
	}

	@Test
	void shouldReturnValuePerM2IfDistrictIsValid() throws Exception {
		double valuePerM2 = propertyService.districtValue(propertyDTO);
		assertEquals(valuePerM2, 30.);

	}

	@Test
	void shouldReturnBiggestRoom() {
		List<RoomDTO> rooms = propertyDTO.getRooms();
		RoomDTO room = propertyService.biggestRoom(rooms);
		assertEquals("Bedroom", room.getRoomName());
	}

	@Test
	void shouldReturnRoomsCorrectTotalSize() {
		List<RoomDTO> roomDTO = propertyDTO.getRooms()
											.stream()
											.filter(room -> room.getRoomName().equals("Living room"))
											.collect(Collectors.toList());
		double roomSize = propertyService.sizePerRoom(roomDTO).get(0).getRoomSize();
		assertEquals(50., roomSize);

	}

}

