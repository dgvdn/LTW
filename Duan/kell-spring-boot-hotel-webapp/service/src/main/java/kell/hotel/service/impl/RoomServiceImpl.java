package kell.hotel.service.impl;

import kell.hotel.model.Hotel;
import kell.hotel.model.Room;
import kell.hotel.repository.RoomRepository;
import kell.hotel.service.HotelService;
import kell.hotel.service.RoomService;
import kell.hotel.utils.ImageUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ImageUpload imageUpload;
    @Autowired
    private HotelService hotelService;

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room save(Room room, MultipartFile imageRoom) {
        try {
            Room room1 = new Room();
            if (imageRoom == null) {
                room1.setImage(null);
            } else {
                if (imageUpload.uploadImage(imageRoom)) {
                    System.out.println("Upload successfully!");
                }
                room1.setImage(Base64.getEncoder().encodeToString(imageRoom.getBytes()));
            }
            room1.setDes(room.getDes());
            room1.setHotel(room.getHotel());
            room1.setQuantity(room.getQuantity());
            room1.setType(room.getType());
            room1.setUtil(room.getUtil());
            return roomRepository.save(room1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public Room update(Room room, MultipartFile imageRoom) {
        try {
            Room room1 = roomRepository.findById(room.getId()).get();
            if (imageRoom == null) {
                room1.setImage(room.getImage());
            } else {
                if (imageUpload.checkExisted(imageRoom) == false) {
                    imageUpload.uploadImage(imageRoom);
                }
                room1.setImage(Base64.getEncoder().encodeToString(imageRoom.getBytes()));
            }
            room1.setUtil(room.getUtil());
            room1.setDes(room.getDes());
            room1.setType(room.getType());
            room1.setQuantity(room.getQuantity());
            return roomRepository.save(room1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Room> getRoomsByHotelId(Long id) {
        return roomRepository.getRoomsByHotelId(id);
    }

    @Override
    public Optional<Room> findById(Long id) {
        return roomRepository.findById(id);
    }

    @Override
    public void deleteRoomsByHotelId(Long id) {
        roomRepository.deleteRoomsByHotelId(id);
    }
}
