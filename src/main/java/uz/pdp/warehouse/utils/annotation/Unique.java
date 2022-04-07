package uz.pdp.warehouse.utils.annotation;

import lombok.NonNull;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author Aziza Tojiboyeva
 */

@Documented
@Constraint(validatedBy = {UniqueAnnotation.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface Unique {

    UniqueType type() default UniqueType.DEFAULT;

    String message() default "PLease, provide correct format for the email!, like => abs@gmail.com";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
