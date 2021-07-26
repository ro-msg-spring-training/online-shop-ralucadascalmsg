package ro.msg.learning.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.OrderRequestDTO;
import ro.msg.learning.shop.mail.MailService;
import ro.msg.learning.shop.model.Order;
import ro.msg.learning.shop.service.OrderService;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    MailService mailService;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ResponseEntity<Order>
    createOrder(@RequestBody OrderRequestDTO orderDto) {
        Order order= orderService.createOrder(orderDto);
        //send mail
        mailService.sendSimpleMessage();
        return new ResponseEntity<>(orderService.createOrder(orderDto), HttpStatus.OK);
    }
}
