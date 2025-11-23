package br.com.gigalike.medWal.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Classe EnderecoDto é uma representação dos dados de entrada ou saida de um endereço
 * @author Waldir Tiago
 * */

@JsonIgnoreProperties
public record EnderecoDto(
        long id,
        @NotBlank(message = "É obrigatório preencher o campo Logradouro")
        String logradouro,
        @NotBlank(message = "É obrigatório preencher o campo Bairro")
        String bairro,
        @NotBlank(message = "É obrigatório preencher o campo CEP")
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank(message = "É obrigatório preencher o campo Cidade")
        String cidade,
        @NotBlank(message = "É obrigatório preencher o campo UF")
        @Size(min = 2, max = 2, message = "A UF deve ser informada.")
        String uf,
        String complemento,
        @NotBlank(message = "É obrigatório preencher o campo Número")
        String numero,
        long id_medico) {

}
