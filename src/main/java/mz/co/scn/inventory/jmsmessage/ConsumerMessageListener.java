
package mz.co.scn.inventory.jmsmessage;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Sidónio Goenha on Sep 8, 2020
 *
 */
public class ConsumerMessageListener implements MessageListener {

	private String consumerName;

	public ConsumerMessageListener(String consumerName) {
		this.consumerName = consumerName;
	}

	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			System.out.println(consumerName + " received " + textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
