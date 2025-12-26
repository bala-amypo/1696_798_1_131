package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.HashSet;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
    name = "app_users",
    uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Builder.Default
@ManyToMany(fetch = FetchType.EAGER)
private Set<Role> roles = new HashSet<>();
 @Transient
    private String role;
    
    @Builder.Default
    private Boolean active = true;
}