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
public class SkuValidator implements ConstraintValidator<SkuValidation, String> {

    private Logger log = LoggerFactory.getLogger(SkuValidator.class);

    /**
     * @author: David Toro Salamanca.
     * Description: Metodo validador para sku de producto.
     * */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        log.debug("SkuValidator.isValid - Validando campo SKU.");
        try {
            int skuIdInt = Integer.parseInt(Optional.ofNullable(value.replace("FAL-", "")).orElse("0"));
            return skuIdInt >= 1000000 && skuIdInt <= 99999999;
        } catch(Exception es) {
            return false;
        }
    }
}
