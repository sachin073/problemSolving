package sysDesign.CalendarApplication.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sachin on 22/5/19.
 */
public class User {

    final String name;

    public User(String name) {
        this.name = name;
    }

    //non existing events are accepted
    Map<String,Boolean> eventStatusHolder=new HashMap<>();

    void RejectEvent(String eventName){
        eventStatusHolder.put(eventName,false);
    }

}
