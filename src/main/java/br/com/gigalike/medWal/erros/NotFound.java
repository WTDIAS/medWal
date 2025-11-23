package br.com.gigalike.medWal.erros;

/**
 * Classe NotFound é a representação de uma exceção do tipo NotFound
 * @author Waldir Tiago
 * */

public class NotFound extends RuntimeException {
    public NotFound(String message) {
        super(message);
    }
}
