package ru.brazhnikov.enterprise.jms.definition;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.jms.JMSDestinationDefinition;

@Startup
@Singleton
@JMSDestinationDefinition(
        name = "java:/queue/simple-queue",
        interfaceName = "javax.jms.Queue",
        description = "simple"
)
public class SimpleQueueDefinition {

}
