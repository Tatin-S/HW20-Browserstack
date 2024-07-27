package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:${env}.properties",
})
public interface BrowserstackConfig extends Config {
    @Key("browserstackApp")
    @DefaultValue("bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c")
    String browserstackApp();

    @Key("browserstackDevice")
    @DefaultValue("Google Pixel 3")
    String browserstackDevice();

    @Key("browserstackPlatform")
   @DefaultValue("9.0")
    String browserstackPlatform();

    @Key("browserstackProject")
    @DefaultValue("First Java Project")
    String browserstackProject();

    @Key("browserstackBuild")
    @DefaultValue("browserstack-build-1")
    String browserstackBuild();

    @Key("browserstackName")
    @DefaultValue("first_test")
    String browserstackName();

    @Key("browserstackUrl")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String browserstackUrl();
}