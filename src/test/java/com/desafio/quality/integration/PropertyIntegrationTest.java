package com.desafio.quality.integration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

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
                "    \"propDistrict\": \"jacutinga\",\n" +
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
    void shouldReturnStatusCreatedAndTotalValueO() throws Exception {
        this.mockMvc.perform(
                post("/propriedades")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.valorDaPropriedade").value(9776.81));
    }


}
