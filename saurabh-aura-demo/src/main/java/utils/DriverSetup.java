package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverSetup {
  protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

  @BeforeMethod
  public void Setup() {
    WebDriver driver = DriverManager.getDriverInstance(TestDataLoader.getProperty("browser"));
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
