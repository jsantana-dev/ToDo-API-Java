package todo_api_java.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import todo_api_java.model.Status;
import todo_api_java.model.Tarefa;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TarefaRepositoryTest {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Test
    void SalvarEncontrarTarefaId() {
        Tarefa tarefa = new Tarefa("DataJpaTest", "Continuação fase 9");
        Tarefa tarefaSalva = tarefaRepository.save(tarefa);

        Optional<Tarefa> tarefaEncontrada = tarefaRepository.findById(tarefaSalva.getId());

        assertTrue(tarefaEncontrada.isPresent());
        assertEquals("DataJpaTest", tarefaEncontrada.get().getTitulo());
        assertEquals(Status.PENDENTE, tarefaEncontrada.get().getStatus());
    }

    @Test
    void ListarTodasTarefasSalvas() {
        tarefaRepository.save(new Tarefa("Tarefa 1", "Descrição 1"));
        tarefaRepository.save(new Tarefa("Tarefa 2", "Descrição 2"));

        List<Tarefa> tarefas = tarefaRepository.findAll();

        assertEquals(2, tarefas.size());
    }

    @Test
    void RetornarOptionalVazioQuandoIdInexistente() {
        Optional<Tarefa> tarefaEncontrada = tarefaRepository.findById(999L);

        assertTrue(tarefaEncontrada.isEmpty());
    }

    @Test
    void DeletarTarefaId() {
        Tarefa tarefa = tarefaRepository.save(new Tarefa("Tarefa a deletar", "Desc"));
        Long id = tarefa.getId();

        tarefaRepository.deleteById(id);

        assertTrue(tarefaRepository.findById(id).isEmpty());
    }
}

/*
@DataJpaTest pega um bano h2 em memória isolado para o teste
subindo camadas relacionadas a persistência
rollback
 */