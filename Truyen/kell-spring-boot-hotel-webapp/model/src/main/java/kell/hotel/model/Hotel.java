package kell.hotel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity

public class Hotel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private int star;
    private String des;
    private String address;
    private String eval;
}
