<h1>Login API</h1>
<h2>Kyros internship challenge</h2>

### It is a simple login application wich generate a JWT Token to validade the session and enable the access to the others endpoints.

## HOW TO CONFIGURE THE PROJECT:

Once you clone the repository, make sure that dependencies will be correctly installed. Follow the steps bellow:

- Open the project;
- Open MAVEN: Lifecycle -> select "clean" and "install" -> RUN <br><br>

Now you able to start the appliccation, first of all you need to insert in database the data to sign in.

This application contains and embedded database that can be access by http://localhost:8080/h2-console

- Make sure that the JDBC URL path is "jdbc:h2:file:./src/main/resources/db/data"
- UserName: "sa"
- Password: ""

You can add any user in "TB_USUARIOS", just for an example for the first login.

Path: http://localhost:8080/login<br>
Enter with the user data previously inserted in database in json format:<br>
```
{
"email":"example",
"password":"example"
}
```
In the reponse body you will receive a JWT Token that expiress in 10 minutes, after that you need to login again (save this token).

With this token you grant access to:
+ http://localhost:8080/users/data
+ http://localhost:8080/users/save

## Now you need to save correctly the data user.
Go to /users/save and pass the user data in json format again, once the fields are validated, it is inserted on database with the encrypted password.
Now you can login again with an validated user.

## Last endpoint: /users/data

Follow this steps to fill the requested fields:<br>
-REQUEST HEADER<br>
KEY: "Authorization", Value: "Bearer " (with an space at the final) + tokenValue (saved previously)

You will receive a message with the decrypted token in the response body.

## Technologies used:

- Language: Java 8
- Frameworks: Lombok, Spring Boot, Spring Data JPA, Spring WEB, Spring Security;
- H2 embedded data base.







