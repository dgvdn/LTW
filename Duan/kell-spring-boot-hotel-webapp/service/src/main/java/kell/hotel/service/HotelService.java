package kell.hotel.service;

import kell.hotel.model.Hotel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    List<Hotel> findAll();

    Hotel save(Hotel hotel, MultipartFile image);

    void deleteById(Long id);

    Hotel update(Hotel hotel, MultipartFile image);

    Optional<Hotel> findById(Long id);
}
