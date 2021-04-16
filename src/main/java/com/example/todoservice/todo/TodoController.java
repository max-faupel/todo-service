package com.example.todoservice.todo;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Todo> saveTodo(@PathVariable String username, @RequestBody Todo todo) {
        Todo createdTodo = todoService.save(username, todo);
        // URI uri =
        // ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return ResponseEntity.ok().body(createdTodo);
    }

    @PutMapping(("/users/{username}/todos/{id}"))
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable Long id,
            @RequestBody Todo todo) {
        Todo updatedTodo = todoService.save(id, username, todo);
        return ResponseEntity.ok().body(updatedTodo);
    }
}
