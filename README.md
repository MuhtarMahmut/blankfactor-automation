# Blankfactor Automation Framework

BDD-based UI test automation framework for testing the Blankfactor website, built with Selenium WebDriver, Cucumber, and TestNG.

## Tech Stack

- **Java 21** - Programming language
- **Selenium WebDriver 4.39.0** - For UI automation
- **Cucumber 7.14.0** - For writing tests in Gherkin
- **TestNG 7.8.0** - For test execution and parallel testing
- **Allure 2.24.0** - For test reporting and visualization
- **Maven** - For dependency management and build tool
- **SLF4J & Logback** - For logging framework with console output

## Project Structure

```
blankfactor-automation/
├── src/
│   └── test/
│       ├── java/
│       │   ├── pages/              # Page Object Model classes
│       │   │   ├── BasePage.java
│       │   │   ├── HomePage.java
│       │   │   ├── ContactPage.java
│       │   │   ├── IndustriesPage.java
│       │   │   └── RetirementWealthPage.java
│       │   ├── runner/             # TestNG runners
│       │   │   ├── TestRunner.java
│       │   │   └── FailedTestRunner.java
│       │   ├── stepDefinitions/    # Cucumber step definitions
│       │   │   ├── Hooks.java
│       │   │   └── ContactPageVerificationsSteps.java
│       │   └── utilities/          # Utility classes
│       │       ├── DriverUtilities.java
│       │       ├── PageUtilities.java
│       │       ├── WaitUtilities.java
│       │       └── PropertiesReader.java
│       │ 
│       └── resources/
│           ├── features/           # Cucumber feature files
│           │   └── ContactPageVerifications.feature
│           └── properties/         # Configuration files
│               ├── Configuration.properties
│               ├── testng.xml
│               └── logback.xml
├── pom.xml
└── README.md
```

## Key Features

### Design Patterns

- **Page Object Model (POM)**: Web-page elements and actions
- **BDD with Cucumber**: Gherkin syntax for readable test scenarios
- **Singleton Driver Pattern**: Thread-safe driver management with `InheritableThreadLocal`

### Utilities & Helpers Classes

- **DriverUtilities**: Multi-browser support (Chrome, Firefox, Edge, Safari) with automatic driver management
- **PageUtilities**: Smart element interactions with auto-scrolling and visibility checks
- **WaitUtilities**: Explicit waits with built-in assertions
- **PropertiesReader**: Environment configuration management (dev, stg, uat, prod)

### Reporting & Logging

- **Allure Reports**: Detailed HTML reports with screenshots for failed tests
- **Logback**: Console output and file logging for debugging
- **Screenshot Capture**: Automatic screenshots attached to failed scenarios

### Parallel Execution

- TestNG parallel execution at test level
