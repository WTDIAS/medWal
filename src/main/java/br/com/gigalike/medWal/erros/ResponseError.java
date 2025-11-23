package br.com.gigalike.medWal.erros;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * Record ResponseError é uma representação dos dados que serão devolvidos quando acontecer uma exceção
 * @author Waldir Tiago
 * */

public record ResponseError(HttpStatus httpStatus, String mensagem, LocalDateTime dataHora) {
}
