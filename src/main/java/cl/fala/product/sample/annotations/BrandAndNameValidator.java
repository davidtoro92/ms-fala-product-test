package cl.fala.product.sample.annotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

/**
 * @author: David Toro Salamanca.
 * Description: Clase validadora de entrada, logica de anotacion
 * */
public class BrandAndNameValidator implements ConstraintValidator<BrandAndNameValidation, String> {

    private Logger log = LoggerFactory.getLogger(BrandAndNameValidator.class);

    /**
     * @author: David Toro Salamanca.
     * Description: Metodo validador para marca y nombre de producto.
     * */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.debug("BrandAndNameValidator.isValid - Validando campo.");
        return Optional.ofNullable(value).isPresent() && !Optional.ofNullable(value).isEmpty()
                && value.length() >= 3 && value.length() <= 50;
    }
}
