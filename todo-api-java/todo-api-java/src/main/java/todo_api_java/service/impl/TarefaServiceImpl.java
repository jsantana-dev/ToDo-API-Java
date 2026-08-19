package todo_api_java.service.impl;

import org.springframework.stereotype.Service;
import todo_api_java.model.Status;
import todo_api_java.model.Tarefa;
import todo_api_java.repository.TarefaRepository;
import todo_api_java.service.TarefaService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TarefaServiceImpl implements TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaServiceImpl(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Override
    public Tarefa criar(String titulo, String descricao) {
        Tarefa tarefa = new Tarefa(titulo, descricao);
        return tarefaRepository.save(tarefa);
    }

    @Override
    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    @Override
    public Tarefa buscarPorId(Long id) {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Tarefa não encontrada com id: " + id));
    }

    @Override
    public Tarefa atualizar(Long id, String titulo, String descricao) {
        Tarefa tarefa = buscarPorId(id);
        tarefa.setTitulo(titulo);
        tarefa.setDescricao(descricao);
        return tarefaRepository.save(tarefa);
    }

    @Override
    public Tarefa marcarComoCompleta(Long id) {
        Tarefa tarefa = buscarPorId(id);
        tarefa.setStatus(Status.COMPLETO);
        return tarefaRepository.save(tarefa);
    }

    @Override
    public void deletar(Long id) {
        Tarefa tarefa = buscarPorId(id);
        tarefaRepository.deleteById(id);
    }
}