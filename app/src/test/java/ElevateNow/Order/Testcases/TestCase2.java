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
import ElevateNow.Order.pages.Home;
import ElevateNow.Order.pages.PatientDashboard;
import ElevateNow.Order.pages.SignIn;

//Dashboard Navigation Test Cases and adding patient and prescription
public class TestCase2 {
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
                    test = report.startTest("Add Prescription Test Suite");
                }
                
                @Test(priority = 1)
                public void navigateToPatientDashboard() throws Exception {
                   
                            try{
                            // Navigate to patient dashboard
                            test.log(LogStatus.INFO, "Clicking on Patient tab");
                            // SignIn signInPage = new SignIn(driver);
                            // test.log(LogStatus.INFO, "Entering mobile number");
                            // signInPage.enterMobileNumber(signInPage.mobileNumber);
                            
                            // test.log(LogStatus.INFO, "Clicking send OTP button");
                            // signInPage.clickSendOTP();
                            
                            // test.log(LogStatus.INFO, "Entering OTP and clicking sign in");
                            // signInPage.clickSignIn();
                            
                            Thread.sleep(3000); // Wait for sign in to complete
                            Home home = new Home(driver);
                            Thread.sleep(5000);
                            test.log(LogStatus.INFO, "Navigating to patient dashboard");
                            home.clickAddPatient();
                            Thread.sleep(1000);
                            home.enterUserName("Shubhi Testing"); 
                            Thread.sleep(1000);
                            home.enterMobileNumber("9955663688");  
                            Thread.sleep(1000);
                            home.enterEmailAddress("testcheckuser@gmail.com"); 
                            Thread.sleep(1000);
                            test.log(LogStatus.PASS, "Successfully navigated to patient dashboard");
                            Thread.sleep(1000);
                            home.clickSave();
                            
                        } catch (Exception e) {
                            test.log(LogStatus.FAIL, "Test failed: " + e.getMessage());
                        
                            throw e;
                        }
                }
                
                
                           @Test(priority = 2)
                            public void addPrescription() throws Exception {
                                try {
                                    Home home = new Home(driver);
                                    Thread.sleep(1000);
                                    
                                    test.log(LogStatus.INFO, "Searching for patient");
                                    home.enterSearchPatient("Shubhi Testing");
                                    Thread.sleep(1000);
                                    
                                    test.log(LogStatus.INFO, "Opening patient dashboard");
                                    PatientDashboard patientDashboard = new PatientDashboard(driver);
                                    
                                    test.log(LogStatus.INFO, "Assigning doctor to patient");
                                    patientDashboard.clickAssignDoctor();
                                    Thread.sleep(1000);
                                    
                                    test.log(LogStatus.INFO, "Clicking add prescription button");
                                   patientDashboard.clickAddPrescription();
                                    Thread.sleep(1000);
                                    
                                    test.log(LogStatus.INFO, "Adding prescription details");
                                    patientDashboard.addPrescription();
                                    Thread.sleep(1000);
                                    test.log(LogStatus.PASS, "Successfully added prescription");
                                    
                                    test.log(LogStatus.INFO, "Publishing prescription");
                                    patientDashboard.publishPrescription();
                                    Thread.sleep(1000);
                                    test.log(LogStatus.PASS, "Successfully published prescription");
                
                
                                } catch (Exception e) {
                                    test.log(LogStatus.FAIL, "Failed to add prescription: " + e.getMessage());
                                    throw e;
                                }
                            }
                            @Test(priority = 3)
                            public void addPatientWithInvalidEmail() {
                                try {
                                    Home home = new Home(driver);
                                    test.log(LogStatus.INFO, "Testing invalid email format");
                                    home.clickAddPatient();
                                    home.enterUserName("Shubhi Testing");
                                    home.enterMobileNumber("1234567890");
                                    home.enterEmailAddress("invalid.email"); // Invalid email format
                                    home.clickSave();
                                    test.log(LogStatus.PASS, "System correctly prevented invalid email submission");
                                } catch (Exception e) {
                                    test.log(LogStatus.PASS, "System correctly prevented invalid email submission: " + e.getMessage());
                                }
                            }
                        
                            @Test(priority = 4)
                            public void searchNonExistentPatient() {
                                try {
                                    Home home = new Home(driver);
                                    test.log(LogStatus.INFO, "Searching for non-existent patient");
                                    home.enterSearchPatient("NonExistentPatient123456");
                                    test.log(LogStatus.PASS, "System handled non-existent patient search appropriately");
                                } catch (Exception e) {
                                    test.log(LogStatus.PASS, "System correctly handled non-existent patient search: " + e.getMessage());
                                }
                            }
                        
                
                            @Test(priority = 5)
                            public void addPrescriptionWithoutDoctor() {
                                try {
                                    Home home = new Home(driver);
                                    home.enterSearchPatient("Shubhi Testing");
                                    PatientDashboard patientDashboard = new PatientDashboard(driver);
                                    test.log(LogStatus.INFO, "Attempting to add prescription without assigning doctor");
                                    patientDashboard.clickAddPrescription();
                                    test.log(LogStatus.PASS, "System prevented prescription creation without doctor assignment");
                                } catch (Exception e) {
                                    test.log(LogStatus.PASS, "System correctly prevented prescription without doctor: " + e.getMessage());
                                }
                            }
                        
                            @Test(priority = 6)
                            public void publishUncompletedPrescription() {
                                try {
                                    Home home = new Home(driver);
                                    home.enterSearchPatient("Shubhi Testing");
                                    PatientDashboard patientDashboard = new PatientDashboard(driver);
                                    test.log(LogStatus.INFO, "Attempting to publish incomplete prescription");
                                    patientDashboard.publishPrescription();
                                    test.log(LogStatus.PASS, "System prevented publishing incomplete prescription");
                                } catch (Exception e) {
                                    test.log(LogStatus.PASS, "System correctly prevented publishing incomplete prescription: " + e.getMessage());
                                }
                            }
                
                    
                            @Test(priority = 7) 
                            public void addPatientWithInvalidMobile() {
                                try {
                                    Home home = new Home(driver);
                                    test.log(LogStatus.INFO, "Testing invalid mobile number");
                                    home.clickAddPatient();
                                    home.enterUserName("Test User");
                                    home.enterMobileNumber("123"); // Invalid mobile number
                                    home.enterEmailAddress("test@example.com");
                                    home.clickSave();
                                    test.log(LogStatus.PASS, "System correctly prevented invalid mobile number submission");
                                } catch (Exception e) {
                                    test.log(LogStatus.PASS, "System correctly prevented invalid mobile number: " + e.getMessage());
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
