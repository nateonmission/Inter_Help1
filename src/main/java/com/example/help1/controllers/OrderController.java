package com.example.help1.controllers;

import com.example.help1.dtos.OrderInDTO;
import com.example.help1.dtos.OrderOutDTO;
import com.example.help1.dtos.ProductDTO;
import com.example.help1.dtos.ProductInDTO;
import com.example.help1.services.OrderServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/")
public class OrderController {
    private static final Logger LOGGER = Logger.getLogger(OrderController.class.getName());

    private OrderServices orderServices;
    @Autowired
    public void setBookServices(OrderServices orderServices) {

        this.orderServices = orderServices;
    }

    //  isAlive
    @CrossOrigin(origins = "*")
    @GetMapping("")
    public Boolean isAlive(){
        LOGGER.info("calling isAlive method from controller only");
        return true;
    }

    // TODO POST /product
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/product")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO createProduct(@RequestBody ProductInDTO productInDTO){
        LOGGER.info("calling createProduct service from controller");
        return orderServices.createProduct(productInDTO);
    }

    // TODO GET /product/{id}
    @CrossOrigin(origins = "*")
    @GetMapping("/product/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        LOGGER.info("calling getBookById service from controller");
        ProductDTO productDTO = orderServices.getProductById(id);
        return productDTO;
    }

    // TODO GET /products
    // GET All Books
    @CrossOrigin(origins = "*")
    @GetMapping("/products")
    public List<ProductDTO> listAllProducts() {
        LOGGER.info("calling listAllProducts service from controller");
        return orderServices.listAllProducts();
    }

    // TODO POST /order
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/order")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderOutDTO createOrder(@RequestBody OrderInDTO orderInDTO){
        LOGGER.info("calling createOrder service from controller");
        return orderServices.createOrder(orderInDTO);
    }

    // TODO GET /order/{id}

}
