package createnewaccount;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.AccountAuthentication;
import steps.CreateNewAccount;
import utils.DriverSetting;

public class CreateAccountTests extends DriverSetting {

  @BeforeMethod
  public void openCreateAccountPage() {
    AccountAuthentication AccountAuthentication = new AccountAuthentication(getDriver());
    AccountAuthentication.openAuthenticationPage();
    AccountAuthentication.enterEmail(RandomStringUtils.randomAlphanumeric(10) + utils.DataLoaderUtil.getProperty("validEmail"));
    AccountAuthentication.clickCreateAccButton();
    CreateNewAccount CreateNewAccount = new CreateNewAccount(getDriver());
    CreateNewAccount.verifyAccountCreationFormIsDisplayed();
  }

  @Test
  public void invalidPersonalInfoTest() {
    CreateNewAccount CreateNewAccount = new CreateNewAccount(getDriver());
    CreateNewAccount.clickRegisterButton();
    CreateNewAccount.verifyPersonalInfoValidationErrorIsDisplayed();
  }



}
