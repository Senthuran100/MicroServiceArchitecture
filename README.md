# MicroServiceArchitecture
Using Spring boot with Spring Cloud to build a MicroServiceArchitecture

In this project ZUUL and Eureka are used for Dynamic routing and service discovery.
Restaurant Service and Order Service are registered in the Eureka server. 

- Zuul Gateway - Zuul Gateway acts as the front entrance for the http request. Once the client fires a request
with the zuul proxy url it will route the specific request to the correct microservice.

- Eureka Service - It will act as a directory and keep all the microservices details.

- Restaurant Service - It is used for finding the restaurants and the items that are offered in the restaurant. Also we can add new restaurant entries to the Restaurant service. 

- Order service - It is used to order item from the restaurant and track the orders.

Please refer the below diagram for more information.

<img src="https://github.com/Senthuran100/MicroServiceArchitecture/blob/master/images/ZUUL_Eureka.jpeg"/>

Please refer the postman request of how we are calling the microservice. Here we have used ZUUL proxy(http://localhost:8079) to fire the request. 
<img src="https://github.com/Senthuran100/MicroServiceArchitecture/blob/master/images/Screen%20Shot%202020-08-08%20at%204.38.00%20PM.png"/>
<img src="https://github.com/Senthuran100/MicroServiceArchitecture/blob/master/images/Screen%20Shot%202020-08-08%20at%204.38.20%20PM.png"/>