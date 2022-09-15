package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper extends DriverSetting {

  public void openURL(String url) {
    getDriver().get(url);
  }

  public WebElement waitForElementToBeDisplayed(WebElement element, long timeoutInSeconds) {
    return new WebDriverWait(getDriver(), timeoutInSeconds).until(ExpectedConditions.visibilityOf(element));
  }

  public boolean isElementDisplayed(WebElement element) {
    try {
      return element.isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isElementDisplayed(WebElement element, long timeoutInSeconds) {
    try {
      return waitForElementToBeDisplayed(element, timeoutInSeconds).isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
