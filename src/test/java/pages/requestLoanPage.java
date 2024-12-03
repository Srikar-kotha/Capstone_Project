package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class requestLoanPage {

    @FindBy(xpath="//a[normalize-space()='Request Loan']")
    WebElement requestLoan;

    @FindBy(id = "amount")
    WebElement loanAmount;

    @FindBy(id = "downPayment")
    WebElement downPayment;

    @FindBy(id= "fromAccountId ")
    WebElement fromAccountIdLoan;

    @FindBy(xpath = "//*[@id='requestLoanForm']/form/table/tbody/tr[4]/td[2]/input")
    WebElement request;

    @FindBy(id= "requestLoanResult")
    WebElement requestLoanResult;

    @FindBy(id = "newAccountId")
    WebElement newAccountId;

    @FindBy(id = "loanStatus")
    WebElement loanStatus;

}

