package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class transferFundsPage {

    @FindBy(xpath="//a[normalize-space()='Transfer Funds']")
    WebElement transferFunds;

    @FindBy(id="amount")
    WebElement amount;

    @FindBy(id="fromAccountId" )
    WebElement fromAccount;

    @FindBy(id="toAccountId")
    WebElement toAccount;

    @FindBy(xpath = "//*[@id='transferForm']/div[2]/input")
    WebElement transfer;

    @FindBy(id="showResult")
    WebElement transferComplete;
}
