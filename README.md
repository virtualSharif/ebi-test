Documentation:

	Project name : Transcript Analyzer
	Days took to build : Approximately 2days.
------------------------------------------------------------------------------------------------------------------------
Steps to run the project:

	Please refer run-readme.md file.
------------------------------------------------------------------------------------------------------------------------
Project Modules :

	This project consists of two major parts :
	a. Backend - RESTful api's build in Java Spring framework.
	b. Front-end - Single Page Application using Angular.
------------------------------------------------------------------------------------------------------------------------

Project architectural points:

	Points regarding the development phase:

i. Modularise :

	For the time being I have modularise the project on package level.
	Later we can also modularise in maven modules.

------------------------------------------------------------------------------------------------------------------------
ii. DTO :

	It stands for Data Transfer Object.
	In this project DTO are used to send as response object from rest controller.

------------------------------------------------------------------------------------------------------------------------
iii. RESTful API design :

	Backend consists following restful apis i.e.

	a. /api/v1/transcripts - used for basic search api with request params as symbol, position and AminoAcidLetter
	b. /api/v1/transcripts/hgvs - used for HGSV notation string.

------------------------------------------------------------------------------------------------------------------------
iv. Exception Handler via Aspect :

	Added aspect for exception handling at rest layer and send appropriate http status and error messages.

------------------------------------------------------------------------------------------------------------------------
v. Plugins used :

	Lombok : https://projectlombok.org/

------------------------------------------------------------------------------------------------------------------------
vi. Unit tests:

	Unit test written using spring boot test context and only exception thrown use cases.

------------------------------------------------------------------------------------------------------------------------
vii. Front-end :

	Single page application : Used Angular. Directory the source files are src/main/resources/frontend
	For the time being, all the source code is in same project later we can have different project for frontend.

	we can also run the frontend on any server, for development I have configured backend to accept all the request from localhost:4200 where the frontend was running while I code.

------------------------------------------------------------------------------------------------------------------------
viii. Documentation for RESTful apis:

	Swagger : http://swagger.io/
	I’ve added swagger framework for testing the apis.
	you can find it http://localhost:8080/swagger or http://localhost:8080/swagger-ui.html

------------------------------------------------------------------------------------------------------------------------
ix. Comments :

	Entire code styling is influenced by Clean Code principle - Robert Martin
	Which says
	'Truth can only be found in one place: the code’.
	So you may not found any comments anywhere in the project.
	Keeping in mind that git can be used to manage version of file and method name should be kept as self explanatory.

	However, if you need comments on each file. I can do that too.

------------------------------------------------------------------------------------------------------------------------
x. Design principles used in Project :

	a. SOLID (single responsibility, open-closed, Liskov subsitution, interface segragation, dependency inversion) principle,
	b. Composition over inheritance,
	c. DRY(Don’t repeat yourself),
	d. Test only exceptions,
	e. KISS(Keep it simple, stupid)
	f. and some experience principle ;)

------------------------------------------------------------------------------------------------------------------------
xi. Area of improvements :

	a. Angular :
	There are lot of stuffs which we can add auth gaurd(as of now, no user is in system so no authentication or authorization is required to access transcript page),
	and spinner component can be added.

	b.REST uri :
	HGSV can reform and input hgsv string can be kept in path variable like : /api/v1/transcript/hgsv/{hgsvNotation}

	Note : here input url is passed by request param which can be passed by path variable too.
	Keeping in mind if we pass hgsvNotation string (contains '.') in path variable then it needs extra care (that hgsvNotation need to send encoded ).
	Hence, so removing extra overheads for the time being I have chosen hgsvNotation as request param.

------------------------------------------------------------------------------------------------------------------------
Testing (automation) and Test cases with TDD approach:

	a. I have written only exception thrown unit test case we can also write the positive test cases in future.

	b. E2E test can be written for automate the testing in Angular using protactor.

	c. We can also write Chakram test for testing RESTful API's.

	d. Right now, all the unit cases is check at the time of build the project but once the project is has team, we can also setup jenkins server and I can configure it to check stability of project reqularly with any version control.
