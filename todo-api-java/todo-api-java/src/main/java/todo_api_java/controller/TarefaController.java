package todo_api_java.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo_api_java.dto.request.TarefaCreateDTO;
import todo_api_java.dto.request.TarefaUpdateDTO;
import todo_api_java.dto.response.TarefaResponseDTO;
import todo_api_java.mapper.TarefaMapper;
import todo_api_java.model.Tarefa;
import todo_api_java.service.TarefaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tarefas") //prefixo da URL
public class TarefaController {

    private final TarefaService tarefaService;
    private final TarefaMapper tarefaMapper;

    public TarefaController(TarefaService tarefaService, TarefaMapper tarefaMapper) {
        this.tarefaService = tarefaService;
        this.tarefaMapper = tarefaMapper;
    }

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> criar(@Valid @RequestBody TarefaCreateDTO dados) {
        Tarefa tarefa = tarefaService.criar(dados.getTitulo(), dados.getDescricao());
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaMapper.paraResponseDTO(tarefa));
    }

    /*
    aqui será transformado cada item em uma lista
    stream processa, o map aplica a conversão e collect junta tudo numa nova lista
     */
    @GetMapping
    public ResponseEntity<List<TarefaResponseDTO>> listarTodas() {
        List<TarefaResponseDTO> tarefas = tarefaService.listarTodas().stream()
                .map(tarefaMapper::paraResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> buscarPorId(@PathVariable Long id) {
        Tarefa tarefa = tarefaService.buscarPorId(id);
        return ResponseEntity.ok(tarefaMapper.paraResponseDTO(tarefa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody TarefaUpdateDTO dados) {
        Tarefa tarefa = tarefaService.atualizar(id, dados.getTitulo(), dados.getDescricao());
        return ResponseEntity.ok(tarefaMapper.paraResponseDTO(tarefa));
    }

    @PatchMapping("/{id}/completar")
    public ResponseEntity<TarefaResponseDTO> marcarComoCompleta(@PathVariable Long id) {
        Tarefa tarefa = tarefaService.marcarComoCompleta(id);
        return ResponseEntity.ok(tarefaMapper.paraResponseDTO(tarefa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

/*
controller agora depende do mapper para conversão de respostas
recebe do TarefaCreateDTO, o @Valid utiliza o @NotBlank
 */