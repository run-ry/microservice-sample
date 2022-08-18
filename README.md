# Library Microservices 
This project demonstrates the usage of API gateway between microservices using spring cloud gateway.




#### Projects

<table>


 <tr>
    <th style="text-align:left">Name</th>
    <th style="text-align:left">Port</th> 
    <th style="text-align:left">Description</th>
  </tr>
  <tr>
    <td><a href="https://github.com/run-ry/microservice-sample">gateway-server</a></td>
    <td>8087</td>
    <td>spring cloud gateway router</td>
  </tr>
  <tr>
    <td><a href="https://github.com/run-ry/microservice-sample">book-service</a></td>
    <td>8082</td>
    <td>book microservice</td>
  </tr>
  <tr>
    <td><a href="https://github.com/run-ry/microservice-sample">auth-service</a></td>
    <td>8083</td>
    <td>authentication microservice</td>
  </tr>
  <tr>
    <td><a href="https://github.com/run-ry/microservice-sample">user-service</a></td>
    <td>8081</td>
    <td>user microservice</td>
  </tr>
  <tr>
    <td><a href="https://github.com/run-ry/microservice-sample">reservation-service</a></td>
    <td>8087</td>
    <td>reservation microservice</td>
  </tr>
   <tr>
    <td><a href="https://github.com/BarathArivazhagan/spring-cloud-gateway-routing/tree/master/config-server">config-server</a></td>
    <td>8888</td>
    <td>spring cloud config server </td>
  </tr>
     <tr>
    <td><a href="https://github.com/BarathArivazhagan/spring-cloud-gateway-routing/tree/master/eureka-server">eureka-server</a></td>
    <td>8761</td>
    <td>eureka-server </td>
  </tr>
  
</table>


#### How to build and run ?

 * Download/Clone/Run local the repository : 
 * Requirement
   * Java 11
   * Maven 3.8.x
   * Docker & Docker Compose(if deployment to docker)
 
   ```
     $ git clone https://github.com/run-ry/microservice-sample.git
     $ cd microservice-sample
     $ sh ./build-run.sh
     ```

 * To deploy the application  to docker compose:

      ```
     $ docker-compose up
      ```

## How to test the application ?
Each of microservices, can be access vs Swagger UI.

* http://localhost:8081/swagger-ui.html (User Service)
* http://localhost:8082/swagger-ui.html (Book Service)
* http://localhost:8087/swagger-ui.html (Reservation Service)

Moreover, the below sample request can be run from Postman that I have attached collect files to import.
### Sign up
```
curl --location --request POST 'http://localhost:6180/v1/api/signup' \
--header 'Content-Type: application/json' \
--data-raw '{
  "id": 0,
  "userName": "admin",
  "password": "secureP@ssword01",
  "profile": {
    "id": 0,
    "emailid": "ry.run@gmail.com",
    "firstName": "RUN",
    
    "lastName": "RY",
    "mobileNumber": "0967488884",
    "country": "Cambodia",
    "city": "Phnom Penh",
    "pinCode": 1110,
    "state": "PP",
    "street": "1BT"
  },
  "status": true
}'
```
### Login
after login successfully, you will get the TOKEN and this token will be used for next activity
```
curl --location --request POST 'http://localhost:6180/v1/api/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userName": "admin",
    "password": "secureP@ssword01"
}'
```

### Create book
```
curl --location --request POST 'http://localhost:6180/v1/api/books' \
--header 'Authorization: Bearer {{ReplaceTokenHere}}' \
--header 'Content-Type: application/json' \
--data-raw '{
  "id": 0,
  "isActive": true,
  "title": "Khmer Novel",
  "author": "Sovan",
  "category": "Novel",
  "description": "Khmer history book"
}'
```

### View available books
```
curl --location --request GET 'http://localhost:6180/v1/api/books' \
--header 'Authorization: Bearer {{ReplaceTokenHere}}'
```

### Create reservation
```
curl --location --request POST 'http://localhost:6180/v1/api/reservations' \
--header 'Authorization: Bearer {{ReplaceTokenHere}}' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 0,
    "isActive": true,
    "issuedDate": "2022-08-20",
    "returnDate": "2022-08-25",
    "status": "booked",
    "userName": "admin",
    "bookId": 1
}'
```

### View reservations
```
curl --location --request GET 'http://localhost:6180/v1/api/reservations' \
--header 'Authorization: Bearer {{ReplaceTokenHere}}'
```


## Next Improvement Action
* Upgrade spring boot version to latest 
* Response error handling
* Unit test of each micro
* Restrict authentication to individual microservice. Now it supports only request from Gateway
* Add notification (email/sms) microservice
* Deployment with Kubernetes