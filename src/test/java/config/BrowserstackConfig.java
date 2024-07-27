package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:${env}.properties",
        "file:~/${env}.properties"
})
public interface BrowserstackConfig extends Config {
    String browserstackApp();
    String browserstackDevice();
    String browserstackPlatform();
    String browserstackProject();
    String browserstackBuild();
    String browserstackName();
    String browserstackUrl();
}