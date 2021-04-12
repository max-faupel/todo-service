package com.example.todoservice.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
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

    public Optional<Todo> findById(Long id) {
        return todoRepository.findById(id);
    }

    public boolean deleteTodoById(Long id) {
        try {
            todoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        return true;
    }
}
