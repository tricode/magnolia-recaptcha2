# magnolia-recaptcha2
[Google ReCaptcha2 API](https://www.google.com/recaptcha) module for [Magnolia cms](http://www.magnolia-cms.com).

In this module we provide classes, annotations and form procerssors for easy and fast usage of Google ReCaptcha2 API.

## Features
### Freemarker macros usage
To use this module, include it in your module dependencies. In freemarker templates you can add recaptcha field by including
[#include "/magnolia-recaptcha2/templates/macros/recaptcha2.ftl"] which contains 2 macros:
 * reCaptchaField - render recaptcha with checkbox. Accept one parameter "callback" that can be used with API callback function name.
 * reCaptchaInvisible - render invisible recaptcha. Accept one parameter "callback" that can be used with API callback function name.

### Validation annotation @ReCaptcha usage
You can use: nl.tricode.magnolia.recaptcha2.validation.ReCaptcha annotation to validate recaptcha in rest calls.

### Java class usage
ReCaptcha2 class provides static methods for easy recaptcha response check with api.

### Form processors usage
To use it in form, we provide nl.tricode.magnolia.recaptcha2.form.processors.ReCaptcha2FormProcessor [form processor](https://documentation.magnolia-cms.com/display/DOCS/Form+module#Formmodule-Creatingacustomformprocessor) which validates recaptcha for submitted form.


### Templating functions
Templating functions provides recaptcha site keys are registered under rec2fn and can be used to provide site key to your freemarkers.

## Configuration
After instaling module you need to configure API Site and API Secret key. This keys will be provided to you by [Google ReCaptcha2 API](https://www.google.com/recaptcha) after registering your site.
After you get this keys, place them in Magnolia CMS -> /configuration/modules/magnolia-recaptcha2/config
* reCaptchaSecret
* reCaptchaSiteKey


## Prerequisites
* [git](http://git-scm.com/)
* [java 8](http://java.com)
* [Maven 3](http://maven.apache.org)

## License
Copyright (c) 2015 Tricode and contributors. Released under a [GNUv3 license](https://github.com/tricode/magnolia-recaptcha2/blob/master/LICENSE).