package ru.brazhnikov.enterprise.listener;

import ru.brazhnikov.enterprise.event.SyncEvent;

import javax.enterprise.event.Observes;
import java.util.logging.Logger;

public class SyncListener {

    private static final Logger LOGGER = Logger.getLogger( SyncListener.class.getSimpleName() );

    public void observe( @Observes SyncEvent event ) {
        LOGGER.info( "[ASYNC] OBSERVE TREAD ID: " + Thread.currentThread().getId() );
    }
}
