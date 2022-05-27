package kell.hotel.service;

import kell.hotel.model.Client;
import kell.hotel.model.Hotelier;

public interface HotelierService {
    Hotelier findByEmail(String email);

    Hotelier save(Hotelier hotelier);
}
