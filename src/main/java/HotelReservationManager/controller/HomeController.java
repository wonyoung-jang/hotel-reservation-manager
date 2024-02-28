package HotelReservationManager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import HotelReservationManager.service.MessageService;

@RestController
@RequestMapping("/welcome")
public class HomeController {

    private final MessageService messageService;

    public HomeController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String[] welcome() {
        return messageService.getMessages();
    }
}
