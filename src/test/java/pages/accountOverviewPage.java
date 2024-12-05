package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.testng.Assert;



public class accountOverviewPage {

    WebDriver driver;

    public accountOverviewPage(WebDriver driver)
    {
        this.driver=driver;
    }

    @FindBy(xpath = "//a[normalize-space()='Accounts Overview']")
    WebElement accountOverview;

    @FindBy(xpath = "//*[@id='accountTable']")
    WebElement accountTable;

    @FindBy(xpath="//h1[normalize-space()='Account Details']")
    WebElement accountDetails;

    @FindBy(xpath = "//*[@id='accountType']")
    WebElement typeofAccount;

    @FindBy(xpath = "//*[@id='balance']")
    WebElement balance;

    @FindBy(xpath = "//table[@id='accountTable']//a[contains(@href, 'activity.htm?id=')]")
    WebElement firstAccount;

    @FindBy(xpath="//h1[normalize-space()='Account Activity']")
    WebElement accountActivity;

    @FindBy(xpath = "//*[@id='transactionTable']")
    WebElement transactionTable;

    @FindBy(xpath = "//table[@id='transactionTable']//a[contains(@href, 'transaction.htm?id=')]")
    WebElement firstTransaction;

    @FindBy(xpath="//h1[normalize-space()='Transaction Details']")
    WebElement transactionDetails;

    public void accountView()
    {
        accountOverview.click();
        Assert.assertTrue(accountTable.isDisplayed(),"The page is not navigated to the account details page");
    }

    public void accountCheck()
    {
        Assert.assertTrue(firstAccount.isDisplayed(),"The first account is not displayed");
        firstAccount.click();
    }

    public void navigateToAccountDetails()
    {
        Assert.assertTrue(accountDetails.isDisplayed(),"The account details are not displayed");
        Assert.assertTrue(balance.isDisplayed(),"The balance is not displayed");
    }

    public void checkAccountType()
    {
        try{
            Assert.assertTrue(typeofAccount.isDisplayed(),"The account type is not displayed");
        }catch (NoSuchElementException e){
            Assert.fail("The AccountType is not available");
        }
    }

    public void displayAccountActivity()
    {
        Assert.assertTrue(accountActivity.isDisplayed(),"The account activity is not displayed");
        Assert.assertTrue(transactionTable.isDisplayed(),"The transactions are not displayed");
    }

    public void displayTransactions()
    {
        Assert.assertTrue(firstTransaction.isDisplayed(),"The first transaction is not displayed");
        firstTransaction.click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='transactionTable']//a[contains(@href, 'transaction.htm?id=')]")));
        Assert.assertTrue(transactionDetails.isDisplayed(),"The transaction details are not displayed");
    }
}
