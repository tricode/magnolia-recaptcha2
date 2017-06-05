package nl.tricode.magnolia.recaptcha2.validation;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The annotated string must be valid recaptcha response.
 * Accepts string.
 *
 * @author Lazo Apostolovski
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ReCaptchaValidator.class})
@ReportAsSingleViolation
@NotEmpty
@NotNull
public @interface ReCaptcha {

    String message() default "{javax.validation.constraints.recaptcha.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
