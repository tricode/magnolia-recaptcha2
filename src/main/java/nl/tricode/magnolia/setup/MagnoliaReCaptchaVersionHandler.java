package nl.tricode.magnolia.setup;

import com.google.common.collect.Lists;
import info.magnolia.module.DefaultModuleVersionHandler;
import info.magnolia.module.InstallContext;
import info.magnolia.module.delta.BootstrapSingleModuleResource;
import info.magnolia.module.delta.Task;

import java.util.List;

/**
 * This class handles installation and updates of the module.
 *
 * @author Lazo Apostolovski
 */
public class MagnoliaReCaptchaVersionHandler extends DefaultModuleVersionHandler {

    @Override
    protected List<Task> getExtraInstallTasks(InstallContext installContext) {
        final List<Task> tasks = Lists.newArrayList();

        tasks.addAll(super.getStartupTasks(installContext));

        tasks.add(new BootstrapSingleModuleResource("basic-recaptcha-module-configuration", "Basic re captcha module configuration", "config/config.modules.magnolia-recaptcha2.config.yaml"));
        tasks.add(new BootstrapSingleModuleResource("re-captcha-templating-function", "ReCaptcha 2 templating functions.", "config/config.modules.rendering.renderers.freemarker.contextAttributes.rec2fn.yaml"));

        return tasks;
    }

}
