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

public class transferFundsPage {

    WebDriver driver;

    public transferFundsPage(WebDriver driver) {
        this.driver=driver;
    }

    @FindBy(xpath="//a[normalize-space()='Transfer Funds']")
    WebElement transferFunds;

    @FindBy(id="amount")
    WebElement amount;

    @FindBy(id="fromAccountId" )
    WebElement fromAccount;

    @FindBy(id="transferType")
    WebElement typeOfTransfer;

    @FindBy(id="toAccountId")
    WebElement toAccount;

    @FindBy(xpath = "//input[@value='Transfer']")
    WebElement transfer;

    @FindBy(xpath="//h1[normalize-space()='Transfer Complete!']")
    WebElement transferComplete;

    public void transfer()
    {
        transferFunds.click();
        amount.click();
        amount.sendKeys("100");
        Select from = new Select(fromAccount);
        from.selectByIndex(0);
        Select to = new Select(toAccount);
        to.selectByIndex(1);
        transfer.click();
    }

    public void transferType()
    {
        transferFunds.click();
        try{
            Assert.assertTrue(typeOfTransfer.isDisplayed(),"The type of transfer is not available");
        }catch (NoSuchElementException e){
            Assert.fail("The transferType is not available");
        }
    }

    public void transferSuccess()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Transfer Complete!']")));
        Assert.assertTrue(transferComplete.isDisplayed(),"The transfer is not completed");
    }
}
