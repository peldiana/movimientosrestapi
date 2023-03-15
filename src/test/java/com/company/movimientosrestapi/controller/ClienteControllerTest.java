package com.company.movimientosrestapi.controller;

import com.company.movimientosrestapi.entity.Cliente;
import com.company.movimientosrestapi.repository.ICuentaRepository;
import com.company.movimientosrestapi.service.ClienteServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(ClienteController.class)
class ClienteControllerTest {

    @MockBean
    private ClienteServiceImpl service;

    @Autowired
    private MockMvc mockMvc;


    /*@Test
    void crearCliente() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/cuentas/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}")
        )
                .andExpect(MockMvcResultMatchers.status().isCreated()));

    }

    @Test
    void TestobtenerClientes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cuentas/"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }*/

}