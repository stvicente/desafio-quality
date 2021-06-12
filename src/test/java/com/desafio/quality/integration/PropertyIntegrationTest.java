package com.desafio.quality.integration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private static String request;

    @BeforeAll
    static void init(){
        request = "{\n" +
                "    \"propName\": \"Casa da Pandora\",\n" +
                "    \"propDistrict\": \"Rocha Sobrinho\",\n" +
                "    \"rooms\": [\n" +
                "        {\n" +
                "            \"roomName\": \"Bedroom\",\n" +
                "            \"roomWidth\": 5,\n" +
                "            \"roomLength\": 10\n" +
                "        },\n" +
                "        {\n" +
                "            \"roomName\": \"Living Room\",\n" +
                "            \"roomWidth\": 5,\n" +
                "            \"roomLength\": 7\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

    @Test
    void shouldReturnStatusOkAndTotalSizeAndTotalValueAndBiggestRoom() throws Exception {
        mockMvc.perform(post("/properties/value")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(header().string("Content-Type", "application/json"))
                .andExpect(jsonPath("$.totalSize").value(85.0))
                .andExpect(jsonPath("$.value").value(2125.0))
                .andExpect(jsonPath("$.biggestRoom.roomName").value("Bedroom"))
                .andExpect(jsonPath("$.biggestRoom.roomSize").value(50.0));;
    }
}
