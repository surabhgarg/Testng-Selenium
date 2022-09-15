package createnewaccount;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DataLoaderUtil;
import steps.AccountAuthenticationPageSteps;
import steps.CreateNewAccountPageSteps;
import utils.DriverSetting;

public class AccountAuthenticationTests extends DriverSetting {

  @BeforeMethod
  public void openAuthenticationPage() {
    AccountAuthenticationPageSteps authenticationPageActions = new AccountAuthenticationPageSteps(getDriver());
    authenticationPageActions.openAuthenticationPage();
  }

  @Test
  public void createAnAccountInvalidEmailTest() {
    AccountAuthenticationPageSteps authenticationPageActions = new AccountAuthenticationPageSteps(getDriver());
    authenticationPageActions.enterEmail(DataLoaderUtil.getProperty("invalidEmail"));
    authenticationPageActions.clickCreateAccButton();
    authenticationPageActions.verifyAccCreationErrorMsgIsDisplayed();
  }

  @Test
  public void createAnAccountValidEmailTest() {
    AccountAuthenticationPageSteps authenticationPageActions = new AccountAuthenticationPageSteps(getDriver());
    authenticationPageActions.enterEmail(DataLoaderUtil.getProperty("validEmail"));
    authenticationPageActions.clickCreateAccButton();
    CreateNewAccountPageSteps createAccountPageActions = new CreateNewAccountPageSteps(getDriver());
    createAccountPageActions.verifyAccountCreationFormIsDisplayed();
  }
}
