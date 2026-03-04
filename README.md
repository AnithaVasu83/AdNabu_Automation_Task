## This project automates the scenario: Search for a product and add it to the cart successfully using Selenium + Java + TestNG.

### Prerequisites

1. Java JDK 17 or above (tested with JDK 23) - ensure JAVA_HOME/bin is in PATH.

2. Maven 3.x (tested with maven 3.9.12) - ensure MAVEN_HOME/bin is in PATH.

3. Chrome browser installed.

### Dependencies

#### All required dependencies are managed using Maven in the pom.xml file.

This project uses libraries such as:

1.Selenium java - for browser automation

2.TestNG - for test framework and assertions

3.Maven Surefire Plugin - to run tests and generate HTML reports automatically
   

### How to Run Tests

### Option 1: Through IDE

1.Clone the repo:
     In terminal : git clone https://github.com/AnithaVasu83/AdNabu_Automation_Task/

2. Open the project in IntelliJ.

3. Right-click the test class 'SearchAndAddToCartTest' → Run.

4. After execution, HTML report will be generated automatically in: target/surefire-reports/index.html. Open Report in browser.

### Option 2: Through Terminal

1.Open CMD / terminal.

2. Clone the repo: git clone https://github.com/AnithaVasu83/AdNabu_Automation_Task/

3. Go to project folder: cd <project-folder>

4. Run tests: mvn clean test

5. After execution, HTML report will be generated automatically in: target/surefire-reports/index.html. Open Report in browser.

