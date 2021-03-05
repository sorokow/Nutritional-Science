package com.example.Nutritional_Science.Entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false)
    private long userId;

    @NotBlank
    private String login;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String password;

    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(columnDefinition = "userParameters_Id")
    private UserParameters userParameters;

    public User() {
    }
}
