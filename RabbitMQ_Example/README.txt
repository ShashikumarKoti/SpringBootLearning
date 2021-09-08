Run below command in rabbt mq command prompt(from Start menu) to start rabbit-mq
rabbitmq-plugins enable rabbitmq_management


From browser run:
http://localhost:15672

username: guest
password : guest

Understanding:
What is RabbitMQ?
RabbitMq is a message broker. It is a software where queues are defined, to which an application connects inorder to transfer messages.

RabbitMQ implements AMOP(Advanced Message Queuing Protocol)
AMQP provides:
1.Security: authentication, authorization,LDAP via RabbitMQ plugins 
2.Reliability: confirms that the msg was successfully delivered to broker and successfully consumed by Consumer.
3.Interoperability: message is transferred as stream of bytes. So any client can operate on the message irrespective of language


When do we need RabbitMQ?
use case1:  When publisher is written in Java and Consumer in written in JS(or some other language)  i.e, Interoperability
use case2:  When publisher sends msg, but consumer is down
use case3:  One publisher or many consumers(one to many, many to one, many to many etc..)

Architecture(Message flow)
Producer -> Exchange -> Queue -> Consumer

While publishing message to Exchange, the publisher has to send message along with 'Routing Key'
Routing Key: It is used as identifier by Exchange to publish message to appropriate queues.


How it works?
Publisher will send message to Exchange(RabbitMQ) along with Routing Key, the Exchange will push the msg into the queue based on the Routing key. Consumer will consume msgs from queue.
Exchange will decide in which queue the message has to be sent based on the routing key.
Messages will be queue until the consumer consumes the messages.
Consumer has to send the acknowledgement. After receiving the acknowledgement, then only the msg will be deletd from queue.
