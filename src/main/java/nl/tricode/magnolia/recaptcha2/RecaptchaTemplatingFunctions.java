package nl.tricode.magnolia.recaptcha2;

import nl.tricode.magnolia.MagnoliaRecaptcha2;

import javax.inject.Inject;

/**
 * ReCaptcha module templating functions.
 *
 * @author Lazo Apostolovski
 */
public class RecaptchaTemplatingFunctions {

    private final MagnoliaRecaptcha2 recaptcha2;

    @Inject
    public RecaptchaTemplatingFunctions(MagnoliaRecaptcha2 recaptcha2) {
        this.recaptcha2 = recaptcha2;
    }

    /**
     * Returns configured re-captcha api site key.
     * @return re captcha site key.
     */
    public String getReCaptchaSiteKey() {
        return recaptcha2.getReCaptchaSiteKey();
    }
}
