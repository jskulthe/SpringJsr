package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Customer;
import com.model.Order;
import com.service.CustomerDetailService;
import com.service.OrderDetailService;


@RestController
@RequestMapping("/ecommerce/api/v1")
public class EcommerceController {

    @Autowired
    private CustomerDetailService customerDetailBO;

    @Autowired
    private OrderDetailService orderDetailBO;

    @GetMapping(value = "/getCustomer/{customerid}")
    public Customer getCustomer(@PathVariable Integer customerid) {
        return customerDetailBO.getCustomerDetail(customerid);
    }

    @GetMapping(value = "/getCustomerOrders/{customerid}")
    public List<Order> getCustomerOrders(@PathVariable Integer customerid) {
        return customerDetailBO.getCustomerOrders(customerid);
    }

/*    @GetMapping(value = "/getOrder/{orderid}")
    public Order getOrder(@PathVariable Integer orderid) {
        return orderDetailBO.getOrderDetail(orderid);
    }

    @GetMapping(value = "/getOrderPrice/{orderid}")
    public double getOrderPrice(@PathVariable Integer orderid) {
        return orderDetailBO.getOrderPrice(orderid);
    }

*/
}
