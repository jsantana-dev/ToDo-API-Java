package todo_api_java.dto.response;

import todo_api_java.model.Status;

import java.time.LocalDateTime;

public class TarefaResponseDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private Status status;
    private LocalDateTime dataCriacao;

    public TarefaResponseDTO(Long id, String titulo, String descricao, Status status, LocalDateTime dataCriacao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}

/*
formato que vai sair da API
 */