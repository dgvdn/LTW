package kell.hotel.service.impl;

import kell.hotel.model.Client;
import kell.hotel.model.Hotelier;
import kell.hotel.repository.ClientRepository;
import kell.hotel.repository.HotelierRepository;
import kell.hotel.repository.RoleRepository;
import kell.hotel.service.ClientService;
import kell.hotel.service.HotelierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class HotelierServiceImpl implements HotelierService {
    @Autowired
    private HotelierRepository hotelierRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Hotelier findByEmail(String email) {
        return hotelierRepository.findByEmail(email);
    }

    @Override
    public Hotelier save(Hotelier hotelier) {
        Hotelier hotelier1 = new Hotelier();
        hotelier1.setEmail(hotelier.getEmail());
        hotelier1.setFullName(hotelier.getFullName());
        hotelier1.setPassword(hotelier.getPassword());
        hotelier1.setRoles(Arrays.asList(roleRepository.findByName("HOTELIER")));
        return hotelierRepository.save(hotelier1);
    }
}
