package kell.hotel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String purl;
    private String name;
    private String room;
}
