package br.com.gigalike.medWal.erros;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ResponseError(HttpStatus httpStatus, String mensagem, LocalDateTime dataHora) {
}
