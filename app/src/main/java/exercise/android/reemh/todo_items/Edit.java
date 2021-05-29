package exercise.android.reemh.todo_items;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;
public class Edit extends AppCompatActivity {
    public static final long MININDAYS = 1440;
    public static final long MININHOURS = 60;



    private TodoItemsHolderImpl db = null;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_item);
        if (db==null){
            db = TodoApplication.getInstance().getDb();
        }
        Intent intentOpen = getIntent();
        String id  = intentOpen.getStringExtra("id");
        TodoItem item = getDb().getByID(id);
        if (item==null){
            finish();
            return;
        }
        TextView editTodoItem_creatonDate = findViewById(R.id.editTodoItem_creatonDate);

        TextView editTodoItem_modifiedDate = findViewById(R.id.editTodoItem_modifiedDate);
        editTodoItem_creatonDate.setText(("creation time :"+item.getCreation_time().getTime().toString()));//todo need to fix the time
//        editTodoItem_modifiedDate.setText(item.getLast_modified().getTime()-Calendar.getInstance().getTime());
        timeDiff(item.getLast_modified(),editTodoItem_modifiedDate);
        EditText editTodoItem_description = findViewById(R.id.editTodoItem_description);
        Button editTodoItem_status = findViewById(R.id.editTodoItem_status);
        editTodoItem_status.setEnabled(false);
        editTodoItem_description.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            public void afterTextChanged(Editable s) {
                // text did change
                String newText = editTodoItem_description.getText().toString();
                // todo: check conditions to decide if button should be enabled/disabled (see spec below)
                editTodoItem_status.setEnabled(true);
//        editText.setText(newText);
//        holder.addNewInProgressItem(newText);
            }
        });
        editTodoItem_status.setOnClickListener(v -> {
//      Intent intentToOpenService = new Intent(MainActivity.this, CalculateRootsService.class);
            String userInputString = editTodoItem_description.getText().toString();
            getDb().edit(id,userInputString);
            finish();
        });
        //todo ui need to work with the todo from the intent
    }

    @Override
    protected void onSaveInstanceState(@NonNull @NotNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
    public TodoItemsHolderImpl getDb() {
        return db;
    }
    public void timeDiff(Calendar last,TextView modify){
        long minutes = (Calendar.getInstance().getTimeInMillis() - last.getTimeInMillis()) / 60000;
        String str = "last modified :";
        if (minutes>MININDAYS){//more than a day
            modify.setText(last.getTime().toString());
        }
        else if (minutes>MININHOURS){//more than an hour and less than a day
            str += ((minutes/60)+" hours");
        }
        //less than an hour
        modify.setText((str+minutes+" minutes"));

    }

}
