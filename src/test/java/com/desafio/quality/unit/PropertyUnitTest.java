package com.desafio.quality.unit;

import com.desafio.quality.dto.PropertyDTO;
import com.desafio.quality.dto.RoomDTO;
import com.desafio.quality.dto.SizeDTO;
import com.desafio.quality.service.PropertyService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PropertyUnitTest {
        PropertyService propertyService = new PropertyService();
        static PropertyDTO propertyDTO;

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

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
        public void shouldReturnFalseIfPropertyNameValidationIsEmpty() {
            propertyDTO.setPropName("casa da pandora");
            Set<ConstraintViolation<PropertyDTO>> violations = validator.validate(propertyDTO);
            assertFalse(violations.isEmpty());
        }

        @Test
        void shouldReturnValuePerM2IfDistrictIsValid() throws RuntimeException {
            double valuePerM2 = propertyService.districtValue(propertyDTO);
            assertEquals(valuePerM2, 30.);
        }

        @Test
        void shouldReturnBiggestRoom() {
            List<RoomDTO> rooms = propertyDTO.getRooms();
            SizeDTO room = propertyService.biggestRoom(rooms);
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
