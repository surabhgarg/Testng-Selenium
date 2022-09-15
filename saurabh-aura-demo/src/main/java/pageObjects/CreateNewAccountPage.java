package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateNewAccountPage {

  @FindBy(how = How.ID, using = "account-creation_form")
  public static WebElement formAccCreation;

  @FindBy(how = How.XPATH, using = "//form[@id='account-creation_form']//preceding-sibling::div[contains(@class,'alert-danger')]")
  public static WebElement personalInfoErrorText;

  @FindBy(how = How.ID, using = "submitAccount")
  public static WebElement registerButton;

  @FindBy(how = How.ID, using = "customer_firstname")
  public static WebElement firstName;

  @FindBy(how = How.ID, using = "customer_lastname")
  public static WebElement lastName;

  @FindBy(how = How.ID, using = "email")
  public static WebElement email;

  @FindBy(how = How.ID, using = "passwd")
  public static WebElement password;

  @FindBy(how = How.ID, using = "address1")
  public static WebElement address;

  @FindBy(how = How.ID, using = "city")
  public static WebElement city;

  @FindBy(how = How.ID, using = "id_state")
  public static WebElement stateDD;

  public static WebElement locateStateDD(WebDriver driver, String option) {
    return driver.findElement(By.xpath("//select[@id='id_state']/option[text()='" + option + "']"));
  }

  @FindBy(how = How.ID, using = "postcode")
  public static WebElement zipCode;

  @FindBy(how = How.ID, using = "id_country")
  public static WebElement countryDD;

  public static WebElement locateCountryDD(WebDriver driver, String option) {
    return driver.findElement(By.xpath("//select[@id='id_country']/option[text()='" + option + "']"));
  }

  @FindBy(how = How.ID, using = "phone")
  public static WebElement homePhone;

  @FindBy(how = How.ID, using = "my-account")
  public static WebElement myAccountPage;
}
