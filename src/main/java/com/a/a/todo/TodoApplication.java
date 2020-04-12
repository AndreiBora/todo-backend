package com.a.a.todo;

import com.a.a.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.a.a.todo.domain.Todo;

import java.util.List;

@SpringBootApplication
public class TodoApplication {
    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }
}

@RestController
@RequestMapping(value = "/v1/todos")
class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public List<Todo> getTodos() {
        return todoRepository.getTodos();
    }

    @PostMapping
    public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo) {
        Todo newTodo = todoRepository.saveTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }

    @PutMapping(value = "/{id}")
    public Todo saveTodo(@PathVariable String id, @RequestBody Todo todo) {
        return todoRepository.updateTodo(id, todo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String id) {
        todoRepository.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }

}
