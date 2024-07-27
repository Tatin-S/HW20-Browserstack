package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:${env}.properties",
        "classpath:android.properties"
})
public interface BrowserstackConfig extends Config {
    @DefaultValue("bs://7149dde8bfb8309f035fa3279374dd8cd85f6c1d")
    String browserstackApp();
    @DefaultValue("Samsung Galaxy S23 Ultra")
    String browserstackDevice();
    @DefaultValue("13.0")
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