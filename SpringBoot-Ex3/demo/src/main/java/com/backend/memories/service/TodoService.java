package com.backend.memories.service;

import java.util.List;

import com.backend.memories.model.TodoList;

public interface TodoService {
    void init();
    List<TodoList> getTodoList();
    TodoList createNewTodo(TodoList todo);
}
