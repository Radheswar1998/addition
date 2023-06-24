package org.example.controller;



import org.example.controller.AdditionController;
import org.example.service.AdditionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;

@WebMvcTest(AdditionController.class)
public class AdditionControllerTest {

    @Mock
    private AdditionService additionService;

    @InjectMocks
    private AdditionController additionController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(additionController).build();
    }

    @Test
    public void testAddNumbers() throws Exception {
        int num1 = 5;
        int num2 = 3;
        int expectedResult = 8;

        when(additionService.addNumbers(num1, num2)).thenReturn(expectedResult);

        mockMvc.perform(MockMvcRequestBuilders.get("/add")
                        .param("num1", String.valueOf(num1))
                        .param("num2", String.valueOf(num2)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(expectedResult)));
    }
}

