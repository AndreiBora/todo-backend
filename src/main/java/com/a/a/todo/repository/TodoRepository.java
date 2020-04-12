package com.a.a.todo.repository;

import com.a.a.todo.domain.Category;
import com.a.a.todo.domain.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Repository
@Slf4j
public class TodoRepository {

    private List<Todo> todos = new ArrayList<>();

    @PostConstruct
    public void init() {
        List<Todo> lst = Arrays.asList(
                new Todo(UUID.randomUUID().toString(), "Buy milk", "Lorem ipsum dolor sit amet, consectetur adipiscing", Category.SHOPPING, new Date()),
                new Todo(UUID.randomUUID().toString(), "Go to gym", "Lorem ipsum dolor sit amet, consectetur adipiscing", Category.GYM, new Date()),
                new Todo(UUID.randomUUID().toString(), "Eat healthy", "Lorem ipsum dolor sit amet, consectetur adipiscing", Category.FOOD, new Date())
        );
        todos.addAll(lst);
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public Todo saveTodo(Todo todo) {
        todo.setId(UUID.randomUUID().toString());
        todo.setDate(new Date());
        todos.add(todo);
        return todo;
    }

    public Todo updateTodo(String id, Todo updatedTodo) {
        updatedTodo.setId(id);
        updatedTodo.setDate(new Date());
        todos = todos.stream()
                .map(todo -> todo.getId().equals(id) ? updatedTodo : todo)
                .collect(toList());
        return updatedTodo;
    }

    public void deleteTodo(String id) {
         todos = todos.stream()
                .filter(todo -> !todo.getId().equals(id))
                .collect(toList());
    }
}
