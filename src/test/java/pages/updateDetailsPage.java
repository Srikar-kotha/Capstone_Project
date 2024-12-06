package pages;

import Utils.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.time.Duration;

public class updateDetailsPage {

    WebDriver driver;
    ExcelUtils excelUtils = new ExcelUtils("Update");


    public updateDetailsPage(WebDriver driver) throws IOException {
        this.driver=driver;
    }

    public updateDetailsPage() throws IOException {

    }

    @FindBy(xpath="//a[normalize-space()='Update Contact Info']")
    WebElement updateContactInfo;

    @FindBy(id = "customer.firstName")
    WebElement updateFirstName;

    @FindBy(id = "customer.lastName")
    WebElement updateLastName;

    @FindBy(id = "customer.address.street")
    WebElement updateAddress;

    @FindBy(id = "customer.address.city")
    WebElement updateCity;

    @FindBy(id = "customer.address.state")
    WebElement updateState;

    @FindBy(id = "customer.address.zipCode")
    WebElement updateZipCode;

    @FindBy(id = "customer.phoneNumber")
    WebElement updatePhone;

    @FindBy(xpath = "//input[@value='Update Profile']")
    WebElement updateButton;

    @FindBy(xpath = "//h1[normalize-space()='Profile Updated']")
    WebElement updateProfileResult;

    public void update()
    {
        updateContactInfo.click();
        updateFirstName.click();
        updateFirstName.sendKeys("someName");
        updateLastName.click();
        updateLastName.sendKeys("SomeLastName");
        updateAddress.click();
        updateAddress.sendKeys("someAddress");
        updateCity.click();
        updateCity.sendKeys("SomeoneCity");
        updateState.click();
        updateState.sendKeys("SomeoneState");
        updateZipCode.click();
        updateZipCode.sendKeys("56575");
        updatePhone.click();
        updatePhone.sendKeys("9373849");
        updateButton.click();
    }

    public void updateSuccess()
    {
        updateButton.click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Profile Updated']")));
        Assert.assertTrue(updateProfileResult.isDisplayed(),"The information is not updated");
    }

    @DataProvider(name="updateData")
    public Object[][] updateDataProvider() throws IOException
    {
        int rowCount= excelUtils.getRows();
        int colCount=7;// excelUtils.getColumns(rowCount);
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
