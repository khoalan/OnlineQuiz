package com.example.onlinequiz.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.security.PrivateKey;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    @NotNull
    @Size(min=1,message = "cannot be empty")
    private String userName;

    @Column(nullable = false, length = 64)
    @NotNull
    @Size(min=1,message = "cannot be empty")
    private String userPassword;

    @Column(nullable = false, unique = true, length = 50)
    @NotNull
    @Size(min=1,message = "cannot be empty")
    private String email;
}
