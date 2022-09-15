package createnewaccount;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DataLoaderUtil;
import steps.AccountAuthenticationPageSteps;
import steps.CreateNewAccountPageSteps;
import utils.DriverSetting;

public class CreateAccountTests extends DriverSetting {

  @BeforeMethod
  public void openCreateAccountPage() {
    AccountAuthenticationPageSteps authenticationPageActions = new AccountAuthenticationPageSteps(getDriver());
    authenticationPageActions.openAuthenticationPage();
    authenticationPageActions.enterEmail(RandomStringUtils.randomAlphanumeric(10) + DataLoaderUtil.getProperty("validEmail"));
    authenticationPageActions.clickCreateAccButton();
    CreateNewAccountPageSteps createAccountPageActions = new CreateNewAccountPageSteps(getDriver());
    createAccountPageActions.verifyAccountCreationFormIsDisplayed();
  }

  @Test
  public void invalidPersonalInfoTest() {
    CreateNewAccountPageSteps createAccountPageActions = new CreateNewAccountPageSteps(getDriver());
    createAccountPageActions.clickRegisterButton();
    createAccountPageActions.verifyPersonalInfoValidationErrorIsDisplayed();
  }



}
