package todo_api_java.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TratadorGlobalDeExcecoes {

    @ExceptionHandler(TarefaNaoEncontradaException.class)
    public ResponseEntity<ErroResposta> tratarTarefaNaoEncontrada(TarefaNaoEncontradaException ex) {
        ErroResposta erro = new ErroResposta(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }
}
