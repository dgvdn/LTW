package kell.hotel.controller;

import kell.hotel.model.Hotel;
import kell.hotel.model.Room;
import kell.hotel.service.HotelService;
import kell.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/hotelier")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private HotelService hotelService;

    @GetMapping("/rooms")
    public String rooms(Model model) {
        model.addAttribute("title", "Rooms Management");
        List<Hotel> hotels = hotelService.findAll();
        model.addAttribute("hotels", hotels);
        model.addAttribute("size", hotels.size());
        return "rooms";
    }

    @GetMapping("/add-room/{id}")
    public String addRoom(@PathVariable("id") Long id, Model model, Principal principal) {
//        if(principal == null){
//            return "redirect:/login";
//        }
        model.addAttribute("title", "Add Room");
        Hotel hotel = hotelService.findById(id).get();
        model.addAttribute("hotel", hotel);
        model.addAttribute("room", new Room());
        return "add-room";
    }
    @PostMapping("/save-room")
    public String saveProduct(@ModelAttribute("room") Room room,
                              @RequestParam("imageRoom") MultipartFile image,
                              RedirectAttributes attributes) {
        try {
            roomService.save(room,image );
            attributes.addFlashAttribute("success", "Add successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            attributes.addFlashAttribute("error", "Add failed!");
        }
        return "redirect:/hotelier/rooms";
    }
    @GetMapping("/view-rooms/{id}")
    public String viewRoom(@PathVariable("id") Long id, Model model, Principal principal) {
//        if(principal == null){
//            return "redirect:/login";
//        }
        model.addAttribute("title", "Add Room");
        List<Room> rooms = roomService.getRoomsByHotelId(id);
        model.addAttribute("rooms", rooms);
        model.addAttribute("size",rooms.size());
        return "hotel-room";
    }
    @GetMapping("/edit-room/{id}")
    public String updateHotelForm(@PathVariable("id") Long id, Model model, Principal principal) {
//        if(principal == null){
//            return "redirect:/login";
//        }
        model.addAttribute("title", "Edit room");
        Room room = roomService.findById(id).get();
        model.addAttribute("room", room);
        return "edit-room";
    }
    @PostMapping("/edit-room/{id}")
    public String processUpdate(@PathVariable("id") Long id,
                                @ModelAttribute("room") Room room,
                                @RequestParam("imageRoom") MultipartFile imageRoom,
                                RedirectAttributes attributes
    ) {
        try {
            roomService.update(room,imageRoom);
            attributes.addFlashAttribute("success", "Edit successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            attributes.addFlashAttribute("error", "Edit failed!");
        }
        return "redirect:/hotelier/rooms";

    }
    @GetMapping("/delete-room/{id}")
    public String delete(@PathVariable("id") Long id, Model model, Principal principal) {
//        if(principal == null){
//            return "redirect:/login";
//        }
        roomService.deleteById(id);
        return "redirect:/hotelier/rooms";
    }
}
