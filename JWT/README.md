Programming language used :
  Java

Frameworks used :
 spring-boot web
 spring-boot security
 json-web-token jjwt
 project-lombok lombok

Steps for execution : 
1. mvn clean install
2. Open postman and type url `http://localhost:8080/JWT/get-token` 
    with POST method type 
    and `{ "userName": "Komal", "password": "Komal"}` as request body you will get token.
3. Type url `http://localhost:8080/JWT/say-hello`  
    with GET method type
    and `Authorization` as key and `Token ${Your_token_value}` in header 
    you will get your response.
    
No database works on mock data.
