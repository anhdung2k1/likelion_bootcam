package com.backend.memories.repository;

import java.util.List;


import com.backend.memories.model.TodoList;

public interface TodoRepository {
    public void initTodo();
    public List<TodoList> getAllTodoList();
    public TodoList createTodo(TodoList todo);
}
