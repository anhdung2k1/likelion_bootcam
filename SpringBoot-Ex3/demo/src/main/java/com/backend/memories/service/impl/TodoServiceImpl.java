package com.backend.memories.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.memories.model.TodoList;
import com.backend.memories.repository.TodoRepository;
import com.backend.memories.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {
    private TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    @Override
    public void init(){
        todoRepository.initTodo();
    }

    @Override
    public List<TodoList> getTodoList() {
        return todoRepository.getAllTodoList();
    }

    @Override
    public TodoList createNewTodo(TodoList todo) {
        return todoRepository.createTodo(todo);
    }
}
