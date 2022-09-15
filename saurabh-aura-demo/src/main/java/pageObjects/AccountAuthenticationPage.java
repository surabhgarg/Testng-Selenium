package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountAuthenticationPage {

  @FindBy(how = How.ID, using = "email_create")
  public static WebElement emailAddress;

  @FindBy(how = How.ID, using = "SubmitCreate")
  public static WebElement createAccButton;

  @FindBy(how = How.ID, using = "create_account_error")
  public static WebElement createAccountError;
}
