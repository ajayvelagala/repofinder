# repofinder
SOFTWARES AND TECHNOLOGIES USED
--------------------------------
1)	The app has been designed using spring boot 2.0.3-RELEASE
2)	h2 database has been used so that running the database becomes simple
3)	Spring JDBC has been used to insert and search the records
4)	Spring MVC has been used as an MVC framework
5)	For the view JSP has been used 
6)	CSS Bootstrap 4 has been used for the styles
7)	Spring rest templates are used to make the rest call 
8)	All unit tests have been done using Mockito framework

WORKING
------------------
1)	The app contains 3 users with usernames (user1, user2 and user3) and 1 admin(admin). The password of all users is as same as the username.
2)	When logged with any one of the users, a screen appears to search with either language or topic. When searched with language or topic the back-end rest template fires the rest template and get the desired response
3)	Data tables shows the desired out in pagination. Now the user can click on any one of the clone URLs.
4)	When the user logs as an admin. He will be able to see the search results of remaining users. The Admin can click on the results.

 APP INFO
 ----------
1)	After downloading the app from git, clean and install using maven.
2)	Since the app is designed using spring boot, run GitRepoFinderInitializer.java app to start the application.
3)	The app runs on tomcat with port no: 8082 and this can be changed in application.properties file by changing server.port
4)	When the app successfully runs, go to browser and type http://localhost:8082/login . You should be able to see a screen asking you to login
5)	Since h2 data base is an embedded database, it can be accessed using http://localhost:8082/h2/ . No password is required to authenticate
6)	The table schema is created by default when the application runs. Every time the table schema is dropped and created when the tomcat restarts

COMPROMISES/SHORTCUTS
--------------------
1)	Test cases have been coded in Mockito since I do not have enough experience on Kotlin.
2)	Restricted the app to 2 pages of search only since multiple hits on git is giving an error “403 rate limit exceeded”.
3)	JDBC template has been used instead of JPA due to time constraint.
4)	Normal user authentication is used (hard coded) instead of spring security.
5)	The app styles and designing can be better but could not do it because of time constraint.

 












