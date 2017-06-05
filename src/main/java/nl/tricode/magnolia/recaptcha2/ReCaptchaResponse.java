package nl.tricode.magnolia.recaptcha2;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Re captcha response.
 * @author Lazo Apostolovski
 */
public class ReCaptchaResponse {
    private boolean success;
    @JsonProperty("challenge_ts")
    private String timeStamp;
    @JsonProperty("hostname")
    private String hostName;
    @JsonProperty("error-codes")
    private List<String> errorCodes;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public List<String> getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(List<String> errorCodes) {
        this.errorCodes = errorCodes;
    }
}
