# Flight Automation - End-to-end tests for BlazeDemo site using Page Object Model.
Selenium Web UI automation project using **Java**, **Maven**, and **TestNG**.

# Prerequisites

- Java JDK 25.0.1 (set `JAVA_HOME`).  
- Maven 3.9.11 (set `MAVEN_HOME`).    
- IDE IntelliJ IDEA `2025.2.1`

# Environment Setup to run the test cases 

- User Machine should have Java JDK with environment variable setup -> for verification -> java --version
- User Machine should have Maven with environment variable setup -> for verification -> mvn --version
- Download the project from the github repo -> https://github.com/codebysajid/FlightAutomation
- User Machine should have intelliJ IDE
  - Steps in IntelliJ IDEA:
  - Projects → Open → select project folder.
  - IntelliJ will detect pom.xml and automatically import dependencies.
  - **(If needed) To Resolve dependencies**
  - run the command `mvn clean install` in IDE terminal
    
# Project Structure 
```
── README.md
├── src
│   ├── main/java         # Pages, utils, baseClass
│   └── test/java         # TestNG tests/ testClass
├── pom.xml               # Dependencies
└── testng.xml            # TestNG suite file
```
# Run all tests (Maven)

  use the command in IDE terminal `mvn test clean`**or** Right-click the test class or testng.xml file and select *Run*.

# Reports & logs

TestNG HTML report: Generated under target/surefire-reports/index.html - To generate the new report for each run use command `mvn test clean` in IDE terminal






