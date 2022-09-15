package createaccount;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.AccountAuthenticationPageSteps;
import steps.CreateNewAccountPageSteps;
import utils.DriverSetup;
import utils.TestDataLoader;

public class AccountAuthenticationPageTests extends DriverSetup {

  @BeforeMethod
  public void openAuthenticationPage() {
    AccountAuthenticationPageSteps authenticationPageActions = new AccountAuthenticationPageSteps(getDriver());
    authenticationPageActions.openAuthenticationPage();
  }

  @Test
  public void createAnAccountBlankEmailTest() {
    AccountAuthenticationPageSteps authenticationPageActions = new AccountAuthenticationPageSteps(getDriver());
    authenticationPageActions.clickCreateAccButton();
    authenticationPageActions.verifyAccCreationErrorMsgIsDisplayed();
  }

  @Test
  public void createAnAccountInvalidEmailTest() {
    AccountAuthenticationPageSteps authenticationPageActions = new AccountAuthenticationPageSteps(getDriver());
    authenticationPageActions.enterEmail(TestDataLoader.getProperty("invalidEmail"));
    authenticationPageActions.clickCreateAccButton();
    authenticationPageActions.verifyAccCreationErrorMsgIsDisplayed();
  }

  @Test
  public void createAnAccountExistingEmailTest() {
    AccountAuthenticationPageSteps authenticationPageActions = new AccountAuthenticationPageSteps(getDriver());
    authenticationPageActions.enterEmail(TestDataLoader.getProperty("existingEmail"));
    authenticationPageActions.clickCreateAccButton();
    authenticationPageActions.verifyAccCreationErrorMsgIsDisplayed();
  }

  @Test
  public void createAnAccountValidEmailTest() {
    AccountAuthenticationPageSteps authenticationPageActions = new AccountAuthenticationPageSteps(getDriver());
    authenticationPageActions.enterEmail(TestDataLoader.getProperty("validEmail"));
    authenticationPageActions.clickCreateAccButton();
    CreateNewAccountPageSteps createAccountPageActions = new CreateNewAccountPageSteps(getDriver());
    createAccountPageActions.verifyAccountCreationFormIsDisplayed();
  }
}
