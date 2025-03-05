package ElevateNow.Order.pages;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
public class PatientDashboard {
    
    private final String url = "hhttps://preweb.joinelevatenow.co.in/patient/6472/dashboard";
    private WebDriver driver;

    String doctorName = "Doctor_onlyfortesting";

    @FindBy(xpath="//*[@id='root']/div[2]/div[3]/div/div[1]/div[2]/div/div/div/div[1]/div[3]/div")
    WebElement prescription;
@FindBy(xpath ="//*[@placeholder='Assign Doctor/Health Coach']")
WebElement assignDoctor;

@FindBy(xpath ="//span[text()='Select Doctor']")
WebElement SelectDoctor;

@FindBy(xpath="/html/body/div/div[2]/div[2]/div/div[1]/div/div[3]/div/textarea")
WebElement addDiagonsis;

@FindBy(xpath ="//*[@id='root']/div[2]/div[3]/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div/div[1]")
WebElement selectDoctor;

@FindBy(xpath ="//button[text()=' New Prescription']")
WebElement addPrescription;

@FindBy(xpath="//*[@id='root']/div[2]/div[2]/div/div[4]/div/div/textarea")
WebElement addAdvice;

@FindBy(xpath="//*[@id='root']/div[2]/div[3]/div/div[1]/div[2]/div/div/div/div[1]/div[11]/div")
WebElement addOrder;

@FindBy(xpath="//div[text()='Add Order']")
WebElement addOrderButton;

@FindBy(id="addNewAddress")
WebElement addNewAddress;
@FindBy(xpath="//*[@placeholder='Search Medicine']")
WebElement searchMedicine;
public PatientDashboard(WebDriver driver) throws InterruptedException {
    this.driver = driver;
    org.openqa.selenium.support.PageFactory.initElements(driver, this);
    driver.get(url);
    Thread.sleep(5000);
    }

    public void clickAssignDoctor() throws InterruptedException {
        assignDoctor.click();
        Thread.sleep(5000);
        assignDoctor.sendKeys(doctorName);
        Thread.sleep(5000);
        selectDoctor.click();
        Thread.sleep(5000);
    }
    public void clickAddPrescription() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(5000);
       addPrescription.click();
        Thread.sleep(5000);

    }
    public void addOrder() throws InterruptedException, UnsupportedFlavorException, IOException {
        addOrder.click();
        Thread.sleep(5000);
        addOrderButton.click();
        Thread.sleep(5000);
        // Select address
    //   addNewAddress.click();
    //     Thread.sleep(5000);
    //     driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[2]/div/div[2]/div/div[3]/div[2]/input")).sendKeys("Banglore");
    //     // Click Next after address selection
    //     driver.findElement(By.xpath("//*[@placeholder='City']")).sendKeys("Banglore");
    //     driver.findElement(By.xpath("//*[@placeholder='State']")).sendKeys("Karnataka");
    //     driver.findElement(By.xpath("//*[@placeholder='Type Pincode']")).sendKeys("560001");
    //     driver.findElement(By.xpath("//button[text()='Save Address']")).click();
        Thread.sleep(2000);
       driver.findElement(By.xpath("//*[@name='address']")).click();
       Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Next']")).click();
        Thread.sleep(5000);
      
     //Add another medicine
        driver.findElement(By.xpath("//button[text()='+ Add Another Medicine']")).click();
        Thread.sleep(5000);
        
      //  Search and select second medicine
        driver.findElement(By.xpath("//*[@placeholder='Search medicine']")).sendKeys("Erybest 250mg Tablet");
        Thread.sleep(5000);
      // driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/span")).click();
        Thread.sleep(5000);
       // driver.findElement(By.xpath("//span[text()='Select']")).click();
        Thread.sleep(5000);
    
        
    //   // Add discount
    //     WebElement discountInput = driver.findElement(By.xpath("//*[@placeholder='Discount %']"));
    //     discountInput.clear();
    //     discountInput.sendKeys("20");
    Thread.sleep(5000);
        
        // Click Next after adding medicines
        driver.findElement(By.xpath("//button[text()='Next']")).click();
        Thread.sleep(5000);
        
        // Generate payment link
    //     driver.findElement(By.xpath("//div[text()='Generate Link']")).click();
    //     Thread.sleep(2000);
    //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       
    // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Copy Pay Link']"))).click();
  

    // // Clipboard and new tab handling
    // Toolkit toolkit = Toolkit.getDefaultToolkit();
    // Clipboard clipboard = toolkit.getSystemClipboard();
    // String copiedLink = (String) clipboard.getData(DataFlavor.stringFlavor);
  

    // ((JavascriptExecutor) driver).executeScript("window.open();");
    // Set<String> windowHandles = driver.getWindowHandles();
    // String newTabHandle = windowHandles.toArray(new String[0])[1];
    // driver.switchTo().window(newTabHandle);

    // driver.get(copiedLink);
  

    // driver.switchTo().window(windowHandles.iterator().next());
    

    //record the payment
    driver.findElement(By.xpath("//div[text()='Record Payment']")).click();
    Thread.sleep(3000);

  WebElement mode= driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div[2]/div[1]/div/select"));
  Select select = new Select(mode);
  select.selectByVisibleText("Offline");
  Thread.sleep(1000);
 WebElement form= driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div[2]/div[2]/div/select"));
 Select select1 = new Select(form);
 select1.selectByVisibleText("Cash");
 Thread.sleep(1000);
 WebElement paymentWith= driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div[2]/div[4]/div/select"));
 Select select2 = new Select(paymentWith);
 select2.selectByVisibleText("Test Operator");
 Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div[2]/div[6]/div/div")).click();
Thread.sleep(5000);

    // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Save Order']"))).click();
    // Thread.sleep(5000);

    }

    public void addPrescription() throws InterruptedException {
    
        SelectDoctor.click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/span")).click();
        Thread.sleep(5000);
        addDiagonsis.sendKeys("test");
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div/div[1]/span")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@placeholder='Search']")).sendKeys("Tablet");
       // searchMedicine.sendKeys("Tablet");
        Thread.sleep(5000);
       driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[3]/div[1]/div[2]/div[4]/input")).click();
       addAdvice.sendKeys("test");
       Thread.sleep(5000);
       
       driver.findElement(By.xpath("//div[text()='Save Details']")).click();
       Thread.sleep(5000);
    }
    public void publishPrescription() throws InterruptedException {
        prescription.click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[3]/div/div[1]/div[2]/div/div/div/div[3]/div[1]/div/div/div[1]/div[2]/div[5]/div/span")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Publish']")).click();
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(5000);
        
    }
}
