package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumHelper;
import utils.TestDataLoader;
import org.testng.Assert;

import pageObjects.AccountAuthenticationPageObjects;

public class AccountAuthenticationPageSteps {

  public AccountAuthenticationPageSteps(WebDriver driver) {
    PageFactory.initElements(driver, AccountAuthenticationPageObjects.class);
  }

  public void openAuthenticationPage() {
    new SeleniumHelper().openURL(TestDataLoader.getProperty("myAccountUrl"));
  }

  public void enterEmail(String email) {
    AccountAuthenticationPageObjects.emailAddress.sendKeys(email);
  }

  public void clickCreateAccButton() {
    AccountAuthenticationPageObjects.createAccButton.click();
  }

  public void verifyAccCreationErrorMsgIsDisplayed() {
    boolean isErrorDisplayed = new SeleniumHelper().isElementDisplayed(AccountAuthenticationPageObjects.createAccountError, 30);
    Assert.assertTrue(isErrorDisplayed, "Create account error message should be displayed");
  }

}
