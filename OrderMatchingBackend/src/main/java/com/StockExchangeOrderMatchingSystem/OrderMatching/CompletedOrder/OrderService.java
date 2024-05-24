package com.StockExchangeOrderMatchingSystem.OrderMatching.CompletedOrder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.StockExchangeOrderMatchingSystem.OrderMatching.PendingOrders.PendingOrder;
import com.StockExchangeOrderMatchingSystem.OrderMatching.PendingOrders.PendingOrderRepository;
import jakarta.transaction.Transactional;

@Service
public class OrderService {

    @Autowired
    private PendingOrderRepository pendingOrderRepository;

    @Autowired
    private CompletedOrderRepository completedOrderRepository;

    @Transactional
    public String addBuyOrder(Integer buyerQty, Double buyerPrice) {
        List<PendingOrder> pendingOrders = pendingOrderRepository.findAll();
        for (PendingOrder order : pendingOrders) {
            if (order.getSellerPrice() != null && buyerPrice >= order.getSellerPrice()) {
                int matchedQty = Math.min(buyerQty, order.getSellerQty());
                CompletedOrder completedOrder = new CompletedOrder();
                completedOrder.setPrice(order.getSellerPrice());
                completedOrder.setQty(matchedQty);
                completedOrderRepository.save(completedOrder);

                order.setSellerQty(order.getSellerQty() - matchedQty);
                if (order.getSellerQty() == 0) {
                    pendingOrderRepository.delete(order);
                } else {
                    pendingOrderRepository.save(order);
                }

                buyerQty -= matchedQty;
                if (buyerQty == 0) {
                    break;
                }
            }
        }

        if (buyerQty > 0) {
            PendingOrder newPendingOrder = new PendingOrder();
            newPendingOrder.setBuyerQty(buyerQty);
            newPendingOrder.setBuyerPrice(buyerPrice);
            newPendingOrder.setSellerPrice(null);
            newPendingOrder.setSellerQty(null);
            pendingOrderRepository.save(newPendingOrder);
        }

        return "Buy Order successfully placed";
    }

    @Transactional
    public String addSellOrder(Integer sellerQty, Double sellerPrice) {
        List<PendingOrder> pendingOrders = pendingOrderRepository.findAll();
        for (PendingOrder order : pendingOrders) {
            if (order.getBuyerPrice() != null && sellerPrice <= order.getBuyerPrice()) {
                int matchedQty = Math.min(sellerQty, order.getBuyerQty());
                CompletedOrder completedOrder = new CompletedOrder();
                completedOrder.setPrice(order.getBuyerPrice());
                completedOrder.setQty(matchedQty);
                completedOrderRepository.save(completedOrder);

                order.setBuyerQty(order.getBuyerQty() - matchedQty);
                if (order.getBuyerQty() == 0) {
                    pendingOrderRepository.delete(order);
                } else {
                    pendingOrderRepository.save(order);
                }

                sellerQty -= matchedQty;
                if (sellerQty == 0) {
                    break;
                }
            }
        }

        if (sellerQty > 0) {
            PendingOrder newPendingOrder = new PendingOrder();
            newPendingOrder.setSellerQty(sellerQty);
            newPendingOrder.setSellerPrice(sellerPrice);
            newPendingOrder.setBuyerPrice(null);
            newPendingOrder.setBuyerQty(null);
            pendingOrderRepository.save(newPendingOrder);
        }

        return "Sell Order successfully placed";
    }
}
