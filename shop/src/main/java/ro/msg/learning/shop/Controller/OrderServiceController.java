package ro.msg.learning.shop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.Model.DTO.OrderDTO;
import ro.msg.learning.shop.Model.Entities.Order;
import ro.msg.learning.shop.Model.Entities.Product;
import ro.msg.learning.shop.Service.OrderService;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class OrderServiceController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ResponseEntity<Order>
    createOrder(@RequestBody OrderDTO order) {
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.OK);
    }
}
