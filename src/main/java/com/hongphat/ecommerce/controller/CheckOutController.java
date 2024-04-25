package com.hongphat.ecommerce.controller;

import com.hongphat.ecommerce.dto.Purchase;
import com.hongphat.ecommerce.dto.PurchaseResponse;
import com.hongphat.ecommerce.service.CheckOutService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("api/checkout")
public class CheckOutController {
    private final CheckOutService checkOutService;
    public CheckOutController(CheckOutService checkOutService, CheckOutService checkOutService1) {
        this.checkOutService = checkOutService1;
    }
    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        PurchaseResponse purchaseResponse = checkOutService.placeOrder(purchase);
        return purchaseResponse;
    }
}
