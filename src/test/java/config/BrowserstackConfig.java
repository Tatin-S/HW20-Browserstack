package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:${env}.properties",
        "classpath:android.properties"
})
public interface BrowserstackConfig extends Config {
    @DefaultValue("bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c")
    String browserstackApp();
    @DefaultValue("Google Pixel 8")
    String browserstackDevice();
    @DefaultValue("14.0")
    String browserstackPlatform();
    @DefaultValue("First Java Project")
    String browserstackProject();
    @DefaultValue("browserstack-build-1")
    String browserstackBuild();
    @DefaultValue("first_test")
    String browserstackName();
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String browserstackUrl();
}