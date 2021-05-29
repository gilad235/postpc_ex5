package exercise.android.reemh.todo_items;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;

// TODO: implement!
public class TodoItemsHolderImpl implements TodoItemsHolder {
    List<TodoItem> all_items;

  private final Context context;
  private final SharedPreferences sp;
  private final MutableLiveData<List<TodoItem>> MutableLiveDataTodo = new MutableLiveData<>();
  public final LiveData<List<TodoItem>> LiveDataTodo = MutableLiveDataTodo;


  TodoItemsHolderImpl(Context context)
  {
    this.context = context;
    this.sp = context.getSharedPreferences("local_db_todo",context.MODE_PRIVATE);
    all_items = new ArrayList<TodoItem>();
  }
  @RequiresApi(api = Build.VERSION_CODES.O)
  private void initialed_from_sp() throws ParseException {
    Set<String> keys = sp.getAll().keySet();
    for (String key: keys){
      String TodoSavedInstance = sp.getString(key,null);
      TodoItem todoItem = new TodoItem(TodoSavedInstance);
      if (todoItem!=null){
        all_items.add(todoItem);
      }
    }

  }

  public ArrayList<TodoItem> getCopies(){
    return new ArrayList<>(all_items);
  }
  public @Nullable TodoItem getByID(String id){
    if (id==null){return null;}
      for (TodoItem todoItem:all_items){
        if (todoItem.getId().equals(id)){
          return todoItem;
        }
      }
    return null;
  }

  @Override
  public List<TodoItem> getCurrentItems() {//todo edit the logic of the lists

    return all_items;
  }

  @RequiresApi(api = Build.VERSION_CODES.O)
  @Override
  public void addNewInProgressItem(String description) {
    all_items.add(new TodoItem(description,UUID.randomUUID().toString()))
    ;}

  @Override
  public void markItemDone(TodoItem item) {
    String curstate = item.getState();
    if (curstate.equals("In progress"))
    {

      item.switch_state();
    }
  }

  @Override
  public void markItemInProgress(TodoItem item) {
    String curstate = item.getState();
    if (curstate.equals("Done"))
    {
    item.switch_state();
    }
    }

  @Override
  public void deleteItem(TodoItem item) {
    String curstate = item.getState();
    all_items.remove(item);

  }
  public void edit(String id, String desc){
    TodoItem item = getByID(id);
    if (item!=null){
      item.setDesc(desc);
    }
  }
}
