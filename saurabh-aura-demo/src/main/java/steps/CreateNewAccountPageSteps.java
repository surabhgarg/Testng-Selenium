package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pageObjects.CreateNewAccountPageObjects;
import utils.SeleniumHelper;

public class CreateNewAccountPageSteps {

  WebDriver driver;

  public CreateNewAccountPageSteps(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, CreateNewAccountPageObjects.class);
  }

  public void enterFirstName(String firstName) {
    CreateNewAccountPageObjects.firstName.sendKeys(firstName);
  }

  public void enterLastName(String lastName) {
    CreateNewAccountPageObjects.lastName.sendKeys(lastName);
  }

  public void enterEmail(String email) {
    CreateNewAccountPageObjects.email.sendKeys(email);
  }

  public void enterPassword(String password) {
    CreateNewAccountPageObjects.password.sendKeys(password);
  }

  public void enterAddress(String address) {
    CreateNewAccountPageObjects.address.sendKeys(address);
  }

  public void enterCity(String city) {
    CreateNewAccountPageObjects.city.sendKeys(city);
  }

  public void selectState(String state) {
    CreateNewAccountPageObjects.stateDD.click();
    CreateNewAccountPageObjects.locateStateDD(driver, state).click();
  }

  public void enterZipCode(String zipCode) {
    CreateNewAccountPageObjects.zipCode.sendKeys(zipCode);
  }

  public void selectCountry(String country) {
    CreateNewAccountPageObjects.countryDD.click();
    CreateNewAccountPageObjects.locateCountryDD(driver, country).click();
  }

  public void enterHomePhone(String phone) {
    CreateNewAccountPageObjects.homePhone.sendKeys(phone);
  }

  public void clickRegisterButton() {
    CreateNewAccountPageObjects.registerButton.click();
  }

  public void verifyAccountCreationFormIsDisplayed() {
    boolean isFormDisplayed = new SeleniumHelper().isElementDisplayed(CreateNewAccountPageObjects.formAccCreation, 30);
    Assert.assertTrue(isFormDisplayed, "Create account form should be displayed.");
  }

  public void verifyPersonalInfoValidationErrorIsDisplayed() {
    boolean isErrorDisplayed = new SeleniumHelper().isElementDisplayed(CreateNewAccountPageObjects.personalInfoErrorText, 30);
    Assert.assertTrue(isErrorDisplayed, "Personal Info validation error message should be displayed.");
  }

  public void verifyMyAccountPageIsDisplayed() {
    boolean isPageDisplayed = new SeleniumHelper().isElementDisplayed(CreateNewAccountPageObjects.myAccountPage, 30);
    Assert.assertTrue(isPageDisplayed, "My account page should be displayed.");
  }

}
