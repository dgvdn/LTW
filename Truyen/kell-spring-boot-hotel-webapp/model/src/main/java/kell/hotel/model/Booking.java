package kell.hotel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private boolean payment1; //cash
    private boolean payment2; //transfer
    private String special_Requirements;
}
