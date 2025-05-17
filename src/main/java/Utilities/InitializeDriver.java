package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

public class InitializeDriver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void initializeDriver() throws Exception {
        ConfigProperties.initializePropertyFile();
        String browserType = ConfigProperties.property.getProperty("browser");

        switch (browserType.toLowerCase()) {
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                break;

            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36");
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions fireOptions = new FirefoxOptions();
                driver = new FirefoxDriver(fireOptions);
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browserType);
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}