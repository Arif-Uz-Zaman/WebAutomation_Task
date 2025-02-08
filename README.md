# WebAutomation\_Task

## Overview

WebAutomation\_Task is a Maven-based automation framework designed for web testing using Selenium. It follows a structured page-object model and supports test execution with TestNG. The project includes reusable components, utility functions, and data-driven testing capabilities.

## Features

- **Maven Integration:** Dependency management and build automation.
- **Page Object Model (POM):** Enhances maintainability and readability of test scripts.
- **TestNG Support:** Test execution and reporting.
- **Explicit Waits:** Improves test reliability.
- **Data-Driven Testing:** Uses JSON configuration files.
- **Reusable Utility Classes:** Includes functions for handling browser interactions, random data generation, and tab switching.
- **Cross-Browser Testing:** Supports multiple browsers.

## Project Structure

```
WebAutomation_Task
├── pom.xml                         # Project Object Model file for dependencies
├── README.md                       # Project documentation
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── driver
│   │   │   │   └── Browser.java       # Manages browser initialization
│   │   │   ├── elements
│   │   │   │   ├── BaseElement.java  # Base abstract class for UI elements
│   │   │   │   ├── Element.java      # Wrapper class for WebElement actions
│   │   │   │   ├── Links.java        # Manages link elements
│   │   │   ├── pages
│   │   │   │   ├── CartPage.java      # Cart page actions
│   │   │   │   ├── CheckoutPage.java  # Checkout process handling
│   │   │   │   ├── LoginPage.java     # User login actions
│   │   │   │   ├── ProductPage.java   # Product listing and interactions
│   │   │   ├── utility
│   │   │   │   ├── DataReader.java   # Reads test data from JSON
│   │   │   │   ├── Random.java       # Generates random test data 
│   │   │   │   ├── TabSwitch.java    # Handles multiple browser tabs 
│   │   │   ├── waits
│   │   │   │   └── ExplicitWait.java # Implements explicit waits
│   ├── test
│   │   ├── java
│   │   │   ├── Tests
│   │   │   │   ├── AddToCartTest.java       # Tests add-to-cart functionality
│   │   │   │   ├── CartBadgeCountTest.java  # Verifies cart badge count updates
│   │   │   │   ├── CheckOutProcessTest.java # Tests checkout process
│   │   │   │   ├── LockedOutUserTest.java   # Handles locked user scenarios
│   │   │   │   ├── LoginTest.java           # Validates login functionality
│   │   │   │   ├── LogOutTest.java          # Ensures logout functionality
│   │   │   │   ├── SortingProductsTest.java # Tests product sorting options
│   │   │   │   ├── TestBase.java            # Base abstract test setup class
│   ├── resources
│   │   ├── configdata
│   │   │   └── config.json        # Stores environment-specific configurations
│   │   ├── testdata
│   │   │   └── TestData.Json      # Stores test data for execution
├── testng.xml                      # TestNG suite configuration file
```



## Test Class Summary

| Test Class                    | Test Cases                                      |
|--------------------------------|------------------------------------------------|
| Tests.LoginTest               | verifyLoginWithInvalidCredentials              |
|                                | verifyLoginWithInvalidPassword                 |
|                                | verifyLoginWithInvalidUsername                 |
|                                | verifyLoginWithValidCredentials                |
| Tests.AddToCartTest           | verifyAddToCartFunctionality                   |
|                                | verifyCartBadgeCountUpdatesCorrectly           |
| Tests.CheckOutProcessTest     | verifyCheckOutProcess                          |
| Tests.SortingProductsTest     | verifyProductSortingFunctionality              |
| Tests.LogOutTest              | verifyLogOutFunctionality                      |
| Tests.LockedOutUserTest       | verifyALockedUserCantLogin                     |
| Tests.CartBadgeCountTest      | verifyCartBadgeCountShowCorrectly                   |



## Prerequisites

- **Java 8 or later** java version "20.0.2" or Higher
- **Maven** installed
  - If Maven is not installed, follow this guide: [How to resolve 'mvn' is not recognized](https://medium.com/nerd-for-tech/how-to-resolve-the-mvn-is-not-recognized-as-an-internal-or-external-command-operable-program-or-145914fcaaab)
- **Selenium WebDriver**
- **TestNG Plugin** (for running test cases)

## Installation & Setup

1. **Clone the repository:**
   ```sh
   git clone https://github.com/Arif-Uz-Zaman/WebAutomation_Task.git
   ```
2. **Navigate to the project directory:**
   ```sh
   cd WebAutomation_Task
   ```
3. **Install dependencies:**
   ```sh
   mvn clean install
   ```

## Running Tests

### Run all test cases:

```sh
mvn test
```

- This will execute tests randomly from the test file.

### Run specific test file:

```sh
mvn -Dtest=LoginTest test
```

### Run tests using TestNG suite:

```sh
mvn test -DsuiteXmlFile=testng.xml
```

- This will execute tests sequentially.

### Run testng.xml in Eclipse:

To run a `testng.xml` file in Eclipse, follow these steps:

1. Open Eclipse and navigate to the TestNG project folder containing `testng.xml` file.
2. Right-click on the `testng.xml` file.
3. Select **Run As > TestNG Suite**.

## Reports & Logs

- **Chaitest Report:** `target/chaintest/index.html`
- **TestNG Reports:** Located in `test-output/index.html`
- **Surefire Reports:** Found in `target/surefire-reports`
- **Emailable Report:** `test-output/emailable-report.html`

## Author

K.M. Arif Uz Zaman - Software Quality Assurance Engineer

## ChainTest Report 

<a href="https://ibb.co.com/21dsBJZF"><img src="https://i.ibb.co.com/G4RtjmHd/screencapture-file-C-Users-shobo-eclipse-workspace-Web-Automation-Task-target-chaintest-Index-html-2.png" alt="screencapture-file-C-Users-shobo-eclipse-workspace-Web-Automation-Task-target-chaintest-Index-html-2" border="0"></a>