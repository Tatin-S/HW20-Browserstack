package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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
/*        DesiredCapabilities caps = new DesiredCapabilities();
        HashMap<String,Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("projectName",config.browserstackProject());
        browserstackOptions.put("appStoreConfiguration", new HashMap<String,String>()
        {{put("userName", authConfig.username());put("password", authConfig.password());}});

        caps.setCapability("bstack:options", browserstackOptions);
        caps.setCapability("platformName", config.browserstackplatformName());
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
        }*/
        DesiredCapabilities caps = new DesiredCapabilities();
    /*    HashMap<String,Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("projectName","test");*/
/*        browserstackOptions.put("appStoreConfiguration", new HashMap<String,String>()
        {{put("username", "alexanderveber_scKk7u");put("password", "wS5KzeFZM74kNzW6yazZ");}});*/
        caps.setCapability("browserstack.user", "alexanderveber_scKk7u");
        caps.setCapability("browserstack.key", "wS5KzeFZM74kNzW6yazZ");
        caps.setCapability("platformName", "android");
        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        caps.setCapability("deviceName", "Google Pixel 3");
        caps.setCapability("platformVersion", "9.0");
        caps.setCapability("projectName", "test");
        caps.setCapability("buildName", "test");
        caps.setCapability("name", "test");

        try {
            return new RemoteWebDriver(
                    new URL("https://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}