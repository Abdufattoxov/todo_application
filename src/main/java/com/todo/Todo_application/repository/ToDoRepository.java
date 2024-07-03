package com.todo.Todo_application.repository;

import com.todo.Todo_application.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.config.RepositoryConfiguration;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

}
