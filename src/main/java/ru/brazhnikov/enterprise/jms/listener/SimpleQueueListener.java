package ru.brazhnikov.enterprise.jms.listener;

import lombok.SneakyThrows;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;

@MessageDriven(
    activationConfig = {
        @ActivationConfigProperty( propertyName = "destinationLookup", propertyValue = "java:/queue/simple-queue"),
        @ActivationConfigProperty( propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty( propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    }
)
public class SimpleQueueListener implements MessageListener {

    @Override
    @SneakyThrows
    public void onMessage(Message message) {
        if ( message instanceof ObjectMessage ) {
            final ObjectMessage msg = (ObjectMessage) message;
            try {
                final Object object = msg.getObject();
            }
            catch (JMSException e) {
                e.printStackTrace();
            }
        }
        if ( message instanceof TextMessage ) {
            final TextMessage msg = (TextMessage) message;
            System.out.println("JMS: " + Thread.currentThread().getId() );
            try {
                System.out.println("JMS QUEUE: " + msg.getText() );
            }
            catch (JMSException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
