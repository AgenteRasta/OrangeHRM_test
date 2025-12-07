package co.com.davivienda.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackWebDriver {

    private WebDriver driver;

    public WebDriver configureDriver() throws MalformedURLException {
        String browserstackUser = System.getenv("BROWSERSTACK_USERNAME");
        String browserstackKey = System.getenv("BROWSERSTACK_ACCESS_KEY");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "latest");

        // Opciones específicas de BrowserStack
        capabilities.setCapability("bstack:options", new java.util.HashMap<String, Object>() {{
            put("os", "Windows");
            put("osVersion", "11");
            put("projectName", "OrangeHRM Technical Test");
            put("buildName", "OrangeHRM - BrowserStack");
            put("sessionName", "Flujo PIM + Directory - Screenplay");
            put("seleniumVersion", "4.26.0");
        }});

        String url = "https://" + browserstackUser + ":" + browserstackKey + "@hub.browserstack.com/wd/hub";
        driver = new RemoteWebDriver(new URL(url), capabilities);
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
