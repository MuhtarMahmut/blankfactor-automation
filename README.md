# Blankfactor Automation Framework

BDD-based UI test automation framework for testing the Blankfactor website, built with Selenium WebDriver, Cucumber, and TestNG.

## Tech Stack

- **Java** - Programming language
- **Selenium WebDriver** - For UI automation
- **Cucumber** - For writing tests in Gherkin
- **TestNG** - For test execution and parallel testing
- **Allure** - For test reporting and visualization
- **Maven** - For dependency management and build tool
- **SLF4J & Logback** - For logging framework with console output

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
