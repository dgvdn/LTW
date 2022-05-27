package kell.hotel.controller;

import kell.hotel.model.Hotel;
import kell.hotel.model.Room;
import kell.hotel.service.HotelService;
import kell.hotel.service.RoomService;
import kell.hotel.service.impl.HotelServiceImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/hotelier")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private RoomService roomService;

    @GetMapping("/")
    public String host(Model model, Principal principal) {
//        if (principal == null) {
//            return "redirect:/hotelier/login";
//        }
        model.addAttribute("title", "Hotelier");
        return "index";
    }

    @GetMapping("/home")
    public String hotelManage(Model model) {
        List<Hotel> hotels = hotelService.findAll();
        model.addAttribute("hotels", hotels);
        model.addAttribute("title", "Hotel Management");
        return "index";
    }

    @GetMapping("/hotels")
    public String hotels(Model model) {
        List<Hotel> hotels = hotelService.findAll();
        model.addAttribute("hotels", hotels);
        model.addAttribute("title", "Hotels");
        model.addAttribute("size", hotels.size());
        return "hotels";
    }

    @GetMapping("/add-hotel")
    public String addHotelForm(Model model, Principal principal) {
//        if(principal == null){
//            return "redirect:/login";
//        }
        model.addAttribute("title", "Add Hotel");
        model.addAttribute("hotel", new Hotel());
        return "add-hotel";
    }

    @PostMapping("/save-hotel")
    public String saveProduct(@ModelAttribute("hotel") Hotel hotel,
                              @RequestParam("imageHotel") MultipartFile image,
                              RedirectAttributes attributes) {
        try {
            hotelService.save(hotel, image);
            attributes.addFlashAttribute("success", "Add successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            attributes.addFlashAttribute("error", "Add failed!");
        }
        return "redirect:/hotelier/hotels";
    }

    @GetMapping("/edit-hotel/{id}")
    public String updateHotelForm(@PathVariable("id") Long id, Model model, Principal principal) {
//        if(principal == null){
//            return "redirect:/login";
//        }
        model.addAttribute("title", "Edit hotel");
        Hotel hotel = hotelService.findById(id).get();
        model.addAttribute("hotel", hotel);
        return "edit-hotel";
    }

    @PostMapping("/edit-hotel/{id}")
    public String processUpdate(@PathVariable("id") Long id,
                                @ModelAttribute("hotel") Hotel hotel,
                                @RequestParam("imageHotel") MultipartFile imageHotel,
                                RedirectAttributes attributes
    ) {
        try {
            hotelService.update(hotel, imageHotel);
            attributes.addFlashAttribute("success", "Edit successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            attributes.addFlashAttribute("error", "Edit failed!");
        }
        return "redirect:/hotelier/hotels";

    }
    @Transactional
    @GetMapping("/delete-hotel/{id}")
    public String delete(@PathVariable("id") Long id, Model model, Principal principal) {
//        if(principal == null){
//            return "redirect:/login";
//        }
        roomService.deleteRoomsByHotelId(id);
        hotelService.deleteById(id);


        return "redirect:/hotelier/hotels";
    }
}
