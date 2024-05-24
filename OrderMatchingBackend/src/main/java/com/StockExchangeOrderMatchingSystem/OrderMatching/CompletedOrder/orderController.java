package com.StockExchangeOrderMatchingSystem.OrderMatching.CompletedOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/orders")
public class orderController {
    @Autowired
    private OrderService orderService; 

    @PostMapping("/buy")
    public String addBuyOrder(@RequestBody OrderBuyRequest orderBuyRequest) {
        return orderService.addBuyOrder(orderBuyRequest.getBuyerQty(), orderBuyRequest.getBuyerPrice());
    }
    @PostMapping("/sell")
    public String addSellOrder(@RequestBody OrderSellRequest orderSellRequest) { 
        return orderService.addSellOrder(orderSellRequest.getSellerQty(), orderSellRequest.getSellerPrice());
    }
}


