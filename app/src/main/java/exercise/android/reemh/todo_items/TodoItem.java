package exercise.android.reemh.todo_items;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TodoItem implements Serializable {

    private Instant creation_time;
    private String state; //done to in progress

    String desc;
    @RequiresApi(api = Build.VERSION_CODES.O)
    TodoItem()
    {
        creation_time = Instant.now();
        state = "In progress";
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    TodoItem(String d)
    {
        creation_time = Instant.now();
        state = "In progress";
        desc = d;
    }
    public void switch_state()
    {
        if(state.equals("In progress"))
        {
            state="Done";

        }
        else state="In progress";
    }
    public Instant getCreation_time() {
        return creation_time;
    }

    public String getState() {
        return state;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
  // TODO: edit this class as you want
}
