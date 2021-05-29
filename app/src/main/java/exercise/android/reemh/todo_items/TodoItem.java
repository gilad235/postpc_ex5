package exercise.android.reemh.todo_items;

import android.icu.text.SimpleDateFormat;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.text.ParseException;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Calendar;
import java.util.Map;
import java.util.UUID;

public class TodoItem implements Serializable {

    private String state; //done to in progress
    private Calendar last_modified;
    private Calendar creation_time;
    private String id = null;
    String desc;

    @RequiresApi(api = Build.VERSION_CODES.O)
    TodoItem()
    {
        //java.util.Calendar.getTime()
        creation_time = Calendar.getInstance();
        state = "In progress";
        last_modified = creation_time;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    TodoItem(String d) throws ParseException//from tostring
    {
        String[] data = d.split("@",5);
        id = data[0];
        creation_time = stringToCalender(data[1]);
        state = data[2];
        desc = data[3];
        last_modified = stringToCalender(data[4]);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    TodoItem(String d,String id)
    {
        this.id=id;
        creation_time = Calendar.getInstance();
        state = "In progress";
        desc = d;
        last_modified = creation_time;

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public String itemToString(){
        return id+"@"+caletoString(creation_time)+"@"+state+"@"+desc+"@"+caletoString(last_modified);
    }
    public void switch_state()
    {
        if(state.equals("In progress"))
        {
            state="Done";

        }
        else state="In progress";
    }
    public Calendar getCreation_time() {
        return creation_time;
    }

    public String getState() {
        return state;
    }

    public String getDesc() {
        return desc;
    }
    public Calendar getLast_modified() {
        return last_modified;
    }
    public void setLast_modified(Calendar last_modified) {
        this.last_modified = last_modified;
    }
    public String getId() {
        return id;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public String caletoString(Calendar c){
        SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        String strDate = formatter.format(c);
        return strDate;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Calendar stringToCalender(String datestr) throws ParseException {
        SimpleDateFormat formatter5=new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
        Date date=formatter5.parse(datestr);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }
}
