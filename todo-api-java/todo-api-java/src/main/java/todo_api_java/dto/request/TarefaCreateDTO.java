package todo_api_java.dto.request;

import jakarta.validation.constraints.NotBlank;

public class TarefaCreateDTO {

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    private String descricao;

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
}

/*
feito para enviar apenas na criação
utilizando @NotBlank para impedir títulos vazios/nulo
 */