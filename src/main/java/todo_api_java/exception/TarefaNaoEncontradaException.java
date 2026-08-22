package todo_api_java.exception;

public class TarefaNaoEncontradaException extends RuntimeException {
    public TarefaNaoEncontradaException(Long id) {
        super("Tarefa não encontrada com id: " + id);
    }
}
