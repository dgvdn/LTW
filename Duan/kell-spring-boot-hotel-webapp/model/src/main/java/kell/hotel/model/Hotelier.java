package kell.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Hotelier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotelier_id")
    private Long id;
    private String fullName;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "hotelier_roles", joinColumns = @JoinColumn(name = "hotelier_id", referencedColumnName = "hotelier_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Collection<Role> roles;

}
