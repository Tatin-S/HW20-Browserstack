package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})
public interface BrowserstackConfig extends Config {
    String browserstackApp();

    String browserstackDevice();

    String browserstackPlatform();

    String browserstackProject();

    String browserstackBuild();

    String browserstackName();

    String browserstackUrl();

    String browserstackLanguage();

    String browserstackLocale();
}