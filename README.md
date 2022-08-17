# Library Microservices 
This project demonstrates the usage of API gateway between microservices using spring cloud gateway.


## what is spring cloud gateway ?

<p>Spring Cloud Gateway is an intelligent and programmable router based on Project Reactor.</p>


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
    <td>auth microservice</td>
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

 * Download/Clone the repository : 
   
   ```
   $ git clone https://github.com/run-ry/microservice-sample.git
   $ cd microservice-sample
   $ mvn clean install
   ```

 * To run the application :

	  ```
	 $ docker-compose up
	  ```

#### How to test the application ?

```
$ curl http://localhost:9500/jio/customers

[
    {
        "customerName": "Run",
        "customerAge": 25,
        "customerGender": "MALE"
    }
]
```
