package createaccount;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.AccountAuthenticationPageSteps;
import steps.CreateNewAccountPageSteps;
import utils.DriverSetup;
import utils.TestDataLoader;

public class CreateNewAccountPageTests extends DriverSetup {

  @BeforeMethod
  public void openCreateAccountPage() {
    AccountAuthenticationPageSteps authenticationPageActions = new AccountAuthenticationPageSteps(getDriver());
    authenticationPageActions.openAuthenticationPage();
    authenticationPageActions.enterEmail(RandomStringUtils.randomAlphanumeric(10) + TestDataLoader.getProperty("validEmail"));
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

  @Test
  public void validPersonalInfoTest() {
    CreateNewAccountPageSteps createAccountPageActions = new CreateNewAccountPageSteps(getDriver());
    createAccountPageActions.enterFirstName(TestDataLoader.getProperty("firstname"));
    createAccountPageActions.enterLastName(TestDataLoader.getProperty("lastname"));
    createAccountPageActions.enterPassword(TestDataLoader.getProperty("password"));
    createAccountPageActions.enterAddress(TestDataLoader.getProperty("address"));
    createAccountPageActions.enterCity(TestDataLoader.getProperty("city"));
    createAccountPageActions.selectState(TestDataLoader.getProperty("state"));
    createAccountPageActions.enterZipCode(TestDataLoader.getProperty("zip"));
    createAccountPageActions.selectCountry(TestDataLoader.getProperty("country"));
    createAccountPageActions.enterHomePhone(TestDataLoader.getProperty("phone"));
    createAccountPageActions.clickRegisterButton();
    createAccountPageActions.verifyMyAccountPageIsDisplayed();
  }

}
