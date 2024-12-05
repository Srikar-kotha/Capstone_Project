package pages;

import Utils.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.time.Duration;

public class billPayPage {
    WebDriver driver;
    ExcelUtils excelUtils = new ExcelUtils("billPage");

    public billPayPage(WebDriver driver) throws IOException {
        this.driver=driver;
    }

    public billPayPage() throws IOException {

    }

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

    @FindBy(xpath="//input[@name='amount']")
    WebElement amount;

    @FindBy(xpath="//input[@value='Send Payment']")
    WebElement sendPayment;


    @FindBy(xpath="//h1[@class='title']")
    WebElement billPayResult;

    public void paybill(String nameData,String addressData,String cityData,String stateData,String zipcodeData,String numberData,String accountData,String verifyAccountData)
    {
        billPay.click();
        payeeName.click();
        payeeName.sendKeys(nameData);
        payeeAddress.click();
        payeeAddress.sendKeys(addressData);
        payeeCity.click();
        payeeCity.sendKeys(cityData);
        payeeState.click();
        payeeState.sendKeys(stateData);
        payeeZipCode.click();
        payeeZipCode.sendKeys(zipcodeData);
        payeePhoneNumber.click();
        payeePhoneNumber.sendKeys(numberData);
        payeeAccountNumber.click();
        payeeAccountNumber.sendKeys(accountData);
        verifyAccount.click();
        verifyAccount.sendKeys(verifyAccountData);

    }

    public void sendPaymentMethod()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        amount.click();
        amount.sendKeys("100");
        sendPayment.click();
    }

    public void payBillSuccess()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='title']")));
        Assert.assertTrue(billPayResult.isDisplayed(),"The payment is not done");
    }

    @DataProvider(name="billPayData")
    public Object[][] billPayDataProvider() throws IOException
    {
        int rowCount= excelUtils.getRows();
        int colCount= 8;//excelUtils.getColumns(rowCount);
        Object[][] data =new Object[rowCount-1][colCount];

        for(int i=1;i<rowCount;i++){
            for(int j=0;j<colCount;j++)
            {
                data[i-1][j]=excelUtils.getCellData(i,j);
            }
        }
        return data;
    }

}

