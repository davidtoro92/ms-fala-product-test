package cl.fala.product.sample.annotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author: David Toro Salamanca.
 * Description: Clase validadora de entrada, logica de anotacion
 * */
public class PriceValidator implements ConstraintValidator<PriceValidation, Double> {

    private Logger log = LoggerFactory.getLogger(PriceValidator.class);

    /**
     * @author: David Toro Salamanca.
     * Description: Metodo validador para precio de producto.
     * */
    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        log.debug("PriceValidator.isValid - Validando campo Precio.");
        try {
            return value >= 1.0 && value <= 99999999.00;
        } catch(Exception es) {
            return false;
        }
    }
}
