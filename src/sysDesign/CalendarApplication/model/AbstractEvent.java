package sysDesign.CalendarApplication.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by sachin on 22/5/19.
 */
public class AbstractEvent implements Comparable {

    Date start;

    Date end;

    String location;

    String tite;

    User owner;

    List<User> guests = new ArrayList<>();

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTite() {
        return tite;
    }

    public void setTite(String tite) {
        this.tite = tite;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getGuests() {
        return guests;
    }

    public void setGuests(List<User> guests) {
        this.guests = guests;
    }

    @Override
    public int compareTo(Object o) {
        AbstractEvent o2= (AbstractEvent)o;
        if (this.getStart().after(o2.getStart())){
            return 1;
        }else if (this.getStart().before(o2.getStart())){
            return -1;
        }else {
            return 0;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(start,end,location, tite);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractEvent){
            AbstractEvent event =(AbstractEvent) obj;
            return this.start.equals(event.start) && this.location.equals(event.location) && this.tite.equals(event.tite);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Title: "+this.tite+" Location: "+this.location+" Start time: "+start+" End Time: "+end+"\n";
    }
}
