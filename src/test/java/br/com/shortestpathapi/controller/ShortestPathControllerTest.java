package br.com.shortestpathapi.controller;

import br.com.shortestpathapi.dto.ShortestPathRequestDTO;
import br.com.shortestpathapi.dto.ShortestPathResponseDTO;
import br.com.shortestpathapi.repository.NodeEntityRepository;
import br.com.shortestpathapi.service.IShortestPathService;
import br.com.shortestpathapi.service.impl.ShortestPathServiceImpl;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @version 0.1
 * @since 14/02/2020
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ShortestPathControllerTest {

    @Autowired
    private MockMvc mockMvc;

    Gson gson = new Gson();

    ShortestPathResponseDTO expectedResult = new ShortestPathResponseDTO();

    @BeforeEach
    public void init() {
        expectedResult.setCusto("6.25");
        expectedResult.setRota("A B D");
    }

    @Test
    public void testController() throws Exception {
        ShortestPathRequestDTO shortestPathRequestDTO = new ShortestPathRequestDTO();
        shortestPathRequestDTO.setAutonomia("10");
        shortestPathRequestDTO.setDestino("D");
        shortestPathRequestDTO.setOrigem("A");
        shortestPathRequestDTO.setValorLitro("2.5");

        MvcResult storyResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/v1/distance")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(shortestPathRequestDTO)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String response = storyResult.getResponse().getContentAsString();

        assertNotNull(storyResult);
        assertEquals(response, gson.toJson(expectedResult), "Should be same result!");
    }
}
