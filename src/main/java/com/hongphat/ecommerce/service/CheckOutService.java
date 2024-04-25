package com.hongphat.ecommerce.service;

import com.hongphat.ecommerce.dto.Purchase;
import com.hongphat.ecommerce.dto.PurchaseResponse;

public interface CheckOutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
