package com.backend.memories.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.backend.memories.model.TodoList;

@Repository
public class TodoRepositoryImpl implements TodoRepository{
    private final List<TodoList> todoListsEx = new ArrayList<TodoList>();
    @Override
    public void initTodo(){
        TodoList todo1 = new TodoList("Working","Working Harder");
        TodoList todo2 = new TodoList("Run In Morning","Run at 5.am to 9.am");
        TodoList todo3 = new TodoList("Meeting","Metting scheduled at 10.pm");
        todoListsEx.add(todo1);
        todoListsEx.add(todo2);
        todoListsEx.add(todo3);
    }

    @Override
    public List<TodoList> getAllTodoList() {
        List<TodoList> temp = new ArrayList<TodoList>();
        for(TodoList todolist : todoListsEx){
            temp.add(todolist);
        }
        return temp;
    }

    @Override
    public TodoList createTodo(TodoList todo) {
        todoListsEx.add(todo);
        return todo;
    }
}
