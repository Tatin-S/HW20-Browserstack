package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    static final AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
    private static final BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("userName", authConfig.username());
        caps.setCapability("accessKey", authConfig.password());

        caps.setCapability("app", config.browserstackApp());

        caps.setCapability("deviceName", config.browserstackDevice());
        caps.setCapability("platformVersion", config.browserstackPlatform());

        caps.setCapability("projectName", config.browserstackProject());
        caps.setCapability("buildName", config.browserstackBuild());
        caps.setCapability("name", config.browserstackName());

        try {
            return new RemoteWebDriver(
                    new URL(config.browserstackUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}