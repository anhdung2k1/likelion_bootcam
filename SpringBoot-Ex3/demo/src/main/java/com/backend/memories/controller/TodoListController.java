package com.backend.memories.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.memories.model.TodoList;
import com.backend.memories.service.TodoService;

import jakarta.annotation.PostConstruct;

@RestController
public class TodoListController {
    private final TodoService todoService;

    public TodoListController(TodoService todoService) {
        this.todoService = todoService;
    }
    @PostConstruct
    public void init(){
        todoService.init();
        if(todoService.getTodoList() == null)
            todoService.createNewTodo(new TodoList("test", "test"));
    }
    @GetMapping(value = "/")
    public ResponseEntity<List<TodoList>> getAllTodoList(){
        return ResponseEntity.ok().body(todoService.getTodoList());
    }
    @PostMapping(value = "/todo")
    public ResponseEntity<TodoList> addTodo(TodoList todo){
        return ResponseEntity.ok().body(todoService.createNewTodo(todo));
    }
}
