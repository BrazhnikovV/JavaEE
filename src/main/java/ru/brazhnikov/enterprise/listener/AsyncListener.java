package ru.brazhnikov.enterprise.listener;

import ru.brazhnikov.enterprise.event.AsyncEvent;
import ru.brazhnikov.enterprise.event.SyncEvent;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import java.util.logging.Logger;

@Stateless
public class AsyncListener {

    private static final Logger LOGGER = Logger.getLogger( AsyncListener.class.getSimpleName() );

    @Asynchronous
    public void observe( @Observes AsyncEvent event ) {
        LOGGER.info( "[ASYNC] OBSERVE TREAD ID: " + Thread.currentThread().getId() );
    }
}
