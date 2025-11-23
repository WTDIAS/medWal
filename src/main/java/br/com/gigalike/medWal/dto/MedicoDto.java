package br.com.gigalike.medWal.dto;
import br.com.gigalike.medWal.model.Especialidade;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * Classe MedicoDto é uma representação dos dados de entrada ou saida de um médico
 * @author Waldir Tiago
 * */

@JsonIgnoreProperties
public record MedicoDto(
        long id,
        @NotBlank(message = "É obrigatório preencher o campo Nome")
        String nome,
        @NotBlank(message = "É obrigatório preencher o campo E-mail")
        @Email
        String email,
        @NotBlank(message = "É obrigatório preencher o campo telefone")
        String telefone,
        @NotBlank(message = "É obrigatório preencher o campo CRM")
        @Pattern(regexp = "\\d{4,6}",message = "CRM deve ser preenchido e conter de 4 a 6 dígitos")
        String crm,
        @NotNull(message = "É obrigatório preencher o campo Especialidade")
        Especialidade especialidade,
        @NotNull(message = "É obrigatório informar o campo ativo")
        boolean ativo) {

}
