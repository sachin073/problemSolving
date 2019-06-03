package sysDesign.CalendarApplication.Util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

/**
 * Created by sachin on 22/5/19.
 */
public class SimpleLogger {


    static Logger logger = null;

    public SimpleLogger(){

        try {
            FileHandler logFileHandler = new FileHandler("src/sysDesign/CalendarApplication/Logs/logs.out",true);
            logger = Logger.getLogger("calAppLogger");
            logger.addHandler(logFileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void info(String fileName,Object masterObject,String message){
        if (logger!=null)
            logger.info(fileName+": "+masterObject+" :"+message);
    }

    public static void error(String fileName,Object masterObject,String message){
        if (logger!=null)
            logger.severe(fileName+": "+masterObject+" :"+message);
    }




}
