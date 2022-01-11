<h1>Login API</h1>
<h2>Kyros internship challenge</h2>

#### It is a simple login application wich generate a JWT Token to validade the session and enable the access to the others endpoints.

## How to configure the project:

Once you clone the repository, make sure that dependencies will be correctly installed. Follow the steps bellow:

1. Open the project
2. Open MAVEN: Lifecycle -> select "clean" and "install" -> RUN 

+ Create a directory in src/main/resources named "db" <br><br>

First of all you need to insert in database the user data to sign in, this application contains and embedded database.<br>
+ Path: http://localhost:8080/h2-console

#### If you go access the H2 Database:
- Make sure that the JDBC URL path is "jdbc:h2:file:./src/main/resources/db/data"
- UserName: "sa"
- Password: ""<br><br>

## LOGIN 
+ Path: http://localhost:8080/login<br>

Enter with the user data previously inserted in database<br><br>
JSON format example:<br>
```
{
"email":"example",
"password":"example"
}
```
In the reponse body you will receive a JWT Token that expires in 10 minutes, after that you need to login again (save this token).<br>

With this token you grant access to:<br>
+ http://localhost:8080/users/data<br>
+ http://localhost:8080/users/save<br><br>

## NOTES 
Next you will have access to the paths mentioned, follow this steps to fill the requested fields, otherwise you will receibe an HTTP Status 403 - Forbidden:<br>
In the REQUEST HEADER<br>
KEY: "Authorization", Value: "Bearer " (with an space at the final) + tokenValue (saved previously)<br><br>

## SAVE
+ Path: http://localhost:8080/users/save<br>
In this path you can register users correctly, once the fields are validated the password are encrypted using Bcrypt Hash, you can confirm in the H2 database.<br><br>

## DATA
+ Path: http://localhost:8080/users/data<br>
You will receive a message with the decrypted token in the response body.<br><br>

## Technologies used:

- Language: Java 8
- Frameworks: Lombok, Spring Boot, Spring Data JPA, Spring WEB, Spring Security;
- H2 embedded data base.<br><br>
