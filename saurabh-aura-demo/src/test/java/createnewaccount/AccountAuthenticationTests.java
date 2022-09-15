package createnewaccount;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.AccountAuthentication;
import steps.CreateNewAccount;
import utils.DriverSetting;

public class AccountAuthenticationTests extends DriverSetting {

  @BeforeMethod
  public void openAuthenticationPage() {
    AccountAuthentication AccountAuthentication = new AccountAuthentication(getDriver());
    AccountAuthentication.openAuthenticationPage();
  }

  @Test
  public void createAnAccountInvalidEmailTest() {
    AccountAuthentication AccountAuthentication = new AccountAuthentication(getDriver());
    AccountAuthentication.enterEmail(utils.DataLoaderUtil.getProperty("invalidEmail"));
    AccountAuthentication.clickCreateAccButton();
    AccountAuthentication.verifyAccCreationErrorMsgIsDisplayed();
  }

  @Test
  public void createAnAccountValidEmailTest() {
    AccountAuthentication AccountAuthentication = new AccountAuthentication(getDriver());
    AccountAuthentication.enterEmail(utils.DataLoaderUtil.getProperty("validEmail"));
    AccountAuthentication.clickCreateAccButton();
    CreateNewAccount CreateNewAccount = new CreateNewAccount(getDriver());
    CreateNewAccount.verifyAccountCreationFormIsDisplayed();
  }
}
