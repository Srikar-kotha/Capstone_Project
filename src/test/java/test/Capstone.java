package test;

import Utils.ExtentManager;
import base.Baseclass;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class Capstone extends Baseclass implements ITestListener {


    public Capstone() throws IOException {
    }

    @BeforeMethod
    public void startTest(Method method) throws IOException {
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
        homePage homePage = PageFactory.initElements(driver, homePage.class);
        test.log(Status.INFO,"Checking the visibility of WebElements");
        homePage.welcomeMessage();
        test.log(Status.PASS,"The welcome message is displayed");
        homePage.loginIsVisible();
        test.log(Status.PASS,"The login button is displayed");
        homePage.registerIsVisible();
        test.log(Status.PASS,"The register button is displayed");
    }

    @Test(priority = 2)
    public void registerPage() throws InterruptedException {
        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        registerPage.registerPageNav();
        test.log(Status.PASS,"The page is navigated to register page");
        registerPage.registerData(); //Enter the blank details
        registerPage.registerError();
        test.log(Status.PASS,"The error messages are displayed");
    }

    @Test(priority = 3,dataProvider = "registerData",dataProviderClass = RegisterPage.class)
    public void Register(String firstnameData,String lastnameData,String addressData, String cityData, String stateData, String zipcodeData, String numberData, String ssnData, String usernameData, String passwordData, String confirmPasswordData)//String firstnameData,String lastnameData,String addressData, String cityData, String stateData, String zipcodeData, String numberData, String ssnData, String usernameData, String passwordData, String confirmPasswordData
    {
//        System.out.println(first+last);
        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        registerPage.registerDataReal(firstnameData, lastnameData, addressData, cityData, stateData, zipcodeData, numberData, ssnData, usernameData, passwordData, confirmPasswordData);//firstnameData, lastnameData, addressData, cityData, stateData, zipcodeData, numberData, ssnData, usernameData, passwordData, confirmPasswordData
        test.log(Status.PASS,"The registration is done");
    }



    @Test(priority = 4)
    public void registrationSuccess()
    {
        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        registerPage.registerSuccessMessage();
        test.log(Status.PASS,"The registration success message is shown");
    }



    @Test(priority = 5)
    public void logout()
    {
        loginPage loginPage = PageFactory.initElements(driver, loginPage.class);
        loginPage.logout();
        test.log(Status.PASS,"The account is logged out");
        homePage homePage = PageFactory.initElements(driver, homePage.class);
        homePage.loginIsVisible();
        test.log(Status.PASS,"The logout is successful and the page navigated to login page");
    }

    @Test(priority = 6)
    public void blankLogin()
    {
        loginPage loginPage = PageFactory.initElements(driver, loginPage.class);
        loginPage.blankLogin();
        loginPage.loginErrorMessage();
        test.log(Status.PASS,"The login error message is thrown");
    }

    @Test(priority = 7)
    public void wrongLoginData()
    {
        loginPage loginPage = PageFactory.initElements(driver, loginPage.class);
        loginPage.wrongLoginData();
        loginPage.loginErrorMessage();
        test.log(Status.PASS,"The login error message is thrown");

    }

    @Test(priority = 8,dataProvider = "loginData", dataProviderClass = loginPage.class)
    public void loginData(String usernameData,String passwordData)
    {
        loginPage loginPage = PageFactory.initElements(driver, loginPage.class);
        loginPage.loginData(usernameData,passwordData);
        test.log(Status.PASS,"The login does not show any error");

    }

    @Test(priority = 9)
    public void loginSuccess()
    {
        loginPage loginPage = PageFactory.initElements(driver, loginPage.class);
        loginPage.loginSuccess();
        test.log(Status.PASS,"The login is done successfully");
    }

    @Test(priority = 10)
    public void openNewAccount()
    {
        OpenNewAccountPage openNewAccountPage  = PageFactory.initElements(driver, OpenNewAccountPage.class);
        openNewAccountPage.openNewAccount();
        test.log(Status.PASS,"The page is navigated to open new account page");
    }

    @Test(priority = 11)
    public void checkAccountType()
    {
        OpenNewAccountPage openNewAccountPage  = PageFactory.initElements(driver, OpenNewAccountPage.class);
        openNewAccountPage.checkAccountType();
        test.log(Status.PASS,"The Options are displayed");
    }

    @Test(priority = 12)
    public void createAccount()
    {
        OpenNewAccountPage openNewAccountPage  = PageFactory.initElements(driver, OpenNewAccountPage.class);
        openNewAccountPage.createAccount();
        test.log(Status.PASS,"The account details are correct");
    }

    @Test(priority = 13)
    public void accountSuccess()
    {
        OpenNewAccountPage openNewAccountPage  = PageFactory.initElements(driver, OpenNewAccountPage.class);
        openNewAccountPage.accountSuccess();
        test.log(Status.PASS,"The account is opened and new accountId is generated");
    }

    @Test(priority = 14)
    public void accountView()
    {
        accountOverviewPage accountOverviewPage = PageFactory.initElements(driver,pages.accountOverviewPage.class);
        accountOverviewPage.accountView();
        test.log(Status.PASS,"The page is navigated to the account overView page");
    }

    @Test(priority = 15)
    public void checkAccountDetailsAccountType()
    {
        accountOverviewPage accountOverviewPage = PageFactory.initElements(driver,pages.accountOverviewPage.class);
        accountOverviewPage.checkAccountType();
        test.log(Status.PASS,"The accounts are checked");
    }

    @Test(priority = 16)
    public void accountCheck()
    {
        accountOverviewPage accountOverviewPage = PageFactory.initElements(driver,pages.accountOverviewPage.class);
        accountOverviewPage.accountCheck();
        test.log(Status.PASS,"The page is navigated to account details and is displaying the balance");
    }

    @Test(priority = 17)
    public void navigateToAccountDetails()
    {
        accountOverviewPage accountOverviewPage = PageFactory.initElements(driver,pages.accountOverviewPage.class);
        accountOverviewPage.navigateToAccountDetails();
        test.log(Status.PASS,"The account type is displayed");
    }

    @Test(priority = 18)
    public void displayAccountActivity()
    {
        accountOverviewPage accountOverviewPage = PageFactory.initElements(driver,pages.accountOverviewPage.class);
        accountOverviewPage.displayAccountActivity();
        test.log(Status.PASS,"The account activity is displayed and transactions are displayed");
    }

    @Test(priority = 19)
    public void displayTransactions()
    {
        accountOverviewPage accountOverviewPage = PageFactory.initElements(driver,pages.accountOverviewPage.class);
        accountOverviewPage.displayTransactions();
        test.log(Status.PASS,"The transaction details are displayed");
    }

    @Test(priority = 20)
    public void transferType()
    {
        transferFundsPage transferFundsPage = PageFactory.initElements(driver,pages.transferFundsPage.class);
        transferFundsPage.transferType();
        test.log(Status.PASS,"The transfer type is available");
    }

    @Test(priority = 21)
    public void transfer()
    {
        transferFundsPage transferFundsPage = PageFactory.initElements(driver,pages.transferFundsPage.class);
        transferFundsPage.transfer();
        test.log(Status.PASS,"The transfer details are validated");
    }

    @Test(priority = 22)
    public void transferSuccess()
    {
        transferFundsPage transferFundsPage = PageFactory.initElements(driver,pages.transferFundsPage.class);
        transferFundsPage.transferSuccess();
        test.log(Status.PASS,"The transfer message is displayed");
    }

    @Test(priority = 23,dataProvider = "billPayData" , dataProviderClass = billPayPage.class)
    public void paybill(String nameData,String addressData,String cityData,String stateData,String zipcodeData,String numberData,String accountData,String verifyAccountData)
    {
        billPayPage billPayPage = PageFactory.initElements(driver,pages.billPayPage.class);
        billPayPage.payBill(nameData,addressData,cityData,stateData,zipcodeData,numberData,accountData,verifyAccountData);
        test.log(Status.PASS,"The payee information is entered");
    }

    @Test(priority = 24)
    public void sendPaymentMethod()
    {
        billPayPage billPayPage = PageFactory.initElements(driver,pages.billPayPage.class);
        billPayPage.sendPaymentMethod();
        test.log(Status.PASS,"The amount and the from account are given");

    }

    @Test(priority = 25)
    public void payBillSuccess()
    {
        billPayPage billPayPage = PageFactory.initElements(driver,pages.billPayPage.class);
        billPayPage.payBillSuccess();
        test.log(Status.PASS,"The payment is done successfully");
    }

    @Test(priority = 26)
    public void NavigateToFindTransactions()
    {
        findTransactionsPage findTransactionsPage = PageFactory.initElements(driver,pages.findTransactionsPage.class);
        findTransactionsPage.NavigateToFindTransactions();
        test.log(Status.PASS,"The page is navigated to findTransactions page");
    }

    @Test(priority = 27)
    public void update()
    {
        updateDetailsPage updateDetailsPage = PageFactory.initElements(driver,pages.updateDetailsPage.class);
        updateDetailsPage.update();
        test.log(Status.PASS,"The update details are filled successfully");
    }

    @Test(priority = 28)
    public void updateSuccess()
    {
        updateDetailsPage updateDetailsPage = PageFactory.initElements(driver,pages.updateDetailsPage.class);
        updateDetailsPage.updateSuccess();
        test.log(Status.PASS,"The details are updated successfully");
    }

    @Test(priority = 29)
    public void loan()
    {
        requestLoanPage requestLoanPage = PageFactory.initElements(driver,pages.requestLoanPage.class);
        requestLoanPage.loanRequest();
        test.log(Status.PASS,"The loan details are filled");
    }

    @Test(priority = 30)
    public void loanUpdate()
    {
        requestLoanPage requestLoanPage = PageFactory.initElements(driver,pages.requestLoanPage.class);
        requestLoanPage.loanUpdate();
        test.log(Status.PASS,"The loan update details are displayed");
    }

    @Test(priority = 31)
    public void Status()
    {
        requestLoanPage requestLoanPage = PageFactory.initElements(driver,pages.requestLoanPage.class);
        requestLoanPage.Status();
        test.log(Status.PASS,"The loan status is updated");
    }

    @Test(priority = 32)
    public void homeButton()
    {
        homePage homePage = PageFactory.initElements(driver, homePage.class);
        homePage.homeButton();
        test.log(Status.PASS,"The home page is displayed");
    }

    @Test(priority = 33)
    public void aboutButton()
    {
        homePage homePage = PageFactory.initElements(driver, homePage.class);
        homePage.aboutButton();
        test.log(Status.PASS,"The about page is displayed");
    }

    @Test(priority = 34)
    public void contactButton()
    {
        homePage homePage = PageFactory.initElements(driver, homePage.class);
        homePage.contactButton();
        test.log(Status.PASS,"The contact page is displayed");
    }

    @AfterMethod
    public void endTest(ITestResult result,Method method)
    {
        if(result.getStatus()==ITestResult.FAILURE) {
            ExtentManager ScreenshotUtil = new ExtentManager();
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, method.getName());
            String failureMessage = result.getThrowable() != null ? result.getThrowable().getMessage() : "Test Failed without specific exception.";
            test.log(Status.FAIL, "Test Failed :" + failureMessage + test.addScreenCaptureFromPath(screenshotPath));
            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build();
        }
        else if(result.getStatus()==ITestResult.SUCCESS)
            test.log(Status.PASS,"The test is passed");
        else
            test.log(Status.SKIP,"The test is skipped");
    }

}
