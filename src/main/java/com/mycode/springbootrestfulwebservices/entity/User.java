package com.mycode.springbootrestfulwebservices.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;


@Column(nullable = false)
private String firstname;

int id2=0;

@Column(nullable = false)
private String lastname;
@Column(nullable = false,unique = true)
private  String email;
}
