package com.javacoi.reactive_java_demo.controller;

import com.javacoi.reactive_java_demo.model.Order;
import com.javacoi.reactive_java_demo.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping(path = "/{orderNumber}")
    public Order getOrder(@PathVariable String orderNumber){
        return orderService.getOrder(orderNumber);
    }

}
