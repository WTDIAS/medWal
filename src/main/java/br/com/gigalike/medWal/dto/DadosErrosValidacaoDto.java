package br.com.gigalike.medWal.dto;

import org.springframework.validation.FieldError;

public record DadosErrosValidacaoDto(String campo, String mensagem) {
    public DadosErrosValidacaoDto(FieldError fieldError){
        this(fieldError.getField(),fieldError.getDefaultMessage());
    }
}
