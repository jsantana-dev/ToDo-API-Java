package todo_api_java.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import todo_api_java.model.Status;
import todo_api_java.model.Tarefa;
import todo_api_java.repository.TarefaRepository;
import todo_api_java.service.impl.TarefaServiceImpl;
import todo_api_java.exception.TarefaNaoEncontradaException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TarefaServiceImplTest {

    @Mock
    private TarefaRepository tarefaRepository;

    @InjectMocks
    private TarefaServiceImpl tarefaService;

    @Test
    void deveCriarTarefaComStatusPendente() {
        Tarefa tarefasalva = new Tarefa("Estudar java","Revisão de SpringBoot");
        when(tarefaRepository.save(any(Tarefa.class))).thenReturn(tarefasalva);

        Tarefa resultado = tarefaService.criar("Estudar java", "Revisão de SpringBoot");

        assertNotNull(resultado);
        assertEquals("Estudar java", resultado.getTitulo());
        assertEquals(Status.PENDENTE, resultado.getStatus());
        verify(tarefaRepository, times(1)).save(any(Tarefa.class));
    }

    @Test
    void deveLancarExcecaoQuandoTarefaNaoExiste() {
        Long idInexistente = 999L;
        when(tarefaRepository.findById(idInexistente)).thenReturn(Optional.empty());

        assertThrows(TarefaNaoEncontradaException.class, () -> {
           tarefaService.buscarPorId(idInexistente);
        });

        verify(tarefaRepository, times(1)).findById(idInexistente);
    }
}

