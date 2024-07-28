package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:${deviceHost}.properties",
        "classpath:emulation.properties"
})
public interface MobileDriverConfig extends Config {

    String automationName();

    String deviceName();

    String platformName();

    String appPackage();

    String appActivity();

    String appVersion();

    String appLanguage();

    String appLocale();

    String appUrl();

    @DefaultValue("http://localhost:4723/")
    String appiumUrl();

}
