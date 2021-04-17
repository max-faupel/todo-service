package com.example.todoservice.todo;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Transactional(readOnly = true)
    public List<Todo> findByUsername(String username) {
        return Collections.unmodifiableList(todoRepository.findByUsername(username));
    }

    @Transactional(readOnly = true)
    public Optional<Todo> find(Long id, String username) {
        return Optional.ofNullable(todoRepository.findByIdAndUsername(id, username));
    }

    @Transactional
    public boolean delete(Long id, String username) {
        Optional<Todo> todoToDelete = Optional.ofNullable(todoRepository.findByIdAndUsername(id, username));

        if (todoToDelete.isPresent()) {
            todoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public Todo save(String username, Todo todo) {
        todo.setUsername(username);
        return todoRepository.save(todo);
    }

    @Transactional
    public Optional<Todo> save(Long id, String username, Todo todo) {
        Optional<Todo> todoToUpdate = find(id, username);

        if (todoToUpdate.isPresent()) {
            // TODO: use mapper
            todoToUpdate.get().setDescription(todo.getDescription());
            todoToUpdate.get().setTargetDate(todo.getTargetDate());
            todoToUpdate.get().setDone(todo.isDone());
            return Optional.of(todoRepository.save(todoToUpdate.get()));
        }

        return Optional.empty();
    }
}
