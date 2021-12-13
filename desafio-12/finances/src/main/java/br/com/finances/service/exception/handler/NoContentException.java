package br.com.finances.service.exception.handler;

public class NoContentException extends  RuntimeException {
    public NoContentException(String msg) {
        super(msg);
    }
}
