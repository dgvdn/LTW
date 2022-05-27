package com.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    @Column(unique = true)
    private String email;
    private String idCard;
    private String phone;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="account_role" , joinColumns = @JoinColumn(name="account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "id"))
    private Collection<Role> roles ;
}
