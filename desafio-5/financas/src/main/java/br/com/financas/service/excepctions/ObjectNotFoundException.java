package br.com.financas.service.excepctions;

public class ObjectNotFoundException extends RuntimeException {

    private  static final long  serialVersionUID = 1L;

    public ObjectNotFoundException(String msg) {
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
