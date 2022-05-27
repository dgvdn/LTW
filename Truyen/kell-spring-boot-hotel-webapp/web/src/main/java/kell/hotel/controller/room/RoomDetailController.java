package kell.hotel.controller.room;

import kell.hotel.model.Room;
import kell.hotel.model.Service;
import kell.hotel.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/roomdetail")
public class RoomDetailController {
//      hien thi danh sach phong

    private RoomRepository roomRepository;
    @Autowired
    public RoomDetailController(RoomRepository roomRepository){
        this.roomRepository =roomRepository;
    }
    @GetMapping("/{id}")
    public String ShowDeatail(@PathVariable("id") int id, Model model) {
        Room room = roomRepository.getReferenceById(1);
        model.addAttribute("room", room);
        return "roomdetail";
    }
}
