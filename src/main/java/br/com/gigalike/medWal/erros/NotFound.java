package br.com.gigalike.medWal.erros;

public class NotFound extends RuntimeException {
    public NotFound(String message) {
        super(message);
    }
}
