package kell.hotel.repository;

import kell.hotel.model.Client;
import kell.hotel.model.Hotelier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelierRepository extends JpaRepository<Hotelier, Long> {
    Hotelier findByEmail(String email);
}
