package ru.brazhnikov.enterprise.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import ru.brazhnikov.enterprise.event.AsyncEvent;
import ru.brazhnikov.enterprise.event.SyncEvent;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import java.util.logging.Logger;

@Named
@RequestScoped
@URLMapping(id = "event", pattern = "/event", viewId = "/WEB-INF/faces/event.xhtml")
public class EventController {

    private static final Logger LOGGER = Logger.getLogger( EventController.class.getSimpleName() );

    @Inject
    private Event<AsyncEvent> asyncEvent;

    @Inject
    private Event<SyncEvent> syncEvent;

    @Inject
    private JMSContext context;

    @Resource( lookup = "java:/queue/simple-queue")
    private Queue queue;

    @Resource( lookup = "java:/topic/simple-topic")
    private Topic topic;

    public void fireAsyncEvent () {
        this.showMessage( "Fire fireAsyncEvent" );
        LOGGER.info( "fireAsyncEvent: " +  + Thread.currentThread().getId() );
        this.asyncEvent.fire( new AsyncEvent( "121212" ) );
    }

    public void fireSyncEvent () {
        this.showMessage( "Fire fireSyncEvent" );
        LOGGER.info( "fireSyncEvent: " +  + Thread.currentThread().getId() );
        this.syncEvent.fire( new SyncEvent() );
    }

    public void fireQueue () {
        LOGGER.info( "fireQueue: " +  + Thread.currentThread().getId() );
        this.context.createProducer().send( queue, "fireQueue" );
        this.showMessage( "Fire JMS Queue Event" );
    }

    public void fireTopic () {
        LOGGER.info( "fireTopic: " +  + Thread.currentThread().getId() );
        this.context.createProducer().send( topic, "fireTopic" );
        this.showMessage( "Fire JMS Topic Event" );
    }

    private void showMessage ( String msg ) {
        final String detail = Long.toString( Thread.currentThread().getId() );
        final FacesContext facesContext = FacesContext.getCurrentInstance();
        final FacesMessage facesMessage = new FacesMessage( msg );
        facesContext.addMessage( null, facesMessage );
    }
}
