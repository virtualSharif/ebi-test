
Steps to run the project :

	This project is java maven project so once you unzip the directory.  Please follow the below steps:

-----------------------------------------------------------------------------------------------------------------------
Step 1. Open terminal and goto the basediretory :

	cd /path/to/project/ebi-test

for listing the files in the directory.

	ls

Output :
You will get the following structure:

	pom.xml
	src
	target

------------------------------------------------------------------------------------------------------------------------
Step 2.

a. Using Java :

You must to have java installed on your machine :
	If java is not installed, use  https://www.java.com/en/download/help/download_options.xml to install.
	If java is already installed :

	java -jar target/ebi-test-0.0.1-SNAPSHOT.jar

OR

b. Using Maven :
You much have maven installed on your machine :
If maven is not installed, use https://maven.apache.org/install.html to install.
If maven is already installed :

	mvn clean install spring-boot:run

Output:
Last line on the terminal will look like similar to the below line :


	INFO 28729 --- [           main] uk.ac.ebi.app.WebApplication                : Started WebApplication in 4.232 seconds (JVM running for 119.576)

------------------------------------------------------------------------------------------------------------------------
Step 3. to check whether REST APIs of application is working or not. Open browser and go to below url:

	http://localhost:8080/api/v1/hello

Output:
You will get below text as response.

	Hello Engineer @ EBI

Hurray! Application is ready to use.
------------------------------------------------------------------------------------------------------------------------
Step 4: to check the front-end of web application with the perspective of end user. Open browser and go to below url:

	http://localhost:8080

	Output :
	The above link will redirect to analysis page where you need to put input in the text field and press search button or hit enter.
------------------------------------------------------------------------------------------------------------------------

Step 5 : To check, the REST apis of web application. Open browser and go to below url :

	 http://localhost:8080/s or  http://localhost:8080/swagger or http://localhost:8080/swagger-ui.html

------------------------------------------------------------------------------------------------------------------------
Step 6 : To run the test of the application :
a. First stop the application(assuming you were already running the application using above steps) using following keys :

	ctrl+c

b. As this project is Maven project. If you run project using maven commands, test will automatically starts while running the application. Using following commands on terminal to run application via maven.

	mvn clean install spring-boot:run

Output :

This command also builds the project and runs test cases and followed by start the web application too.

	Results :
	Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
	…
	INFO 28729 --- [           main] uk.ac.ebi.app.WebApplication                : Started WebApplication in 4.232 seconds (JVM running for 119.576)

------------------------------------------------------------------------------------------------------------------------
