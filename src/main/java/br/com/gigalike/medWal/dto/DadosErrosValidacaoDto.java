package br.com.gigalike.medWal.dto;
import org.springframework.validation.FieldError;

/**
 * Classe DadosErrosValidacaoDto é uma representação dos dados vindos das validações do Bean Validation
 * @author Waldir Tiago
 * */

public record DadosErrosValidacaoDto(String campo, String mensagem) {
    public DadosErrosValidacaoDto(FieldError fieldError){
        this(fieldError.getField(),fieldError.getDefaultMessage());
    }
}
