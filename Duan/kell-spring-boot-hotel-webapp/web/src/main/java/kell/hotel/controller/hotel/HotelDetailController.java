package kell.hotel.controller.hotel;

import kell.hotel.model.Hotel;
import kell.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hoteldetail")
public class HotelDetailController {
    private HotelRepository hotelRepository;
    @Autowired
    public HotelDetailController(HotelRepository  hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/{idHotel}")
    public String ShowHotelDetail(@PathVariable("idHotel") int id, Model model){
        Hotel hotel  = hotelRepository.getReferenceById(id);
        model.addAttribute("hotel",  hotel);
        return "hoteldetail";
    }
}
