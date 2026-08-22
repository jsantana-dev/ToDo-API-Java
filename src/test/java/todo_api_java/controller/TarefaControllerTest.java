package todo_api_java.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import todo_api_java.dto.request.TarefaCreateDTO;
import tools.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TarefaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCriarTarefaComSucesso() throws Exception {
        TarefaCreateDTO dto = new TarefaCreateDTO();
        dto.setTitulo("Testes de integração");
        dto.setDescricao("Fase 9, refatoração de códigos");

        mockMvc.perform(post("/tarefas")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.titulo").value("Testes de integração"))
                .andExpect(jsonPath("$.status").value("PENDENTE"));
    }

    @Test
    void deveRetornar400EmTituloBranco() throws Exception {
        TarefaCreateDTO dto = new TarefaCreateDTO();
        dto.setDescricao("Sem título");

        mockMvc.perform(post("/tarefas")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void deveRetornar404EmTarefaInexistente() throws Exception {
        mockMvc.perform(get("/tarefas/99999"))
                .andExpect(status().isNotFound());
    }
}