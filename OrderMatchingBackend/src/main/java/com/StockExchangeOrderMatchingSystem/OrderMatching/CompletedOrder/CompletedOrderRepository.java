package com.StockExchangeOrderMatchingSystem.OrderMatching.CompletedOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CompletedOrderRepository extends JpaRepository<CompletedOrder,Long>{

}
