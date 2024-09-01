# RabbitMQ Demo

### Purpose
Assume we have an E-commerce application that is normally dealing with 5000 orders per day and all the systems 
are suited for that when the user confirms the order certain steps run like:
* 1- communicate with inventory management to reserve the order quantity.
* 2- send user email for confirmation
* 3- confirm with a payment processor that the payment is successful
* 4- notifying the delivery and dispatching to prepare the order

each of the previous steps runs synchronously and takes around 10 seconds to complete.
The system operates fine on a normal basis.
But when black Friday comes instead of 5000 orders per day it can go up to 100,000 per day and the system can't handle
all these requests because it takes so long to process a single request.

For further reference, please consider the following sections:

### Solution:
We need to get rid of all the unnecessary synchronous calls and replace them with asynchronous messages that don't need
the user to wait for the response.
so for the previous steps, we actually can tell the user that the order is created and will be confirmed
then we can send messages to the different services that we need to communicate with asynchronously 
and update the order according to the status of each of them.
This will allow us to process requests rapidly and remove unwanted delays and dependency to make our system loosely coupled.

You can find the full article about this in my article here 
[What is RabbitMQ and how to use it with Spring Boot 3](https://rashmelonjr.medium.com/what-is-rabbitmq-and-how-to-use-it-with-spring-boot-3-9e9cf90e2e20)


### Resources and Credit
* All thanks to [Niyazi Erdoğan](https://www.linkedin.com/in/niyazi-erdogan/) for his great [course](https://www.oreilly.com/videos/learn-rabbitmq-asynchronous/9781838646189/) on O’Reilly
* [Messaging with RabbitMQ](https://spring.io/guides/gs/messaging-rabbitmq)
