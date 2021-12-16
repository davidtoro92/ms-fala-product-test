package cl.fala.product.sample.exception;

public class CustomUnwrappException extends RuntimeException {

    public CustomUnwrappException(String message) {
        super(message);
    }
}
