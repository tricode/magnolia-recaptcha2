[#-- reCAPTCHA v2. Visible recaptcha, validate users with the "I'm not a robot" checkbox. --]
[#macro reCaptchaField callback=""]
    <div class="g-recaptcha" data-size="normal" data-sitekey="${rec2fn.reCaptchaSiteKey!}" [#if callback != ""]data-callback="${callback}"[/#if]></div>
[/#macro]

[#-- Invisible reCAPTCHA. validate users in the background. --]
[#macro reCaptchaInvisible title callback=""]
    <button class="g-recaptcha" data-sitekey="${rec2fn.reCaptchaSiteKey!}" [#if callback != ""]data-callback="${callback}"[/#if]>>
        ${title}
    </button>
[/#macro]