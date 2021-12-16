package cl.fala.product.sample.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

import static cl.fala.product.sample.util.ProductUtil.PRODUCT_DOES_NOT_EXISTS_ERROR;

@ControllerAdvice
public class CustomExceptionHandler {

    private Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity productNotFoundExceptionHandler(EntityNotFoundException notFound) {
        log.info("[CustomExceptionHandler.productNotFoundExceptionHandler]  ->  Oops. No encontramos el producto que andas buscando :(");
        log.error(String.format("[CustomExceptionHandler.productNotFoundExceptionHandler]  -> %s", notFound.getMessage()));
        return new ResponseEntity("Oops. No encontramos el producto que andas buscando :(", HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity restArgsExceptionHandler(MethodArgumentNotValidException argsExcp) {
        log.info("[CustomExceptionHandler.restArgsExceptionHandler]  ->  Parametros de entrada incorrectos.");
        log.error(String.format("[CustomExceptionHandler.restArgsExceptionHandler]  ->  ", argsExcp.getMessage()));
        return new ResponseEntity(new ProductCustomError(String.valueOf(HttpStatus.BAD_REQUEST.value())
                , "Error en el body de entrada al servicio"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity genericExceptionHandler(RuntimeException runEx) {
        log.info("[CustomExceptionHandler.genericExceptionHandler]  ->  Error interno en MS");
        log.error(String.format("[CustomExceptionHandler.genericExceptionHandler]  ->  %s", runEx.getMessage()));
        return new ResponseEntity(new ProductCustomError(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                "Houston tenemos problemas. Estamos trabajando en nuestro desastre..."), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomProductExistMatterException.class)
    public ResponseEntity customProductExistMatterExceptionHandler(CustomProductExistMatterException runEx) {
        log.info("[CustomExceptionHandler.customProductDoesExistExceptionHandler]  ->  Problemas con la existencia de producto");
        log.error(String.format("[CustomExceptionHandler.customProductExistMatterExceptionHandler]  ->  %s", runEx.getMessage()));
        if(runEx.getMessage().equalsIgnoreCase(PRODUCT_DOES_NOT_EXISTS_ERROR)) {
            log.info("[CustomExceptionHandler.customProductDoesExistExceptionHandler]  ->  Producto no existe");
            return new ResponseEntity(new ProductCustomError(String.valueOf(HttpStatus.NO_CONTENT.value()),
                    "Producto inexistente para ser actualizado."), HttpStatus.NO_CONTENT);
        } else {
            log.info("[CustomExceptionHandler.customProductDoesExistExceptionHandler]  ->  Producto ya existente");
            return new ResponseEntity(new ProductCustomError(String.valueOf(HttpStatus.CONFLICT.value()),
                    "Producto ya existe con el SKU ingresado."), HttpStatus.CONFLICT);
        }
    }


}
