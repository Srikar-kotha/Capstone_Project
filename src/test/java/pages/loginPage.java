package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

    WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[normalize-space()='Log Out']")
    WebElement logout;

    @FindBy(xpath = "//input[@name='username']")
    WebElement loginUsername;

    @FindBy(xpath = "//input[@name='password']")
    WebElement loginPassword;

    @FindBy(xpath = "//p[@class='error']")
    WebElement loginError;

    @FindBy(xpath = "//p[@class='smallText']")
    WebElement loginConfirm;













}
