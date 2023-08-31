# appointment_crud

Project dependency:
install jdk (minimum version java8 required)

install maven.

install Mysql database ( follow link- https://dev.mysql.com/doc/)
after successful mysql installation create
### database schema name as 
## "sysvine_portal"
## -----------------------------------------------------------------
### 1. You can clone it from github by running following command
```
  $ git clone https://github.com/elangonfs/appointment_crud.git
```

### 2. Import project into eclipse/IntelliJ
```
  File -> Import -> Maven -> Existing Maven Projects -> Browse Project from cloned location
```
### 3. Right click on project in eclipse/IntelliJ and then Maven -> Update Projects


### 5. Update database credential  into application.properties available in src/main/java/resources

```


spring.datasource.password= your_db_password


```
### 6. Run Application
use mvn clean install then use mvn springboot:run command in terminal 
to build and start application.

## Once Sprint Boot Application will be started successfully then we
can call following Endpoints by using POSTMAN

### 7. To get list of appointments call following endpoint with GET Request
```
 use GET  localhost:8080/appointment/
```
### 8.To Create New appointments use following url with POST Request
```
  use POST  localhost:8080/appointment/
```
### set content type as in header as `application/json`
### set request body as raw with JSON payload
```
 {
    "patientName":"John",
    "doctorName":"Mark",
    "appointmentDate":"2023-09-02",
    "appointmentTime":"15:19:47.459"
}

```
### 9.To get a particular appointment, use following url with `GET` request type in postman
```
  http://localhost:8080/appointment/{id}
```
### 10.To update appointment in database, use following url with `PATCH` request type in postman
```
	http://localhost:8080/appointment/{id}
```
### set content type as in header as `application/json`
### set request body as raw with JSON payload

```
 {
    "patientName":"John",
    "doctorName":"Bob",
    "appointmentDate":"2023-09-02",
    "appointmentTime":"15:19:47.459"
}
```
### 11.To delete a particular appointment from database, use following url with `DELETE` request type in postman
```
  http://localhost:8080/appointment/{id}
```

### Note - Replace {id} with actual id 