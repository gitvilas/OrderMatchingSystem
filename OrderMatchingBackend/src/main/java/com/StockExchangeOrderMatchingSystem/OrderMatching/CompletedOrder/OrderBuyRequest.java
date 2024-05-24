package com.StockExchangeOrderMatchingSystem.OrderMatching.CompletedOrder;

public class OrderBuyRequest {
	 private Integer buyerQty;
	 private Double buyerPrice;
	public Integer getBuyerQty() {
		return buyerQty;
	}
	public void setBuyerQty(Integer buyerQty) {
		this.buyerQty = buyerQty;
	}
	public Double getBuyerPrice() {
		return buyerPrice;
	}
	public void setBuyerPrice(Double buyerPrice) {
		this.buyerPrice = buyerPrice;
	}
	 
}
