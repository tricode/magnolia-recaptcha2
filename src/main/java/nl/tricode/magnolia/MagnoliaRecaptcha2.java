package nl.tricode.magnolia;

/**
 * This class is optional and represents the configuration for the magnolia-recaptcha2 module.
 * By exposing simple getter/setter/adder methods, this bean can be configured via content2bean
 * using the properties and node from <tt>config:/modules/magnolia-recaptcha2</tt>.
 * If you don't need this, simply remove the reference to this class in the module descriptor xml.
 *
 * @author Lazo Apostolovski
 */
public class MagnoliaRecaptcha2 {
    private String reCaptchaSecret;
    private String reCaptchaSiteKey;

    public String getReCaptchaSecret() {
        return reCaptchaSecret;
    }

    public void setReCaptchaSecret(String reCaptchaSecret) {
        this.reCaptchaSecret = reCaptchaSecret;
    }

    public String getReCaptchaSiteKey() {
        return reCaptchaSiteKey;
    }

    public void setReCaptchaSiteKey(String reCaptchaSiteKey) {
        this.reCaptchaSiteKey = reCaptchaSiteKey;
    }
}
