package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class accountOverviewPage {

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

    @FindBy(xpath="//h1[normalize-space()='Account Activity']")
    WebElement accountActivity;

    @FindBy(xpath = "//*[@id='transactionTable']")
    WebElement transactionTable;

    @FindBy(xpath="//h1[normalize-space()='Transaction Details']")
    WebElement transactionDetails;
}
