package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class requestLoanPage {

    WebDriver driver;

    public requestLoanPage(WebDriver driver)
    {
        this.driver=driver;
    }

    @FindBy(xpath="//a[normalize-space()='Request Loan']")
    WebElement requestLoan;

    @FindBy(id = "amount")
    WebElement loanAmount;

    @FindBy(id = "downPayment")
    WebElement downPayment;

    @FindBy(xpath= "//select[@id='fromAccountId']")
    WebElement fromAccountIdLoan;

    @FindBy(xpath = "//input[@value='Apply Now']")
    WebElement apply;

    @FindBy(xpath= "//h1[normalize-space()='Loan Request Processed']")
    WebElement requestLoanResult;

    @FindBy(id = "newAccountId")
    WebElement newAccountId;

    @FindBy(id = "loanStatus")
    WebElement loanStatus;

    public void loanRequest()
    {
        requestLoan.click();
        loanAmount.click();
        loanAmount.sendKeys("100");
        downPayment.click();
        downPayment.sendKeys("50");
        Select from = new Select(fromAccountIdLoan);
        from.selectByIndex(0);
        apply.click();
    }

    public void loanUpdate()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Loan Request Processed']")));
        Assert.assertTrue(requestLoanResult.isDisplayed(),"The loan update is not displayed");
    }

    public void Status()
    {
        String status = loanStatus.getText();
        if(status.equals("Approved"))
        {
            System.out.println("The loan is available");
            Assert.assertTrue(newAccountId.isDisplayed(),"The new accountId is not generated");
        }
        else {
            System.out.println("The loan is not available");
        }
    }
}

