package com.todo.Todo_application.controller;

import com.todo.Todo_application.entity.ToDo;
import com.todo.Todo_application.entity.User;
import com.todo.Todo_application.service.ToDoService;
import com.todo.Todo_application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/todo")
public class ToDoController {
    private final ToDoService toDoService;
    private final UserService userService;

    @GetMapping("/todos/home")
    public ResponseEntity<List<ToDo>> getTodo(){
        return toDoService.findAll();
    }

    @PostMapping("/create_todo")
    public ResponseEntity saveTodo(@RequestParam String title, @RequestParam  String priority){
        return  toDoService.save(title, priority);
    }

    @DeleteMapping("/delete_todo")
    public ResponseEntity deleteTodo(@RequestParam Integer id){
        return toDoService.delete(id);
    }

    @PostMapping("/admin/create_user")
    public ResponseEntity saveUser(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/admin")
    public ResponseEntity getUser(){
        return userService.findAll();
    }
}
