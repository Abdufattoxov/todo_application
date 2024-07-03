package com.todo.Todo_application.service;

import com.todo.Todo_application.entity.ToDo;
import com.todo.Todo_application.enums.ToDoPriority;
import com.todo.Todo_application.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository repository;

    public ResponseEntity<List<ToDo>> findAll() {
        try {
            return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity save(String title, String priority) {
        ToDo toDo = new ToDo();
        toDo.setTitle(title);
        toDo.setPriority(ToDoPriority.valueOf(priority.toUpperCase()));
        toDo.setCreatedAt(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        ToDo save = repository.save(toDo);
        return ResponseEntity.ok(save);
    }

    public ResponseEntity delete(Integer id) {
        repository.deleteById(id);
        return new ResponseEntity("deleted", HttpStatus.OK);
    }
}
