package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class billPayPage {

    @FindBy(xpath = "//a[normalize-space()='Bill Pay']")
    WebElement billPay;

    @FindBy(name = "payee.name")
    WebElement payeeName;

    @FindBy(name="payee.address.street")
    WebElement payeeAddress;

    @FindBy(name="payee.address.city")
    WebElement payeeCity;

    @FindBy(name="payee.address.state")
    WebElement payeeState;

    @FindBy(name="payee.address.zipCode")
    WebElement payeeZipCode;

    @FindBy(name="payee.phoneNumber")
    WebElement payeePhoneNumber;

    @FindBy(name="payee.accountNumber")
    WebElement payeeAccountNumber;

    @FindBy(name="verifyAccount")
    WebElement verifyAccount;

    @FindBy(name="amount")
    WebElement amount;

    @FindBy(name="//*[@id='billpayForm']/form/table/tbody/tr[14]/td[2]/input")
    WebElement sendPayment;

    @FindBy(id = "billpayResult")
    WebElement billPayResult;

}

