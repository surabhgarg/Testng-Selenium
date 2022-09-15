package utils;

import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import DataLoaderUtil;


public class DriverSetting {
  protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

  
  public static WebDriver getDriverInstance(String browserName) {
	    WebDriver driver = null;
	    if (browserName.equalsIgnoreCase("chrome")) {
	      WebDriverManager.chromedriver().setup();
	      ChromeOptions chromeOptions = new ChromeOptions();
	      if(DataLoaderUtil.getProperty("mode").equalsIgnoreCase("headless")) {
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
  
  @BeforeMethod
  public void Setup() {
    WebDriver driver = getDriverInstance(DataLoaderUtil.getProperty("browser"));
    threadLocalDriver.set(driver);
  }

  public static WebDriver getDriver() {
    return threadLocalDriver.get();
  }

  @AfterMethod
  public void tearDown() {
    getDriver().quit();
    threadLocalDriver.remove();
  }
  
  
}
