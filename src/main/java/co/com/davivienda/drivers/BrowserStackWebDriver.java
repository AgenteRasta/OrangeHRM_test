package co.com.davivienda.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserStackWebDriver {

    private WebDriver driver;

    public WebDriver configureDriver() throws MalformedURLException {
        String browserstackUser = System.getenv("BROWSERSTACK_USERNAME");
        String browserstackKey = System.getenv("BROWSERSTACK_ACCESS_KEY");

        if (browserstackUser == null || browserstackUser.isEmpty() ||
                browserstackKey == null || browserstackKey.isEmpty()) {
            throw new IllegalArgumentException("Las variables de entorno de BrowserStack no están configuradas correctamente.");
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "latest");

        Map<String, Object> bstackOptions = new HashMap<String, Object>();
        bstackOptions.put("os", "Windows");
        bstackOptions.put("osVersion", "11");
        bstackOptions.put("projectName", "OrangeHRM Technical Test");
        bstackOptions.put("buildName", "OrangeHRM - BrowserStack");
        bstackOptions.put("sessionName", "Flujo PIM + Directory - Screenplay");
        bstackOptions.put("seleniumVersion", "4.26.0");

        capabilities.setCapability("bstack:options", bstackOptions);

        String url = "https://" + browserstackUser + ":" + browserstackKey + "@hub.browserstack.com/wd/hub";
        driver = new RemoteWebDriver(new URL(url), capabilities);
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void cerrarDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

