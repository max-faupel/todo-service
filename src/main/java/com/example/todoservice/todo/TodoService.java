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

    public Todo findByIdAndUsername(Long id, String username) {
        return todoRepository.findByIdAndUsername(id, username);
    }

    public boolean deleteTodoById(Long id) {
        try {
            todoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        return true;
    }

    public Todo save(String username, Todo todo) {
        return save(Long.valueOf(-1), username, todo);
    }

    public Todo save(Long id, String username, Todo todo) {
        if (id.equals(Long.valueOf(-1))) {
            todo.setUsername(username);
            return todoRepository.save(todo);
        } else {
            Todo todoToUpdate = findByIdAndUsername(id, username);
            // TODO: use mapper
            todoToUpdate.setDescription(todo.getDescription());
            todoToUpdate.setTargetDate(todo.getTargetDate());
            todoToUpdate.setDone(todo.isDone());
            return todoRepository.save(todoToUpdate);
        }
    }
}
