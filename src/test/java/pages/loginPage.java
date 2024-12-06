package pages;

import Utils.ExcelUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class loginPage extends homePage {

    WebDriver driver;
    ExcelUtils excelUtils = new ExcelUtils("Login");

    public loginPage(WebDriver driver) throws IOException {
        this.driver = driver;
    }

    public loginPage() throws IOException {

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


    public void logout()
    {
        logout.click();
    }

    public void blankLogin()
    {
        loginUsername.click();
        loginUsername.sendKeys("");
        loginPassword.click();
        loginPassword.sendKeys("");
        loginButton.click();
    }

    public void loginErrorMessage()
    {

        try {
            Assert.assertTrue(loginError.isDisplayed(),"The error message is not thrown");

        } catch (NoSuchElementException e)
        {
            Assert.fail("The error message is not thrown");
        }


    }

    public void wrongLoginData()
    {
            loginUsername.click();
            loginUsername.sendKeys("someOne");
            loginPassword.click();
            loginPassword.sendKeys("Srikar@123");
            loginButton.click();
    }

    public void loginData(String usernameData,String passwordData)
    {
        loginUsername.click();
        loginUsername.sendKeys(usernameData);
        loginPassword.click();
        loginPassword.sendKeys(passwordData);
        loginButton.click();
    }

    public void loginSuccess()
    {
        Assert.assertTrue(loginConfirm.isDisplayed(),"The login is not successful");
    }

    @DataProvider(name="loginData")
    public Object[][] loginDataProvider() throws IOException
    {
        int rowCount= excelUtils.getRows();
        int colCount= 2;
        Object[][] data =new Object[rowCount-1][colCount];

        for(int i=1;i<rowCount;i++){
            for(int j=0;j<colCount;j++)
            {
                data[i-1][j]=excelUtils.getCellData(i,j);
            }
        }
        return data;
    }





}
