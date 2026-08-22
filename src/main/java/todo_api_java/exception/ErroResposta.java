package todo_api_java.exception;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class ErroResposta {

    private int status;
    private String mensagem;
    private LocalDateTime timestamp;

    public ErroResposta(int status, String mensagem, LocalDateTime timestamp) {
        this.status = status;
        this.mensagem = mensagem;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }
    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

/*
classe simples criada para padronizar o erro em formato JSON
*/