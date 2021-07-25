package reminders.model;

import java.io.Serializable;
import java.util.Calendar;

public class Reminder implements Serializable
{
    private String desc;
    private Calendar alertTime;
    
    public Reminder(String desc) {
        this.desc = desc;
    }

    public Reminder(String desc, Calendar alertTime) {
        this.desc = desc;
        this.alertTime = alertTime;
    }
    
    public String getDesc() {
        return desc;
    }
    
    public Calendar getAlertTime() {
        return alertTime;
    }  
}
