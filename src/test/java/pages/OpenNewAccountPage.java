package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OpenNewAccountPage {

    WebDriver driver;

    public OpenNewAccountPage(WebDriver driver) {
        this.driver = driver;
    }

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

    @FindBy(xpath = "//a[@id='newAccountId']")
    WebElement accountId;

    public void openNewAccount()
    {
        openNewAccount.click();
    }

    public void checkAccountType()
    {
        Select type = new Select(accountType);

        List<WebElement> options = type.getOptions();

        List<String> actualAccountTypes=new ArrayList<String>();

        for(WebElement option:options)
        {
            actualAccountTypes.add(option.getText());
        }

        List<String> expectedAccountTypes=List.of("CHECKING","SAVINGS","SALARY");

        for(String x:expectedAccountTypes)
        {
            try {

                Assert.assertTrue(actualAccountTypes.contains(x), "The option is not found");

            }catch(NoSuchElementException e) {

                Assert.fail("The account type is not available");
            }
        }
    }

    public void createAccount()
    {
        Select type = new Select(accountType);
        Select fromAccount=new Select(depositFromAccount);
        type.selectByVisibleText("CHECKING");
        fromAccount.selectByIndex(0);
        openAccount.click();
    }

    public void accountSuccess()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Account Opened!']")));

        Assert.assertTrue(accountSuccess.isDisplayed(),"The account is not opened");
        Assert.assertTrue(accountId.isDisplayed(),"The new accountId is not generated");
    }
}
