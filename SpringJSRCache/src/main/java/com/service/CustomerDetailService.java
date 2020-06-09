package com.service;

import java.util.List;

import javax.cache.annotation.CacheResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.model.Customer;
import com.model.Order;
import com.repository.CustomerDetailRepository;

@Component
public class CustomerDetailService {

    @Autowired
    private CustomerDetailRepository customerDetailRepository;

    @CacheResult
    public Customer getCustomerDetail(Integer customerId) {
        return customerDetailRepository.getCustomerDetail(customerId);
    }

    @CacheResult
    public List<Order> getCustomerOrders(Integer customerId) {
        return customerDetailRepository.getCustomerOrders(customerId);
    }
}
