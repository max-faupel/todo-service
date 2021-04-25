package com.example.todoservice;

import java.util.Date;

import com.example.todoservice.todo.Todo;
import com.example.todoservice.todo.TodoService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TodoServiceCommandLineRunner implements CommandLineRunner {
    private TodoService todoService;

    public TodoServiceCommandLineRunner(TodoService todoService) {
        this.todoService = todoService;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("New todo is created: {}", this.todoService.save("max", new Todo("Learn Angular", new Date(), false)));
        log.info("New todo is created: {}", this.todoService.save("max", new Todo("Learn Kafka", new Date(), false)));
        log.info("New todo is created: {}",
                this.todoService.save("max", new Todo("Learn Reactive Programming", new Date(), false)));
    }

}
