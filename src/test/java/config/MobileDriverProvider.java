package config;

import com.codeborne.selenide.Configuration;
import drivers.BrowserstackDriver;
import drivers.MobileDriver;

public class MobileDriverProvider {

    public void setMobileConfig() {
        String deviceHost = System.getProperty("deviceHost");
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
        if ((deviceHost == null) || deviceHost.equals("browserstack")) {
            Configuration.browser = BrowserstackDriver.class.getName();
        } else {
            Configuration.browser = MobileDriver.class.getName();
        }
    }
}