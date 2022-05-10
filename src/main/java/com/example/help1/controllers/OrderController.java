package com.example.help1.controllers;

import com.example.help1.services.OrderServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/")
public class OrderController {
    private static final Logger LOGGER = Logger.getLogger(OrderController.class.getName());

    @Bean
    public OrderServices orderServices() { return new OrderServices(); }
    OrderServices orderServices = orderServices();

    @Bean
    public ModelMapper modelMapper() { return new ModelMapper();  }
    ModelMapper modelMapper = modelMapper();

    //  isAlive
    @CrossOrigin(origins = "*")
    @GetMapping("")
    public Boolean isAlive(){
        LOGGER.info("calling isAlive method from controller only");
        return true;
    }

    // TODO POST /product

    // TODO GET /product/{id}

    // TODO GET /products

    // TODO POST /order

    // TODO GET /order/{id}

}
