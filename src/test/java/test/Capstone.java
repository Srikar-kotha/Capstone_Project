package test;

import base.Baseclass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;

import java.lang.reflect.Method;

public class Capstone extends Baseclass {

    @BeforeMethod
    public void startTest(Method method)
    {
        createTest(method.getName(), "Test case : "+method.getName());
    }

    @Test(priority = 0)
    public void verifyTitle()
    {
        test.log(Status.INFO,"Verifying the Title");
        String expectedTitle ="ParaBank | Welcome | Online Banking";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"The title is not matched");
        test.log(Status.PASS,"The title is matched");
    }

    @Test(priority = 1)
    public void welcomeMessage()
    {
        test.log(Status.INFO,"Checking the visibility of WebElements");
        homePage obj = PageFactory.initElements(driver, homePage.class);
        obj.welcomeMessage();
        test.log(Status.PASS,"The welcome message is displayed");
        obj.loginIsVisible();
        test.log(Status.PASS,"The login button is displayed");
        obj.registerIsVisible();
        test.log(Status.PASS,"The register button is displayed");


    }

    @Test(priority = 2)
    public void registerPage()
    {
        RegisterPage obj = PageFactory.initElements(driver, RegisterPage.class);
        obj.registerPage();
        test.log(Status.PASS,"The page is navigated to register page");
        obj.registerData(); //Enter the blank details
        obj.registerError();
        test.log(Status.PASS,"The error messages are displayed");
    }


    @AfterMethod
    public void endTest(ITestResult result)
    {
        if(result.getStatus()==ITestResult.FAILURE) {
            String failureMessage = result.getThrowable() != null ? result.getThrowable().getMessage() : "Test Failed without specific exception.";
            test.log(Status.FAIL, "Test Failed :" + failureMessage);
        }
        else if(result.getStatus()==ITestResult.SUCCESS)
            test.log(Status.PASS,"The test is passed");
        else
            test.log(Status.SKIP,"The test is skipped");
    }

}
