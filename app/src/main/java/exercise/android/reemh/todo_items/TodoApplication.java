package exercise.android.reemh.todo_items;

//maybe extend application
public class TodoApplication extends android.app.Application {
    private TodoItemsHolderImpl db = null;
    public TodoItemsHolderImpl getDb(){
        return db;
    }



    private static TodoApplication instance = null;
    public static TodoApplication getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        db = new TodoItemsHolderImpl(this);

//        if (db==null){
//            db = new TodoItemsHolderImpl(this);
//        }
//        db.LiveDataTodo.observe(this, new Observer<List<TodoItem>>() {
//            @Override
//            public void onChanged(List<TodoItem> todoItems) {
//                //todo refresh UI
//
//            }
//        });
    }

}
