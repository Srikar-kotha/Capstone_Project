package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class findTransactionsPage {

    @FindBy(xpath = "//a[normalize-space()='Find Transactions']")
    WebElement findTransactions;

    @FindBy(xpath = "//*[@id='transactionForm']")
    WebElement transactionResult;
}
