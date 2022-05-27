package kell.hotel.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private String type;
    private String style;
    private String des;
    private String purl;
    private float area;
    private int quantity;
//    @NonNull
    private int idHotel;
//    @ManyToMany(targetEntity=Service.class)
//    private List<Service> services;
//diện tích,  giá phòng theo đêm, .... dịch vụ tiện ích

}
