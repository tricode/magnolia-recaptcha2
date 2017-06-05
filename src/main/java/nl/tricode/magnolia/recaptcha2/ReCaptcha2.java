package nl.tricode.magnolia.recaptcha2;

import com.google.common.base.Strings;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Google re-captcha API connector.
 * @author Lazo Apostolovski
 */
public class ReCaptcha2 {

    /**
     * Verify re captcha status.
     *
     * @param secret The shared key between your site and reCAPTCHA.
     * @param response The user response token provided by reCAPTCHA, verifying the user on your site.
     * @return Google Re-Captcha API result.
     */
    public static ReCaptchaResponse verify(final String secret, final String response) {
        return verify(secret, response, null);
    }

    /**
     * Verify re captcha status.
     *
     * @param secret The shared key between your site and reCAPTCHA.
     * @param response The user response token provided by reCAPTCHA, verifying the user on your site.
     * @param remoteIp The user's IP address.
     * @return Google Re-Captcha API result.
     */
    public static ReCaptchaResponse verify(final String secret, final String response, final String remoteIp) {

        final MultivaluedMap<String, String> queryParams = new MultivaluedHashMap<>();
        queryParams.addAll("secret", secret);
        queryParams.addAll("response", response);
        if(!Strings.isNullOrEmpty(remoteIp)) {
            queryParams.addAll("remoteip", remoteIp);
        }

        final Client client = ClientBuilder.newClient();
        WebTarget target = client.target(GOOGLE_API);

        return target.request().post(Entity.form(queryParams), ReCaptchaResponse.class);
    }

    private static final String GOOGLE_API = "https://www.google.com/recaptcha/api/siteverify";

    private final String secret;

    public ReCaptcha2(final String secret) {
        this.secret = secret;
    }

    /**
     * Verify re captcha status.
     *
     * @param response The user response token provided by reCAPTCHA, verifying the user on your site.
     * @return Google Re-Captcha API result.
     */
    public ReCaptchaResponse verifyResponse(final String response) {
        return verify(secret, response, null);
    }

    /**
     * Verify re captcha status.
     *
     * @param response The user response token provided by reCAPTCHA, verifying the user on your site.
     * @param remoteIp The user's IP address.
     * @return Google Re-Captcha API result.
     */
    public ReCaptchaResponse verifyResponse(final String response, final String remoteIp) {
        return verify(secret, response, remoteIp);
    }

    /**
     * Verify re captcha status.
     *
     * @param response The user response token provided by reCAPTCHA, verifying the user on your site.
     * @return boolean value for success.
     */
    public boolean verifySuccess(final String response) {
        return verify(secret, response, null).isSuccess();
    }

    /**
     * Verify re captcha status.
     *
     * @param response The user response token provided by reCAPTCHA, verifying the user on your site.
     * @param remoteIp The user's IP address.
     * @return boolean value for success.
     */
    public boolean verifySuccess(final String response, final String remoteIp) {
        return verify(secret, response, remoteIp).isSuccess();
    }

    /**
     * Verify re captcha status.
     *
     * @param secret The shared key between your site and reCAPTCHA.
     * @param response The user response token provided by reCAPTCHA, verifying the user on your site.
     * @return boolean value for success.
     */
    public static boolean isSuccess(final String secret, final String response) {
        return verify(secret, response, null).isSuccess();
    }

    /**
     * Verify re captcha status.
     *
     * @param secret The shared key between your site and reCAPTCHA.
     * @param response The user response token provided by reCAPTCHA, verifying the user on your site.
     * @param remoteIp The user's IP address.
     * @return boolean value for success.
     */
    public static boolean isSuccess(final String secret, final String response, final String remoteIp) {
        return verify(secret, response, remoteIp).isSuccess();
    }

}
