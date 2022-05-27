package kell.hotel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class BookedRoom {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int idRoom;
    private Date ci;
    private Date co;
    private float  price;
    private float saleoff;
    private String name;
    private String type;
    private String style;
    private String des;
    private String purl;
    private float area;
    private int quantity;
    private int idHotel;
}
