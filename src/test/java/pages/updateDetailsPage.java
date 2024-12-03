package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class updateDetailsPage {

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

    @FindBy(xpath = "//*[@id='updateProfileForm']/form/table/tbody/tr[8]/td[2]/input")
    WebElement update;

    @FindBy(id = "updateProfileResult")
    WebElement updateProfileResult;
}
