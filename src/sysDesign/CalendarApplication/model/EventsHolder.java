package sysDesign.CalendarApplication.model;

import sysDesign.CalendarApplication.Util.SimpleLogger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sachin on 22/5/19.
 */
public class EventsHolder implements Event {

    static Map<String,AbstractEvent> eventMap = new HashMap<>();
    @Override
    public void addevent(AbstractEvent event) {
        eventMap.put(event.getTite(),event);

        SimpleLogger.info(this.getClass().getName(),event," event added");
    }

    @Override
    public void deleteEvent(String eventName) {
        // got user list and delete status of events
        eventMap.remove(eventName);
        SimpleLogger.info(this.getClass().getName(),eventName," event removed");
    }

    @Override
    public void update(AbstractEvent oldEvent, AbstractEvent newEvent) {
        deleteEvent(oldEvent.getTite());
        SimpleLogger.info(this.getClass().getName(),oldEvent," event removed");
        addevent(newEvent);
        SimpleLogger.info(this.getClass().getName(),newEvent," event added");
    }

}
