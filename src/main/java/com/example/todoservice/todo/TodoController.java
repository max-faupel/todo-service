package com.example.todoservice.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> getTodos(@PathVariable String username) {
        return todoService.findByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> getTodos(@PathVariable String username, @PathVariable Long id) {
        Optional<Todo> todo = todoService.findById(id);
        if (todo.isPresent()) {
            return ResponseEntity.ok().body(todo.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(("/users/{username}/todos/{id}"))
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable Long id) {
        if (todoService.deleteTodoById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
