package com.example.todoservice.todo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    List<Todo> findByUsername(String username);

    Todo findByIdAndUsername(Long id, String username);

}
