package com.todo.Todo_application.service;

import com.todo.Todo_application.entity.User;
import com.todo.Todo_application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    @Transactional
    public ResponseEntity save(User user) {
        if(repository.findByEmail(user.getEmail()).isPresent()){
            return new ResponseEntity("Email is already in use", HttpStatus.BAD_REQUEST);
        }
//        return ResponseEntity.ok(repository.save(user));
        return new ResponseEntity(repository.save(user), HttpStatus.OK);
    }


    public ResponseEntity findAll() {
        return ResponseEntity.ok(repository.findAll());
    }
}
