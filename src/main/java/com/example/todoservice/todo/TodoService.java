package com.example.todoservice.todo;

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
        return todoRepository.findByUsername(username);
    }

    @Transactional(readOnly = true)
    public Optional<Todo> findById(Long id) {
        return todoRepository.findById(id);
    }

    @Transactional
    public boolean deleteTodoById(Long id) {
        Optional<Todo> todoToDelete = todoRepository.findById(id);

        if (todoToDelete.isPresent()) {
            todoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public Todo save(String username, Todo todo) {
        return save(Long.valueOf(-1), username, todo);
    }

    @Transactional
    public Todo save(Long id, String username, Todo todo) {
        if (id.equals(Long.valueOf(-1))) {
            todo.setUsername(username);
            return todoRepository.save(todo);
        } else {
            Todo todoToUpdate = todoRepository.findByIdAndUsername(id, username);
            // TODO: use mapper
            todoToUpdate.setDescription(todo.getDescription());
            todoToUpdate.setTargetDate(todo.getTargetDate());
            todoToUpdate.setDone(todo.isDone());
            return todoRepository.save(todoToUpdate);
        }
    }
}
