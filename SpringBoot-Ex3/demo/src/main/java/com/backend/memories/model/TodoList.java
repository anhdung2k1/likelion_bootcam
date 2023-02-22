package com.backend.memories.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoList {
    public TodoList(String title,String detail){
        this.title = title;
        this.detail = detail;
    }
    private String title;
    private String detail;
}
