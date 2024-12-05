package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class findTransactionsPage {

    @FindBy(xpath = "//a[normalize-space()='Find Transactions']")
    WebElement findTransactions;

    @FindBy(xpath = "//*[@id='transactionForm']")
    WebElement transactionResult;

    public void NavigateToFindTransactions()
    {
        findTransactions.click();
        Assert.assertTrue(transactionResult.isDisplayed(),"The transaction page is not displayed");
    }
}
