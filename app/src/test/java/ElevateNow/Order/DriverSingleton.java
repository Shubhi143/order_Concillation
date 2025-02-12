package ElevateNow.Order;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSingleton {
    private static WebDriver driver = null;

    
    // Private constructor to prevent instantiation
    private DriverSingleton() {}

    // Method to get the driver instance
    public static WebDriver getDriverInstance(String browserType) {
        if (driver == null) {
            switch (browserType.toLowerCase()) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser type: " + browserType);
            }
        }
        return driver;
    }

    // Method to get the current WebDriver instance
    public static WebDriver getDriver() {
        return driver;
    }
}