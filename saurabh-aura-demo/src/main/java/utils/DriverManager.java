package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverManager {
  public static WebDriver getDriverInstance(String browserName) {
    WebDriver driver = null;
    if (browserName.equalsIgnoreCase("chrome")) {
      WebDriverManager.chromedriver().setup();
      ChromeOptions chromeOptions = new ChromeOptions();
      if(TestDataLoader.getProperty("mode").equalsIgnoreCase("headless")) {
        chromeOptions.addArguments("--headless");
      }
      driver = new ChromeDriver(chromeOptions);
      driver.manage().window().maximize();
      driver.manage().timeouts()
        .implicitlyWait(60, TimeUnit.SECONDS);
      driver.manage().timeouts()
        .pageLoadTimeout(60, TimeUnit.SECONDS);
    }
    return driver;
  }
}
