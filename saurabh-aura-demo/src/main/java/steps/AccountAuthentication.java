package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pageObjects.AccountAuthenticationPage;
import utils.Helper;

public class AccountAuthentication {

  public AccountAuthentication(WebDriver driver) {
    PageFactory.initElements(driver, AccountAuthenticationPage.class);
  }

  public void openAuthenticationPage() {
    new Helper().openURL(utils.DataLoaderUtil.getProperty("myAccountUrl"));
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
