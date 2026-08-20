package todo_api_java.dto.request;

import jakarta.validation.constraints.NotBlank;

public class TarefaUpdateDTO {

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
igual ao create, porém, é utilizado para fazer atualizações que o create não alcança
seguindo a regra com @NotBlank para barrar campos vazios/nulos
 */