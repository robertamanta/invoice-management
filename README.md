# Invoice management REST API


## Quick start - invoice-management-backend

#### 1. Create a MySQL database

```
CREATE DATABASE invoice_management;
```
In case you want to use a different database name, follow the next steps:
 -  ```
    CREATE DATABASE DB_NAME;
    ```
 - Open ```src/main/resources/application.properties``` file
 - Change ``spring.datasource.url```  property to match your preferred database name: jdbc:mysql://localhost:3306/DB_NAME 

#### 2. Modify MySQL username and password

- Open ```src/main/resources/application.properties``` file
- Change ```spring.datasource.username``` and ```spring.datasource.password``` properties to match your MySQL connection

### 3. Build project

Build the application using the following **maven wrapper** command:
```
./mvnw clean package
```
In case you want to use this project as a dependency in other
projects locally, use the following command:
```
./mvnw clean install
```
Each of these commands will create an executable ```.jar``` file at ```target``` directory.

### 4. Run project

You can start the server by running the following command:
```
./mvnw spring-boot:run
```
The server will start running at http://localhost:8080.

## Built With 
1. Backend technologies:
   - Java 17
   - Spring Boot
   - JPA and Hibernate
   - MySQL
2. Front-end technologies: 
   - React.js
   - Axios
