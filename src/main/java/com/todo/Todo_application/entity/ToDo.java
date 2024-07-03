package com.todo.Todo_application.entity;

import com.todo.Todo_application.enums.ToDoPriority;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.aot.generate.GeneratedTypeReference;
import org.springframework.validation.annotation.Validated;

import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(unique = true)
    private String title;

    @Enumerated(EnumType.STRING)
    private ToDoPriority priority;

    private String createdAt;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
