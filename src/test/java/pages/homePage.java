package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class homePage {

    @FindBy(xpath = "//img[@title='ParaBank']")
    WebElement welcome;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement RegisterButton;

    @FindBy(xpath = "//*[@id='loginPanel']/form/div[3]/input")
    WebElement loginButton;

    @FindBy(xpath = "//a[normalize-space()='home']")
    WebElement home;

    @FindBy(xpath = "//a[normalize-space()='about']")
    WebElement about;

    @FindBy(xpath = "//a[normalize-space()='contact']")
    WebElement contact;

    public void welcomeMessage()
    {
        Assert.assertTrue(welcome.isDisplayed(),"The welcome message is not displayed");
    }

    public void registerIsVisible()
    {
        Assert.assertTrue(RegisterButton.isDisplayed(),"The Register button is not displayed");
        RegisterButton.click();
    }

    public void loginIsVisible()
    {
        Assert.assertTrue(loginButton.isDisplayed(),"The login button is not displayed");

    }
}
