Title : SpringBoot GraphQL Vehicle crud app.

Introduction : The project's aim is to provide the back end operations for different authorized API calls of vehicle app.

Launch : 6th dec 2019

Project status : completed

Example of use : To retrieve all vehicles from the database.

Size of project : 12.9kb

Platform Used : Ubuntu 16.04

Technologies used : 
a) Java (1.8) 
b) SpringBoot (2.0) 
c) Maven 
d) GraphQl 
g) Database : H2 (In memory database)

Tools used : 
a) STS3 (To develop) 
b) Postman(To test)

To run this project, checkout to repository and execute following commands :
mvn clean install
mvn spring-boot:run

To make api calls you can use postman:
Download postman app and open that and make api call's by
a) Adding proper header(Content-type=Application/json, Auth-Key=(Valid auth key))
b) Selecting proper method (Post)
c) Adding proper body (Query/Mutation)
d) Add proper URL of api call (localhost:8080/graphql)

