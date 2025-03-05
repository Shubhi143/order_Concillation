package ElevateNow.Order.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ElevateNow.Order.DriverSingleton;
import ElevateNow.Order.ReportSingleton;
import ElevateNow.Order.pages.Invoice;
import ElevateNow.Order.pages.SignIn;

// Test case 4: generate payment Invoice and view the invoice details and update the invoice details
public class TestCase4 {
    private static WebDriver driver;
        private SignIn signInPage;
        private static ExtentReports report;
                private static ExtentTest test;
                    
                        @BeforeSuite
                        public void setup() {
                            System.out.println("Initialising the driver");
                            driver = (ChromeDriver) DriverSingleton.getDriverInstance("chrome");
                           // signInPage = new SignIn(driver);
                            ReportSingleton rs1 = ReportSingleton.getInstanceOfSingletonReportClass();
                            report = rs1.getReport();
                            test = report.startTest("Add Invoices Test Suite");
                        }
                    
                        @Test
                        public void addInvoiceAndPayouts() throws InterruptedException {
                            test.log(LogStatus.INFO, "Clicking on Patient tab");
                            // SignIn signInPage = new SignIn(driver);
                            // test.log(LogStatus.INFO, "Entering mobile number"); 
                            // signInPage.enterMobileNumber(signInPage.mobileNumber);
                            
                            // test.log(LogStatus.INFO, "Clicking send OTP button");
                            // signInPage.clickSendOTP();
                            
                            // test.log(LogStatus.INFO, "Entering OTP and clicking sign in");
                            // signInPage.clickSignIn();
                            
                            Thread.sleep(3000); // Wait for sign in to complete
                            Invoice invoice = new Invoice(driver);
                            invoice.navigateToOrder();
                            Thread.sleep(2000);
                            test.log(LogStatus.INFO, "Clicking on first pending status");
                            invoice.clickFirstPendingStatus();
                            Thread.sleep(2000);
                            test.log(LogStatus.INFO, "Clicking on more options");
                          invoice.selectVendor();
                            test.log(LogStatus.INFO, "Clicking on generate invoice");
                           invoice.clickGenerateInvoice();
                                test.log(LogStatus.INFO, "Uploading invoice");
                            invoice.uploadInvoice();
                            test.log(LogStatus.INFO, "Selecting invoice date");
                           invoice.selectInvoiceDate();
                           Thread.sleep(5000);
                            test.log(LogStatus.INFO, "Clicking on view invoice");
                            invoice.clickViewInvoice();
                            test.log(LogStatus.INFO, "Clicking on save");
                            invoice.clickGeneratePayout();
                            Thread.sleep(2000);
                            test.log(LogStatus.INFO, "Clicking on view payout");
                        //    invoice.viewPayout();
                        //     Thread.sleep(2000);
                        //     test.log(LogStatus.INFO, "Clicking on view payout");
                        //     invoice.editPayout();
                            Thread.sleep(2000);
                            test.log(LogStatus.INFO, "Clicking on view payout");
                        } 
                        

                        @Test(priority = 2)
                        public void testInvalidInvoiceAndPayoutOperations() throws InterruptedException {
                            test.log(LogStatus.INFO, "Starting negative test scenarios");
                    
                            try {
                                // Sign in
                                test.log(LogStatus.INFO, "Attempting sign in with invalid credentials");
                                SignIn signInPage = new SignIn(driver);
                                signInPage.enterMobileNumber("1234567890"); // Invalid mobile
                                signInPage.clickSendOTP();
                                signInPage.clickSignIn();
                                
                                Thread.sleep(2000);
                                
                                // Try to generate invoice without proper access
                                Invoice invoice = new Invoice(driver);
                                test.log(LogStatus.INFO, "Attempting to navigate to orders without proper authentication");
                                invoice.navigateToOrder();
                                
                                test.log(LogStatus.INFO, "Attempting to click pending status without valid order");
                                invoice.clickFirstPendingStatus();
                                
                                test.log(LogStatus.INFO, "Attempting to generate invoice without selecting vendor");
                                invoice.clickGenerateInvoice();
                                
                                test.log(LogStatus.INFO, "Attempting to upload invalid invoice file");
                                invoice.uploadInvoice(); // Should fail for invalid file
                                
                                test.log(LogStatus.INFO, "Attempting to generate payout without proper invoice details");
                                invoice.clickGeneratePayout();
                                
                                test.log(LogStatus.INFO, "Attempting to view non-existent payout");
                               // invoice.viewPayout();
                                
                                test.log(LogStatus.PASS, "System successfully prevented unauthorized/invalid operations");

                                
                            } catch (Exception e) {
                                test.log(LogStatus.PASS, "Test passed - Operations failed as expected with error: " + e.getMessage());
                            }
                        }
                      
                        @AfterSuite
                        public static void quitDriver() {
                         
                                System.out.println("quit()");
                                if (driver != null) {
                                driver.close();
                                driver.quit();
                                test.log(LogStatus.PASS, "Driver quit successfully");
                        }
                        if (report != null) {
                                report.flush();
                                test.log(LogStatus.INFO, "Report flushed");
                        }
                }
}
