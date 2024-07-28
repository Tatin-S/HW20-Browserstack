package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.MobileDriverConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class MobileDriver implements WebDriverProvider {
    static MobileDriverConfig config = ConfigFactory.create(MobileDriverConfig.class, System.getProperties());

    public static URL getAppiumServerUrl() {
        try {
            return new URL(config.appiumUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(config.automationName())
                .setPlatformName(config.platformName())
                .setDeviceName(config.deviceName())
                .setApp(getAppPath())
                .setAppPackage(config.appPackage())
                .setAppActivity(config.appActivity())
                .setLanguage(config.appLanguage())
                .setLocale(config.appLocale());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private String getAppPath() {
        String appVersion = config.appVersion();
        String appUrl = config.appUrl() + appVersion;
        String appPath = "src/test/resources/apps/" + appVersion;

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app.getAbsolutePath();
    }
}