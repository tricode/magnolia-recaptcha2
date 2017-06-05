package nl.tricode.magnolia.recaptcha2.validation;

import com.google.common.base.Strings;
import info.magnolia.objectfactory.Components;
import nl.tricode.magnolia.MagnoliaRecaptcha2;
import nl.tricode.magnolia.recaptcha2.ReCaptcha2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Re captcha validator.
 * @author Lazo Apostolovski
 */
public class ReCaptchaValidator implements ConstraintValidator<ReCaptcha, String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReCaptchaValidator.class);

    @Override
    public void initialize(ReCaptcha constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        final String secret = Components.getComponentProvider().getComponent(MagnoliaRecaptcha2.class).getReCaptchaSecret();
        if (Strings.isNullOrEmpty(secret)) {
            return true;
        }

        final boolean isValid = ReCaptcha2.isSuccess(secret, value);

        LOGGER.debug("Recaptcha validation result: {}", isValid);

        return isValid;
    }
}
