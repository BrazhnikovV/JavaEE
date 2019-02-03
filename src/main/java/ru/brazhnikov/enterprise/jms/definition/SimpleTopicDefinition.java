package ru.brazhnikov.enterprise.jms.definition;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.jms.JMSDestinationDefinition;

@Startup
@Singleton
@JMSDestinationDefinition(
        name = "java:/topic/simple-topic",
        interfaceName = "javax.jms.Topic",
        destinationName = "simple-topic"
)
public class SimpleTopicDefinition {
}
