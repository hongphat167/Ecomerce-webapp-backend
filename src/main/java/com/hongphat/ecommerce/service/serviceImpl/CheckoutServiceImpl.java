package com.hongphat.ecommerce.service.serviceImpl;

import com.hongphat.ecommerce.dao.CustomerRepository;
import com.hongphat.ecommerce.dto.Purchase;
import com.hongphat.ecommerce.dto.PurchaseResponse;
import com.hongphat.ecommerce.entity.Customer;
import com.hongphat.ecommerce.entity.Order;
import com.hongphat.ecommerce.entity.OrderItem;
import com.hongphat.ecommerce.service.CheckOutService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckOutService {
    private final CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Order order = purchase.getOrder();
        // generate trackingnumber
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // get order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // get order with billing and shipping
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        //get customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        // save it to database
        customerRepository.save(customer);
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        //generate UUID number
        return UUID.randomUUID().toString();
    }
}
