package br.com.iftm.user.api.userapi.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;
    private String endereco;
    @NotBlank(message = "Email é obrigatório")
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;

    public UserDTO(String nome, String cpf, String endereco, String email, String telefone, LocalDateTime dataCadastro) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
    }

    public UserDTO() {
    }
}
