package kell.hotel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Evalute {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int star;
    private String content;
}
