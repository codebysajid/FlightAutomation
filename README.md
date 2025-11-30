# FlightAutomation
End-to-end tests for BlazeDemo site using Page Object Model.
Selenium Web UI automation project using **Java**, **Maven**, and **TestNG**.

## Prerequisites

- Java JDK 25.0.1 (set `JAVA_HOME`).  
- Maven 3.9.11 (set MAVEN_HOME).    
- IDE IntelliJ IDEA 2025.2.1


<pre>
├── src
│   └── main/java  # Pages, utils, baseClass
│   └── test/java  # TestNG tests/ testClass
└── pom.xml        # Dependencies
├── README.md      #Project description
├── testng.xml     # TestNG suite file</pre>
 

# Run all tests (Maven)    
  Use the command in IDE terminal 
  mvn test clean
OR
  Right-click the test class or testng.xml and select Run.  

# Reports & logs

TestNG HTML report: Generated under target/surefire-reports/index.html - To generate the new report for each run use command "mvn test clean" in IDE terminal
