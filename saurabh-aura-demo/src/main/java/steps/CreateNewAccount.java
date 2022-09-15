package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pageObjects.CreateNewAccountPage;
import utils.Helper;

public class CreateNewAccount {

  WebDriver driver;

  public CreateNewAccount(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, CreateNewAccountPage.class);
  }

  public void enterFirstName(String firstName) {
    CreateNewAccountPage.firstName.sendKeys(firstName);
  }

  public void enterLastName(String lastName) {
    CreateNewAccountPage.lastName.sendKeys(lastName);
  }

  public void enterEmail(String email) {
    CreateNewAccountPage.email.sendKeys(email);
  }

  public void enterPassword(String password) {
    CreateNewAccountPage.password.sendKeys(password);
  }

  public void clickRegisterButton() {
    CreateNewAccountPage.registerButton.click();
  }

  public void verifyAccountCreationFormIsDisplayed() {
    boolean isFormDisplayed = new Helper().isElementDisplayed(CreateNewAccountPage.formAccCreation, 30);
    Assert.assertTrue(isFormDisplayed, "Create account form should be displayed.");
  }

  public void verifyPersonalInfoValidationErrorIsDisplayed() {
    boolean isErrorDisplayed = new Helper().isElementDisplayed(CreateNewAccountPage.personalInfoErrorText, 30);
    Assert.assertTrue(isErrorDisplayed, "Personal Info validation error message should be displayed.");
  }

}
