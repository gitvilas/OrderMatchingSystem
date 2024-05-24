package com.StockExchangeOrderMatchingSystem.OrderMatching.PendingOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendingOrderRepository extends JpaRepository<PendingOrder,Long>{

}
