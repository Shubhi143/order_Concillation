package ElevateNow.Order.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {

    
    String url = "https://preweb.joinelevatenow.co.in/patient";
   WebDriver driver;
   String userName = "Shubhi Testing";
   String mobileNumber = "9955663688";
   String emailAddress = "testcheckuser@gmail.com";
// WebElements
@FindBy(xpath = "//div[text()='Add Patient']")
private WebElement addPatientButton;

public void clickAddPatient() {
    addPatientButton.click();
}

@FindBy(xpath = "//div[text()='Save Details']")
private WebElement saveDetailsButton;


@FindBy(xpath = "//input[@placeholder='Full Name']")
private WebElement userNameField;

@FindBy(xpath = "//input[@placeholder='10 Digit Mobile Number']")
private WebElement mobileNumberField;

@FindBy(xpath = "//input[@placeholder='Email Address']")
private WebElement emailAddressField;

@FindBy(xpath = "//*[@placeholder='Search a patient by name or mobile number']")
private WebElement searchPatientField;

public void enterSearchPatient(String userName) throws InterruptedException {
    searchPatientField.clear();
    searchPatientField.sendKeys(userName);
    Thread.sleep(5000);
    driver.findElement(By.xpath("//*[@id='Patients-item-0']")).click();
    Thread.sleep(5000);
}

public Home(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    driver.get(url);
    driver.manage().window().maximize();
}
// Methods to interact with the WebElements
public void enterUserName(String userName) {
    userNameField.clear();
    userNameField.sendKeys(userName);
}

public void enterMobileNumber(String mobileNumber) {
    mobileNumberField.clear();
    mobileNumberField.sendKeys(mobileNumber);
}

public void enterEmailAddress(String emailAddress) {
    emailAddressField.clear();
    emailAddressField.sendKeys(emailAddress);
}
public void clickSave() throws InterruptedException {
    // TODO Auto-generated method stub
    saveDetailsButton.click();
    Thread.sleep(5000);
  
}



   
}