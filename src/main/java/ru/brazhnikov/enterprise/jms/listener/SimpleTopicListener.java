package ru.brazhnikov.enterprise.jms.listener;

import lombok.SneakyThrows;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;

@MessageDriven(
    activationConfig = {
        @ActivationConfigProperty( propertyName = "destinationLookup", propertyValue = "java:/topic/simple-topic"),
        @ActivationConfigProperty( propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty( propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    }
)
public class SimpleTopicListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        if ( message instanceof TextMessage ) {
            final TextMessage msg = (TextMessage) message;
            System.out.println("JMS: " + Thread.currentThread().getId() );
            try {
                System.out.println("JMS TOPIC: " + msg.getText() );
            }
            catch (JMSException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
