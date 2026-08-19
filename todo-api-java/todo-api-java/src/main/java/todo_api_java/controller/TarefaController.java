package todo_api_java.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo_api_java.model.Tarefa;
import todo_api_java.service.TarefaService;

import java.util.List;


@RestController
@RequestMapping("/tarefas") //prefixo da URL
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody Tarefa dados) {
        Tarefa tarefa = tarefaService.criar(dados.getTitulo(), dados.getDescricao());
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTodas() {
        return ResponseEntity.ok(tarefaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tarefaService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa dados) {
        Tarefa tarefa = tarefaService.atualizar(id, dados.getTitulo(), dados.getDescricao());
        return ResponseEntity.ok(tarefa);
    }

    @PatchMapping("/{id}/completar")
    public ResponseEntity<Tarefa> marcarComoCompleta(@PathVariable Long id) {
        return ResponseEntity.ok(tarefaService.marcarComoCompleta(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
