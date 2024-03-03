package com.wjang.hotel_reservation_manager.controller;

import com.wjang.hotel_reservation_manager.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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