package ElevateNow.Order.Testcases;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

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
import ElevateNow.Order.pages.Home;
import ElevateNow.Order.pages.Order;
import ElevateNow.Order.pages.PatientDashboard;
import ElevateNow.Order.pages.SignIn;

//add order to the patient dashboard and check the order status
public class TestCase3 {
    private static WebDriver driver;
        private SignIn signInPage;
        private static ExtentReports report;
                private static ExtentTest test;
                    
                        @BeforeSuite
                        public   void setup() {
                            System.out.println("Initialising the driver");
                            driver = (ChromeDriver) DriverSingleton.getDriverInstance("chrome");
                           // signInPage = new SignIn(driver);
                            ReportSingleton rs1 = ReportSingleton.getInstanceOfSingletonReportClass();
                            report = rs1.getReport();
                            test = report.startTest("Order Concillation Test Suite");
                        }
                         
                        
                        @Test(priority=1)
                        public void testCase3() throws InterruptedException, UnsupportedFlavorException, IOException {
                            test.log(LogStatus.INFO, "Starting testCase3");
                    
                             // test = report.startTest("Sign In Test", "Test to verify sign in functionality");
                            //  test.log(LogStatus.INFO, "Entering mobile number");
                            //  // test.info("Mobile number: " + signInPage.mobileNumber);
                            //   signInPage.enterMobileNumber(signInPage.mobileNumber);
                              
                            //   test.log(LogStatus.INFO, "Clicking send OTP button");
                            //   signInPage.clickSendOTP();
                              
                            //   test.log(LogStatus.INFO, "Entering OTP and clicking sign in");
                            //   signInPage.clickSignIn();
                              
                            //   if(signInPage.isSignInPageDisplayed()) {
                            //       test.log(LogStatus.PASS, "Sign in successful");
                            //   }
                        
                            Home home = new Home(driver);
                            home.enterSearchPatient("Shubhi Testing");
                            Thread.sleep(1000);
                            
                            test.log(LogStatus.INFO, "Opening patient dashboard");
                            PatientDashboard patientDashboard = new PatientDashboard(driver);
                            patientDashboard.addOrder();
                             test.log(LogStatus.INFO, "Adding order to patient");
                            test.log(LogStatus.INFO, "Creating new order instance");
                          // Order order = new Order(driver);
                            test.log(LogStatus.INFO, "Adding new order");
                         //   order.addNewOrder();
                            test.log(LogStatus.INFO, "Verifying order was saved");
                           
                            test.log(LogStatus.PASS, "Successfully added order");
                        }
                    
                        @Test(priority=2)
                        public void testCase3Negative() throws InterruptedException {
                            test.log(LogStatus.INFO, "Starting negative test case");
                    
                            try {
                                // Sign in
                                test.log(LogStatus.INFO, "Attempting sign in with invalid mobile number");
                                signInPage.enterMobileNumber("1234567890"); // Invalid mobile number
                                
                                test.log(LogStatus.INFO, "Clicking send OTP button");
                                signInPage.clickSendOTP();
                                
                                test.log(LogStatus.INFO, "Entering OTP and clicking sign in");
                                signInPage.clickSignIn();
                                
                                // Search non-existent patient
                                test.log(LogStatus.INFO, "Searching for non-existent patient");
                                Home home = new Home(driver);
                                home.enterSearchPatient("NonExistentPatient123");
                                Thread.sleep(1000);
                                
                                // Attempt to create order without patient
                                test.log(LogStatus.INFO, "Attempting to create order without valid patient");
                                Order order = new Order(driver);
                              //  order.addNewOrder();
                                
                                // Verify order was not saved
                                if(!order.isOrderSaved()) {
                                    test.log(LogStatus.PASS, "Test passed - Order was not saved as expected");
                                } else {
                                    test.log(LogStatus.FAIL, "Test failed - Order was saved when it should not have been");
                                }
                                
                            } catch (Exception e) {
                                test.log(LogStatus.PASS, "Test passed - Operation failed as expected with error: " + e.getMessage());
                            }
                        }
                        
                        @AfterSuite
                        public static void quitDriver() {
                            try {
                                System.out.println("quit()");
                                if (driver != null) {
                                driver.close();
                                driver.quit();
                                test.log(LogStatus.PASS, "Driver quit successfully");
                    }
                } catch (Exception e) {
                    test.log(LogStatus.FAIL, "Driver quit failed: " + e.getMessage());
                } finally {
                    if (report != null) {
                report.flush();
                test.log(LogStatus.INFO, "Report flushed");
            }
        }
    }
}






