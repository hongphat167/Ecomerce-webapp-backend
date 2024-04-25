package com.hongphat.ecommerce.dto;

import com.hongphat.ecommerce.entity.Address;
import com.hongphat.ecommerce.entity.Customer;
import com.hongphat.ecommerce.entity.Order;
import com.hongphat.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
