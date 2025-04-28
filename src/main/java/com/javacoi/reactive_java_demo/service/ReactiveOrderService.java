package com.javacoi.reactive_java_demo.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javacoi.reactive_java_demo.exceptions.OrderNotFoundException;
import com.javacoi.reactive_java_demo.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ReactiveOrderService {

    private final ObjectMapper objectMapper;

    public ReactiveOrderService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Flux<Order> getOrder(String orderNumber){
        return Flux.fromIterable(getOrders()).filter(o -> o.OrderNumber().equals(orderNumber)).distinct();
    }
    
    public List<Order> getOrders(){
        String jsonFile = "src/main/resources/data/orders.json";
        List<Order> orders;
        try {
            orders = loadOrderData(jsonFile);
        } catch (IOException e) {
            orders = Collections.emptyList();
        }
        return orders;
    }

    public List<Order> loadOrderData(String jsonFile) throws IOException {
        return objectMapper.readValue(new File(jsonFile), new TypeReference<>() {
        });
    }
}
