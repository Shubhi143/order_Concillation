package ElevateNow.Order.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn {
    private WebDriver driver;
    String url="https://preweb.joinelevatenow.co.in/";
    String OTP="596921";

    public String mobileNumber="9643243200";
    @FindBy(xpath="//*[@placeholder='Registered Mobile Number']")
    private WebElement MobilelInput;


    @FindBy(xpath="//*[@type='number'][1]")
    WebElement otp1;
    
    @FindBy(xpath ="//*[@type='number'][2]")
    WebElement otp2;
    
    @FindBy(xpath ="//*[@type='number'][3]")
    WebElement otp3;
    
    @FindBy(xpath = "//*[@type='number'][4]")
    WebElement otp4;
    
    @FindBy(xpath ="//*[@type='number'][5]")
    WebElement otp5;
    
    @FindBy(xpath ="//*[@type='number'][6]")
    WebElement otp6;


    @FindBy(xpath="//div[text()='Send OTP']") 
    private WebElement sendOTPButton;

    @FindBy(xpath ="//div[text()='Sign In']")
    private WebElement signInButton;

    public SignIn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void enterMobileNumber(String mobileNumber) {
        MobilelInput.sendKeys(mobileNumber); 
    }
    public void clickSendOTP() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(sendOTPButton));
        sendOTPButton.click();
    }

  

    public void clickSignIn() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(otp1));
        otp1.sendKeys(OTP.substring(0,1));
        otp2.sendKeys(OTP.substring(1,2));
        otp3.sendKeys(OTP.substring(2,3));
        otp4.sendKeys(OTP.substring(3,4));
        otp5.sendKeys(OTP.substring(4,5));
        otp6.sendKeys(OTP.substring(5,6));
    

        wait.until(ExpectedConditions.visibilityOf(signInButton));
                    
        signInButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public boolean isSignInPageDisplayed() {
        return driver.getCurrentUrl().contains("dashboard");
    }

}
