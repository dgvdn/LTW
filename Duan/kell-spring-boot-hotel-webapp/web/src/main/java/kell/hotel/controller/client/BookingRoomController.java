package kell.hotel.controller.client;

import kell.hotel.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/booking")
public class BookingRoomController {
    private BookingRepository bookingRepository;
    @Autowired
    public BookingRoomController(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }
}
