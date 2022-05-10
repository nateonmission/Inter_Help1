package com.example.help1.services;

import com.example.help1.dtos.OrderInDTO;
import com.example.help1.dtos.OrderOutDTO;
import com.example.help1.dtos.ProductDTO;
import com.example.help1.dtos.ProductInDTO;
import com.example.help1.models.ItemQtyPerOrder;
import com.example.help1.models.Order;
import com.example.help1.models.Product;
import com.example.help1.repositories.ItemQtyPerOrderRepo;
import com.example.help1.repositories.OrderRepo;
import com.example.help1.repositories.ProductRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
import java.util.*;

@Service
public class OrderServices {
    private static final Logger LOGGER = Logger.getLogger(OrderServices.class.getName());

    @Bean
    public ModelMapper modelMapper() { return new ModelMapper(); }
    ModelMapper mm = modelMapper();

    private ItemQtyPerOrderRepo itemQtyPerOrderRepo;
    @Autowired
    public void setBookRepo(ItemQtyPerOrderRepo itemQtyPerOrderRepo) {
        this.itemQtyPerOrderRepo = itemQtyPerOrderRepo;
    }

    private ProductRepo productRepo;
    @Autowired
    public void setProductRepo(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    private OrderRepo orderRepo;
    @Autowired
    public void setOrderRepo(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public ProductDTO createProduct(ProductInDTO productInDTO){
        LOGGER.info("service calling createProduct ==>");
        Product product = mm.map(productInDTO, Product.class);
        productRepo.save(product);
        ProductDTO productDTO = getProductById(product.getId());
        return productDTO;
    }

    // GET /product/{id} -Returns individual product
    public ProductDTO getProductById(long id){
        LOGGER.info("service calling getProductById ==>");
        Optional<Product> product = productRepo.findById(id);
        ProductDTO productDTO = mm.map( product.get(), ProductDTO.class);
        return productDTO;
    }

    // GET /products -Returns list of ALL products
    public List<ProductDTO> listAllProducts(){
        LOGGER.info("service calling listAllProducts ==>");
        List<Product> products = productRepo.findAll();
        List<ProductDTO> productDTO = new ArrayList<>();

        products.stream().forEach( b ->
                productDTO.add(mm.map(b, ProductDTO.class))
        );
        return productDTO;
    }


    public OrderOutDTO createOrder(OrderInDTO orderInDTO){
        LOGGER.info("service calling createProduct ==>");
        String customerName = orderInDTO.getCustomerName();
        String date = orderInDTO.getDate();
        ArrayList<ItemQtyPerOrder> itemsAndQty = orderInDTO.getProductsAndQty();
        ArrayList<ItemQtyPerOrder> itemsQty= new ArrayList<ItemQtyPerOrder>();

        itemsAndQty.stream().forEach( t ->
                itemsQty.add(mm.map(t, ItemQtyPerOrder.class))
                );

        Order order = new Order();
        order.setCustomerName(customerName);
        order.setDate(date);
        order.setProductsAndQty(itemsQty);

        orderRepo.save(order);

        OrderOutDTO orderOutDTO = getOrderById(order.getId());
        return orderOutDTO;
    }

    // GET /product/{id} -Returns individual product
    public OrderOutDTO getOrderById(long id){
        LOGGER.info("service calling getOrderById ==>");
        Optional<Order> order = orderRepo.findById(id);
        OrderOutDTO orderOutDTO = mm.map( order.get(), OrderOutDTO.class);
        return orderOutDTO;
    }

    // GET /orders -Returns list of ALL products
    public List<OrderOutDTO> listAllOrders(){
        LOGGER.info("service calling listAllOrders ==>");
        List<Order> orders = orderRepo.findAll();
        List<OrderOutDTO> orderOutDTO = new ArrayList<>();

        orders.stream().forEach( b ->
                orderOutDTO.add(mm.map(b, OrderOutDTO.class))
        );
        return orderOutDTO;
    }


}
