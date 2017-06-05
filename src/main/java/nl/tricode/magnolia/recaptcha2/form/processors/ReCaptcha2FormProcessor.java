package nl.tricode.magnolia.recaptcha2.form.processors;

import com.google.common.base.Strings;
import info.magnolia.module.form.processors.AbstractFormProcessor;
import info.magnolia.module.form.processors.FormProcessorFailedException;
import nl.tricode.magnolia.MagnoliaRecaptcha2;
import nl.tricode.magnolia.recaptcha2.ReCaptcha2;

import javax.inject.Inject;
import javax.jcr.Node;
import java.util.Map;

/**
 * Re captcha form processor validate recaptcha on form submit.
 * @author Lazo Apostolovski
 */
public class ReCaptcha2FormProcessor extends AbstractFormProcessor {

    private final MagnoliaRecaptcha2 module;

    @Inject
    public ReCaptcha2FormProcessor(final MagnoliaRecaptcha2 module) {
        this.module = module;
    }

    @Override
    protected void internalProcess(Node node, Map<String, Object> map) throws FormProcessorFailedException {
        final String secret = module.getReCaptchaSecret();
        if(Strings.isNullOrEmpty(secret)) {
            return;
        }

        final boolean isValid = ReCaptcha2.isSuccess(secret, (String)map.get("g-recaptcha-response"));

        if(!isValid) {
            throw new FormProcessorFailedException("javax.validation.constraints.recaptcha.message");
        }
    }
}
