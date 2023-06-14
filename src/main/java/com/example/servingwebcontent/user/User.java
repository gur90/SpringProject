package com.example.servingwebcontent.user;

import javax.management.relation.Role;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "account")
public class User {
    public enum Role{
        ADMIN, USER
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;

    private String username;
    private String hashPassword;
    @Enumerated(value = EnumType.STRING)
    private Role role;
}
