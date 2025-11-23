package br.com.gigalike.medWal.erros;

/**
 * Classe BadRequest é a representação de uma exceção do tipo BadRequest
 * @author Waldir Tiago
 * */

public class BadRequest extends RuntimeException {
    public BadRequest(String message) {
        super(message);
    }
}
