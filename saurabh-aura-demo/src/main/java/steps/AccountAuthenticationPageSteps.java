package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Helper;

import org.testng.Assert;

import DataLoaderUtil;
import pageObjects.AccountAuthenticationPage;

public class AccountAuthenticationPageSteps {

  public AccountAuthenticationPageSteps(WebDriver driver) {
    PageFactory.initElements(driver, AccountAuthenticationPage.class);
  }

  public void openAuthenticationPage() {
    new Helper().openURL(DataLoaderUtil.getProperty("myAccountUrl"));
  }

  public void enterEmail(String email) {
    AccountAuthenticationPage.emailAddress.sendKeys(email);
  }

  public void clickCreateAccButton() {
    AccountAuthenticationPage.createAccButton.click();
  }

  public void verifyAccCreationErrorMsgIsDisplayed() {
    boolean isErrorDisplayed = new Helper().isElementDisplayed(AccountAuthenticationPage.createAccountError, 30);
    Assert.assertTrue(isErrorDisplayed, "Create account error message should be displayed");
  }

}
