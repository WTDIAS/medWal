package br.com.gigalike.medWal.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;

/**
 * Classe UserDto é uma representação dos dados de um usuário (login e senha)
 * @author Waldir Tiago
 * */

@JsonIgnoreProperties
public record UserDto(
        long id,
        @NotBlank(message = "O login é um campo obrigatório")
        String login,
        @NotBlank(message = "A senha é um campo obrigatório")
        String senha) {
}
