package kell.hotel.service;

import kell.hotel.model.Hotel;
import kell.hotel.model.Room;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<Room> findAll();

    Room save(Room room, MultipartFile imageRoom);

    void deleteById(Long id);

    Room update(Room room, MultipartFile imageRoom);

    List<Room> getRoomsByHotelId(Long id);

    Optional<Room> findById(Long id);

    void deleteRoomsByHotelId(Long id);
}
