package todo_api_java.service;

import todo_api_java.model.Tarefa;
import java.util.List;

public interface TarefaService {

    Tarefa criar(String titulo, String descricao);

    List<Tarefa> listarTodas();

    Tarefa buscarPorId(Long id);

    Tarefa atualizar(Long id, String titulo, String descricao);

    Tarefa marcarComoCompleta(Long id);

    void deletar(Long id);
}

/*
class interface afim de trazer praticidade
para possíveis mudanças de implementações futuras
para testar controller isoladamente
*/