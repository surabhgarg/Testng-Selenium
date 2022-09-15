package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pageObjects.CreateNewAccountPage;
import utils.Helper;

public class CreateNewAccountPageSteps {

  WebDriver driver;

  public CreateNewAccountPageSteps(WebDriver driver) {
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

  public void enterAddress(String address) {
    CreateNewAccountPage.address.sendKeys(address);
  }

  public void enterCity(String city) {
    CreateNewAccountPage.city.sendKeys(city);
  }

  public void selectState(String state) {
    CreateNewAccountPage.stateDD.click();
    CreateNewAccountPage.locateStateDD(driver, state).click();
  }

  public void enterZipCode(String zipCode) {
    CreateNewAccountPage.zipCode.sendKeys(zipCode);
  }

  public void selectCountry(String country) {
    CreateNewAccountPage.countryDD.click();
    CreateNewAccountPage.locateCountryDD(driver, country).click();
  }

  public void enterHomePhone(String phone) {
    CreateNewAccountPage.homePhone.sendKeys(phone);
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

  public void verifyMyAccountPageIsDisplayed() {
    boolean isPageDisplayed = new Helper().isElementDisplayed(CreateNewAccountPage.myAccountPage, 30);
    Assert.assertTrue(isPageDisplayed, "My account page should be displayed.");
  }

}
