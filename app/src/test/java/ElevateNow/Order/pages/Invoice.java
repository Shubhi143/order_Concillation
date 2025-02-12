package ElevateNow.Order.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Invoice {
    private final WebDriver driver;
    
    String url="https://staging.joinelevatenow.co.in/orders";
    // Web Elements
// List of Orders (All Order Rows)

// First Pending Status
@FindBy(xpath = "(//span[contains(text(),'Pending')])[1]")
WebElement firstPendingStatus;


@FindBy(xpath = "//span[text()='pending']")
private WebElement pendingStatus;
// Three-dot (ellipsis) menu for order actions


@FindBy(xpath = "//button[text()='Select']")
private WebElement selectVendor;
    
    @FindBy(xpath = "//*[@id='root']/div[2]/div[3]/div/div[3]/div/div/div[2]/div")
    ////*[@id='root']/div[2]/div[3]/div/div[3]/div/div/div[2]/div
    private WebElement generateInvoiceButton;
    
    @FindBy(xpath = "//span[text()='Order Placed']")
    private WebElement orderPlaced;

    @FindBy(xpath = "//span[text()='Amazon']")
    private WebElement vendorName;

    @FindBy(xpath = "//div[text()='View Invoice']")
    private WebElement viewInvoice;

    @FindBy(xpath = "//div[text()='View Payout']")
    private WebElement viewPayout;

    @FindBy(xpath = "//*[@id='root']/div[3]/div[1]/div/div[5]/div[2]/div[2]/div/div")
    private WebElement generatePayout;
    // Constructor
    public Invoice(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    

    public void navigateToOrder() throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);
    
    }

    //click on first pending status and view details
    public void clickFirstPendingStatus() throws InterruptedException {
        // String status = firstPendingStatus.getText();
        // System.out.println(status);
        // if (firstPendingStatus.getText().contains("Pending")) {
            driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[9]/button")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//span[text()='View Details']")).click();
            Thread.sleep(5000);
           

        // }

    }

    public void clickGeneratePayout() throws InterruptedException {
        generatePayout.click();
        Thread.sleep(5000);
        WebElement paymentAmount = driver.findElement(By.xpath("//input[@placeholder='Payment Amount']"));
        paymentAmount.sendKeys("500");
        Thread.sleep(5000);
        // Select payout type from dropdown
        WebElement payoutTypeDropdown = driver.findElement(By.xpath("//span[text()='Payout Type']"));
       
        payoutTypeDropdown.click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='Bank Transfer']")).click();
        Thread.sleep(5000);
        // Enter reference ID
        WebElement referenceId = driver.findElement(By.xpath("//input[@placeholder='Reference ID']"));
        referenceId.sendKeys("REF12345");
        Thread.sleep(5000);
        // Select 'Pending' status
        // WebElement pendingStatus = driver.findElement(By.xpath("//input[@value='Pending']"));
        // pendingStatus.click();
        // Thread.sleep(5000);
        // Click 'Save Changes' button
        WebElement saveChangesBtn = driver.findElement(By.xpath("//div[contains(text(),'Save Changes')]"));
        saveChangesBtn.click();
        Thread.sleep(5000);

    }

    public void  viewPayout() throws InterruptedException {
        driver.get("https://staging.joinelevatenow.co.in/orders");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[9]/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='View Details']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[text()='View Payout']")).click();
        Thread.sleep(5000);
    }

    public void editPayout() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='root']/div[3]/div[1]/div/div[2]/div/div/div")).click();
        Thread.sleep(5000);
    driver.findElement(By.xpath("//label[text()='Completed']")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//div[text()='Save Changes']")).click();
    Thread.sleep(5000);
    }

    public void selectVendor() throws InterruptedException {
        if(selectVendor.isDisplayed()){
        selectVendor.click();
        Thread.sleep(5000);
        vendorName.click();
        }
        Thread.sleep(5000);
        pendingStatus.click();
        Thread.sleep(5000);
        orderPlaced.click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[3]/div/div[4]/table/tbody/tr/td[10]/button[1]")).click();
        Thread.sleep(5000);
    }

    
    public void clickGenerateInvoice() throws InterruptedException {
        generateInvoiceButton.click();
        Thread.sleep(5000);
    }
    
  public void clickViewInvoice() throws InterruptedException {
    viewInvoice.click();
    Thread.sleep(5000);
  }
    
 
    public void uploadInvoice() throws InterruptedException {
        WebElement uploadElement = driver.findElement(By.id("invoice")); // adjust locator as needed
uploadElement.sendKeys("//Users//indianrenters//Documents//file-sample_150kB.pdf");
Thread.sleep(2000);

    }

    public void selectInvoiceDate() throws InterruptedException {
        driver.findElement(By.xpath("//*[@placeholder='Enter Invoice Date']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Today']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div/div[2]/div[5]/div[1]/div/div[2]/div/div[5]/div")).click();
        Thread.sleep(5000);
    }
        
  
}