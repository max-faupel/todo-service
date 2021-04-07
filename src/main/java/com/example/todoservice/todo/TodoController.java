package com.example.todoservice.todo;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "todo")
public class TodoController {
    private TodoService todoService;
    
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    
    @RequestMapping(method = GET)
    public List<Todo> getTodos() {
        return todoService.findAll();
    }
}
