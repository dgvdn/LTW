package kell.hotel.controller;

import kell.hotel.model.Room;
import kell.hotel.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/room")
public class DisplayController {
    private RoomRepository roomRepository;
    @Autowired
    public DisplayController(RoomRepository roomRepository){
        this.roomRepository  = roomRepository;
    }
    @ModelAttribute
    public void addRoomToModel(Model model){
        Room room  = roomRepository.getReferenceById(1);
//        room.setServices(new ArrayList<Service>());
//        Model truyền dữ liệu lên view
        model.addAttribute("rooms", room);
        model.addAttribute("message", "Hello World");
    }
    @GetMapping
    public String show(){
            return "room";
}
    @PostMapping("/roomdetail")
    public String showRoomt() {
        return "redirect:/roomdetail";
    }
    @PostMapping("/hoteldetail")
    public String showHotel() {
        return "redirect:/hoteldetail";
    }
    @PostMapping("/booking")
    public String delete() {
        return "redirect:/booking";
    }
}
