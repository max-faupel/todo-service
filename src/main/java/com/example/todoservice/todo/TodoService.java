package com.example.todoservice.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private TodoRepository todoRepository;
    
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    
    public List<Todo> findByUsername(String username) {
        List<Todo> todos = new ArrayList<>();
        todoRepository.findByUsername(username).forEach(todo -> todos.add(todo));
        return todos;
    }
}
