package br.com.gigalike.medWal.dto;

/**
 * Classe TokenResponseDto é uma representação dos dados de resposta contendo mensagem
 * (se foi gereado com sucesso ou não) e token
 * @author Waldir Tiago
 * */

public record TokenResponseDto(String mensagem, String token) {
}
