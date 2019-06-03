package sysDesign.CalendarApplication.model;

/**
 * Created by sachin on 22/5/19.
 */
public interface Event {
     enum eventTriggers{
        Add_Event,
        Delete_Event,
        Reject_Event,
        Accept_Event,
        Find_Free_time
    }

    void addevent(AbstractEvent event);

    public void deleteEvent(String eventName);

    void update(AbstractEvent oldEvent,AbstractEvent newEvent);

}
