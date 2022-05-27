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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;
    private String fullName;
    private String idCard;
    private String phone;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "client_roles", joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Collection<Role> roles;

}
