package kell.hotel.service.impl;

import kell.hotel.model.Hotel;
import kell.hotel.repository.HotelRepository;
import kell.hotel.service.HotelService;
import kell.hotel.utils.ImageUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ImageUpload imageUpload;

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }


    @Override
    public Hotel save(Hotel hotel, MultipartFile image) {
        try {
            Hotel hotel1 = new Hotel();
            if (image == null) {
                hotel1.setImage(null);
            } else {
                if (imageUpload.uploadImage(image)) {
                    System.out.println("Upload successfully!");
                }
                hotel1.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
            }
            hotel1.setAddress(hotel.getAddress());
            hotel1.setDes(hotel.getDes());
            hotel1.setName(hotel.getName());
            hotel1.setStar(hotel.getStar());
            return hotelRepository.save(hotel1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public Hotel update(Hotel hotel, MultipartFile image) {
        try {
            Hotel hotel1 = hotelRepository.findById(hotel.getId()).get();
            if (image == null) {
                hotel1.setImage(hotel.getImage());
            } else {
                if (imageUpload.checkExisted(image) == false) {
                    imageUpload.uploadImage(image);
                }
                hotel1.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
            }
            hotel1.setName(hotel.getName());
            hotel1.setStar(hotel.getStar());
            hotel1.setDes(hotel.getDes());
            hotel1.setAddress(hotel.getAddress());
            return hotelRepository.save(hotel1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Optional<Hotel> findById(Long id) {
        return hotelRepository.findById(id);
    }

}
