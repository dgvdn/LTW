package kell.hotel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int role;
    private String name;
    private String idCard;
    // ten dang nhap = phone
    private String phone;
    private String address;
}
