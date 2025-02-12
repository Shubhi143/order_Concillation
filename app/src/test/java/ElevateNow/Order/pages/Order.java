package ElevateNow.Order.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Order {
    private WebDriver driver;
    private final String url = "https://staging.joinelevatenow.co.in/orders";

    @FindBy(xpath="//div[text()='Add Order']")
    private WebElement addOrderButton;

    @FindBy(id="addNewAddress") 
    private WebElement addNewAddress;

    @FindBy(xpath="//*[@placeholder='Search Medicine']")
    private WebElement searchMedicine;

    @FindBy(xpath="//button[text()='Next']")
    private WebElement nextButton;

    @FindBy(xpath="//div[text()='Generate Link']")
    private WebElement generateLinkButton;

    @FindBy(xpath="//button[text()='Save Order']")
    private WebElement saveOrderButton;

    public Order(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // public void addNewOrder() throws InterruptedException {
    //     driver.get(url);
    //     Thread.sleep(2000);
        
    //     addOrderButton.click();
    //     Thread.sleep(2000);

    //     addNewAddress.click();
    //     Thread.sleep(2000);

    //     // Fill address details
    //     driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/input")).sendKeys("Bangalore");
    //     driver.findElement(By.xpath("//*[@placeholder='City']")).sendKeys("Bangalore");
    //     driver.findElement(By.xpath("//*[@placeholder='State']")).sendKeys("Karnataka");
    //     driver.findElement(By.xpath("//*[@placeholder='Type Pincode']")).sendKeys("560001");
    //     driver.findElement(By.xpath("//button[text()='Save Address']")).click();
    //     Thread.sleep(2000);

    //     // Select address and proceed
    //     driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/input")).click();
    //     nextButton.click();
    //     Thread.sleep(2000);

    //     // Add medicines
    //     driver.findElement(By.xpath("//button[text()='+ Add Another Medicine']")).click();
    //     Thread.sleep(2000);
        
    //     searchMedicine.sendKeys("Vinglyn");
    //     Thread.sleep(1000);
    //     driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td[2]/div/div[1]/div[2]/a[1]")).click();
    //     Thread.sleep(5000);

    //    // nextButton.click();
    //     Thread.sleep(2000);

    //   //  generateLinkButton.click();
    //     Thread.sleep(2000);

    //    // saveOrderButton.click();
    //     Thread.sleep(2000);
    // }

    public boolean isOrderSaved() {
        try {
            WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(),'Order saved successfully')]"));
            return successMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
