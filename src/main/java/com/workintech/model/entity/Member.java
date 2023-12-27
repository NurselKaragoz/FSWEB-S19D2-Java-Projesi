package com.workintech.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "role",schema = "workintech")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long  id;
    @Column(name = "email")
  private String email;
    @Column(name = "password")
  private String password;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "member_role", schema = "workintech",joinColumns = @JoinColumn(name = "member_id"),
    inverseJoinColumns = @JoinColumn(name ="role_id" ))
    private List<Role> roles;
}
