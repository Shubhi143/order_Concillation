# order_Concillation
# Order Reconciliation Test Automation Project

## Overview
This project contains automated test scripts for testing order reconciliation functionality in the ElevateNow application. The tests cover various scenarios including invoice generation, payment processing, and order status management.

## Key Features Tested
- Order creation and management
- Invoice generation and verification 
- Payment processing and status updates
- Patient dashboard functionality
- Vendor selection and management
- Payout generation and tracking
- Automated test reporting with ExtentReports
- Code coverage analysis with JaCoCo

## Test Cases
The project includes the following main test cases:
### TestCase1: Sign In Functionality
- Tests user authentication and login flow
- Validates OTP generation and verification
- Includes negative test cases for invalid credentials
- Located in `app/src/test/java/ElevateNow/Order/Testcases/TestCase1.java`

### TestCase2: Patient and Prescription Management
- Tests adding new patients to the system
- Validates prescription creation and publishing
- Includes validation of patient details like mobile number
- Tests incomplete prescription handling
- Located in `app/src/test/java/ElevateNow/Order/Testcases/TestCase2.java`

### TestCase3: Order Management
- Tests adding orders to patient dashboard
- Verifies order status updates
- Includes negative test scenarios for invalid operations
- Located in `app/src/test/java/ElevateNow/Order/Testcases/TestCase3.java`

### TestCase4: Invoice and Payment Processing  
- Tests invoice generation workflow
- Validates payment processing
- Verifies payout generation and status updates
- Includes negative test scenarios
- Located in `app/src/test/java/ElevateNow/Order/Testcases/TestCase4.java`

## Project Structure
