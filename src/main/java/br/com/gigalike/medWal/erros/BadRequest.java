package br.com.gigalike.medWal.erros;

public class BadRequest extends RuntimeException {
    public BadRequest(String message) {
        super(message);
    }
}
