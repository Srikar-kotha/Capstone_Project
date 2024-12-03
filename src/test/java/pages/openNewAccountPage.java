package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class openNewAccountPage {

    @FindBy(xpath = "//a[normalize-space()='Open New Account']")
    WebElement openNewAccount;

    @FindBy(xpath = "//select[@id='type']")
    WebElement accountType;

    @FindBy(xpath = "//select[@id='fromAccountId']")
    WebElement depositFromAccount;

    @FindBy(xpath = "//input[@type='button']")
    WebElement openAccount;

    @FindBy(xpath = "//h1[normalize-space()='Account Opened!']")
    WebElement accountSuccess;

    @FindBy(xpath = "//*[@id='newAccountId']")
    WebElement accountId;
}
