package todo_api_java.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity //tabela no banco de dados
@Table(name = "tarefas") //nome da tabela
public class Tarefa {

    @Id //chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //incrementa numeração automática
    private Long id;

    @Column(nullable = false)
    private String titulo; //não pode ficar vazia (sem título)

    private String descricao; //pode ficar vazia

    @Enumerated(EnumType.STRING) //salva o enum como texto
    @Column(nullable = false)
    private Status status;

    @Column(name = "data_criacao", nullable = false, updatable = false) //não recebe atualização
    private LocalDateTime dataCriacao;

    public Tarefa(){}

    public Tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = Status.PENDENTE;
        this.dataCriacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
