package com.example.socialmediaapp.repository.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Table(name="users")
@Entity(name = "user")
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Password cannot be empty.")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Password cannot be empty.")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Username cannot be empty.")
    @Column(name = "user_name", unique = true)
    private String userName;

    @NotBlank(message = "Email cannot be empty.")
    @Email(message = "Email must be a valid email address.")
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank(message = "Password cannot be empty.")
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "author")
    @JsonManagedReference
    private List<Post> posts;
}
