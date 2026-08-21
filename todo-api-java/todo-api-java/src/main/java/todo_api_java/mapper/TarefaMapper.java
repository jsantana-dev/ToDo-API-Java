package todo_api_java.mapper;

import org.springframework.stereotype.Component;
import todo_api_java.dto.response.TarefaResponseDTO;
import todo_api_java.model.Tarefa;

@Component
public class TarefaMapper {

    public TarefaResponseDTO paraResponseDTO(Tarefa tarefa) {
        return new TarefaResponseDTO(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getStatus(),
                tarefa.getDataCriacao()
        );
    }
}
