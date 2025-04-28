package com.javacoi.reactive_java_demo.controller;

import com.javacoi.reactive_java_demo.model.Order;
import com.javacoi.reactive_java_demo.service.OrderService;
import com.javacoi.reactive_java_demo.service.ReactiveOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/reactive/orders")
public class ReactiveOrderController {

    private final ReactiveOrderService orderService;

    public ReactiveOrderController(ReactiveOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping(path = "/{orderNumber}")
    public Flux<Order> getOrder(@PathVariable String orderNumber){
        return orderService.getOrder(orderNumber);
    }

}
