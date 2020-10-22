
package mz.co.scn.inventory.jmsmessage;

import java.net.URI;
import java.net.URISyntaxException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

/**
 *
 * @author Sidónio Goenha on Sep 8, 2020
 *
 */ 
public class JmsMessageAsynchronousQueueExample {
	
	public static void main (String[] args) throws URISyntaxException, Exception {
		BrokerService broker = BrokerFactory.createBroker(new URI("broker:(tcp://localhost:4850)"));
		broker.start();
		
		Connection connection = null;
		
		try {
			// Producer
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:4850");
			connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue("customerQueue");
			String payload = "Sidy's Message";
			Message msg = session.createTextMessage(payload);
			MessageProducer producer = session.createProducer(queue);
			
			System.out.println("Sending text '" + payload + "'");
			producer.send(msg);
			
			// Consumer
			MessageConsumer consumer = session.createConsumer(queue);
			consumer.setMessageListener(new ConsumerMessageListener("Consumer"));
			connection.start();
			Thread.sleep(1000);
			session.close();
		} finally {
			if (connection != null) {
				connection.close();
			}
			broker.stop();
		}
	}

}
