package exercise.android.reemh.todo_items;

import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: implement!
public class TodoItemsHolderImpl implements TodoItemsHolder {
    List<TodoItem> all_items;
//  List<TodoItem> done_items;
//  List<TodoItem> progress_items;

  TodoItemsHolderImpl()
  {
    all_items = new ArrayList<TodoItem>();
//    done_items = new ArrayList<TodoItem>();
//    progress_items = new ArrayList<TodoItem>();
  }
  TodoItemsHolderImpl(View view)
  {
    all_items = new ArrayList<TodoItem>();

//    done_items = new ArrayList<TodoItem>();
//    progress_items = new ArrayList<TodoItem>();
  }
  @Override
  public List<TodoItem> getCurrentItems() {//todo edit the logic of the lists
//    List<TodoItem> newList = new ArrayList<>(progress_items.size() + done_items.size());
//    newList.addAll(progress_items);
//    newList.addAll(done_items);
//    return newList
    return all_items;
  }

  @RequiresApi(api = Build.VERSION_CODES.O)
  @Override
  public void addNewInProgressItem(String description) {
    all_items.add(new TodoItem(description))
//    progress_items.add(new TodoItem(description))
    ;}

  @Override
  public void markItemDone(TodoItem item) {
    String curstate = item.getState();
    if (curstate.equals("In progress"))
    {
//      progress_items.remove(item);
//      done_items.add(item);
      item.switch_state();
    }
  }

  @Override
  public void markItemInProgress(TodoItem item) {
    String curstate = item.getState();
    if (curstate.equals("Done"))
    {
//    progress_items.add(item);
//    done_items.remove(item);
    item.switch_state();
    }
    }

  @Override
  public void deleteItem(TodoItem item) {
    String curstate = item.getState();
    all_items.remove(item);
//    if (curstate.equals("Done"))
//    {
//      done_items.remove(item);
//    }
//    else if (curstate.equals("In progress")) {
//      progress_items.remove(item);
//    }
  }
}
