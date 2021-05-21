package exercise.android.reemh.todo_items;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    //    RecyclerView
//    recyclerTodoItemsList
    private TodoItemsHolder todoItemsHolder;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgview;
        TextView textView;
        Button doneButton;
        Button deleteButton;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            imgview=view.findViewById(R.id.item_image);
            imgview.setBackgroundColor(Color.RED);
            textView=view.findViewById(R.id.editTextTodoItem);
            doneButton=view.findViewById(R.id.donebuuton);
            deleteButton=view.findViewById(R.id.deletebootn);
        }
    }

    Adapter(TodoItemsHolder input_items_impl)
    {
        todoItemsHolder=input_items_impl;
    }

    @Override
    public int getItemCount() {
        return todoItemsHolder.getCurrentItems().size();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context contaxt = parent.getContext();
        View view = LayoutInflater.from(contaxt).inflate(R.layout.row_todo_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TodoItem item = todoItemsHolder.getCurrentItems().get(position);
        holder.textView.setText(item.getDesc());
        if (item.getState().equals("DONE"))
        {
//            holder.imgview.setBackground(R.drawable.);
        }
        else if (item.getState().equals("In progress"))
        {
//            holder.imgview.setBackgroundColor(1);
        }
        holder.doneButton.setOnClickListener(v -> {
            holder.doneButton.setEnabled(false);
            holder.imgview.setBackgroundColor(Color.GREEN);//todo change color to green
            todoItemsHolder.markItemDone(item);
        });
        holder.deleteButton.setOnClickListener(v -> {
            todoItemsHolder.deleteItem(item);
            notifyDataSetChanged();
        });


    }
    public TodoItemsHolder getTodoItemsHolder() {
        return todoItemsHolder;
    }

    public void setTodoItemsHolder(TodoItemsHolder todoItemsHolder) {
        this.todoItemsHolder = todoItemsHolder;
    }

}
