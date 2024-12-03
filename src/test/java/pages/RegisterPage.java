package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//h1[normalize-space()='Signing up is easy!']")
    WebElement registerPage;

    @FindBy(id = "customer.firstName")
    WebElement firstname;

    @FindBy(id = "customer.firstName.errors")
    WebElement firstnameError;

    @FindBy(id = "customer.lastName")
    WebElement lastname;

    @FindBy(id = "customer.lastName.errors")
    WebElement lastnameError;

    @FindBy(id = "customer.address.street")
    WebElement address;

    @FindBy(id = "customer.address.street.errors")
    WebElement addressError;

    @FindBy(id = "customer.address.city")
    WebElement city;

    @FindBy(id = "customer.address.city.errors")
    WebElement cityError;

    @FindBy(id = "customer.address.state")
    WebElement state;

    @FindBy(id = "customer.address.state.errors")
    WebElement stateError;

    @FindBy(id = "customer.address.zipCode")
    WebElement zipcode;

    @FindBy(id = "customer.address.zipCode.errors")
    WebElement zipcodeError;

    @FindBy(id = "customer.phoneNumber")
    WebElement number;

    @FindBy(id = "customer.phoneNumber.errors")
    WebElement numberError;

    @FindBy(id = "customer.ssn")
    WebElement ssn;

    @FindBy(id = "customer.ssn.errors")
    WebElement ssnError;

    @FindBy(id = "customer.username")
    WebElement username;

    @FindBy(id = "customer.username.errors")
    WebElement usernameError;

    @FindBy(id = "customer.password")
    WebElement password;

    @FindBy(id = "customer.password.errors")
    WebElement passwordError;

    @FindBy(id = "repeatedPassword")
    WebElement confirmPassword;

    @FindBy(id = "repeatedPassword.errors")
    WebElement confirmPasswordError;

    @FindBy(xpath = "//input[@value='Register']")
    WebElement register;

    @FindBy(xpath = "//h1[normalize-space()='Welcome bunny']")
    WebElement registerSuccess;

    public void registerPage()
    {
        try {
            Assert.assertTrue(registerPage.isDisplayed(),"The Register page is not displayed");
        }
        catch(NoSuchElementException e)
        {
            Assert.fail("The element is not located : ");
        }
    }

    public void registerData()
    {
        firstname.click();
        firstname.sendKeys("");
        lastname.click();
        lastname.sendKeys("");
        address.click();
        address.sendKeys("");
        city.click();
        city.sendKeys("");
        state.click();
        state.sendKeys("");
        zipcode.click();
        zipcode.sendKeys("");
        number.click();
        number.sendKeys("");
        ssn.click();
        ssn.sendKeys("");
        username.click();
        username.sendKeys("");
        password.click();
        password.sendKeys("");
        confirmPassword.click();
        confirmPassword.sendKeys("");
    }

    public void registerError()
    {
        register.click();
        Assert.assertTrue(firstnameError.isDisplayed(),"The error is not displayed");
        Assert.assertTrue(lastnameError.isDisplayed(),"The error is not displayed");
        Assert.assertTrue(addressError.isDisplayed(),"The error is not displayed");
        Assert.assertTrue(cityError.isDisplayed(),"The error is not displayed");
        Assert.assertTrue(stateError.isDisplayed(),"The error is not displayed");
        Assert.assertTrue(zipcodeError.isDisplayed(),"The error is not displayed");
//        try {
//            Assert.assertTrue(numberError.isDisplayed(),"The error is not displayed");        }
//        catch(NoSuchElementException e)
//        {
//            Assert.fail("The element is not located : ");
//        }
        Assert.assertTrue(ssnError.isDisplayed(),"The error is not displayed");
        Assert.assertTrue(usernameError.isDisplayed(),"The error is not displayed");
        Assert.assertTrue(passwordError.isDisplayed(),"The error is not displayed");
        Assert.assertTrue(confirmPasswordError.isDisplayed(),"The error is not displayed");
    }
}
