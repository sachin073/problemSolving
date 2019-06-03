package sysDesign.CalendarApplication.IO;

import sysDesign.CalendarApplication.StartApp;
import sysDesign.CalendarApplication.Util.SimpleLogger;
import sysDesign.CalendarApplication.model.AbstractEvent;
import sysDesign.CalendarApplication.model.Event;
import sysDesign.CalendarApplication.model.User;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

/**
 * Created by sachin on 22/5/19.
 *
 *
 * handle Io related work
 *
 * Input Pattern
 * StartDateTime endDateTime Location Owner user-list title
 *
 */
public class IoHandler {


    static BufferedReader reader = null;

    final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    public IoHandler(){

        try {
            reader = new BufferedReader(
                        new InputStreamReader(
                            new FileInputStream("/src/input.in")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

     String readLine() throws IOException{
        return reader.readLine();
    }

    //Add_Event | 23/05/2019 05:00:00 | 24/05/2019 05:45:00 | Delhi | Sachin | John,Jen | Team-Meetup
    public AbstractEvent readEvent(String eventDetails){
        String[] details = eventDetails.split("|");
        AbstractEvent event = new AbstractEvent();

        try {
            event.setStart(format.parse(details[1].trim()));
            event.setEnd(format.parse(details[2].trim()));
        } catch (ParseException e) {
            SimpleLogger.error(this.getClass().getName(),null," exception parsing dates");
            e.printStackTrace();
        }
            event.setLocation(details[3]);

        User user = StartApp.userHolder.get(details[4]);

        if (user ==null){
            user= new User(details[4]);
            StartApp.userHolder.put(details[4],user);
        }

        event.setOwner(user);
        List<User> guestList = event.getGuests();

        String[] userList = details[5].split(",");
        for (String user1:userList) {
            user = StartApp.userHolder.get(user1);

            if (user ==null){
                user= new User(user1);
                StartApp.userHolder.put(details[4],user);
            }

            guestList.add(user);
        }

        event.setTite(details[6]);

        return event;
    }


    public String[] readUpdate(String eventDetails){
        String[] details = eventDetails.split("|");

        return new String[]{details[1],details[2]};
    }


    public Object[] readAceptanceRejection(String eventDetails){
        String[] details = eventDetails.split("|");
        return new Object[]{details[1],StartApp.userHolder.get(details[2])};
    }

    public String readDeleteEvent(String eventDetails){
        String[] details = eventDetails.split("|");
        return details[1];
    }

}
