package cl.fala.product.sample.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

/**
 * @author: David Toro Salamanca.
 * Description: Clase de anotación AOP para validar campos de entrada
 * */
@Target( { FIELD, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = BrandAndNameValidator.class)
public @interface BrandAndNameValidation {

    String message() default "El valor del campo no es correcto o es vacio.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

