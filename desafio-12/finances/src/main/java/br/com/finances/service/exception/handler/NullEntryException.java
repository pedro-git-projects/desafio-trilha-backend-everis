package br.com.finances.service.exception.handler;

public class NullEntryException extends  RuntimeException {
    public NullEntryException(String msg) {
        super(msg);
    }
}
