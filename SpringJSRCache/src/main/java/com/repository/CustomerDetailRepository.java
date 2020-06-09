package com.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Customer;
import com.model.Order;

@Repository
public class CustomerDetailRepository {

	public Customer getCustomerDetail(Integer customerId) {
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer.setCustomerName("John");
		
		System.out.println("repo "+ customer.toString());
		return customer;
	}

	public List<Order> getCustomerOrders(Integer customerId) {
		List<Order> orders = new ArrayList<Order>();
		Order order1 = new Order();
		Order order2 = new Order();
		order1.setCustomerId(customerId);
		order1.setOrderId(10);

		order2.setCustomerId(customerId);
		order2.setOrderId(10);

		orders.add(order1);
		orders.add(order2);

		return orders;
	}
	
}
