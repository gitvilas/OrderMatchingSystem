package com.StockExchangeOrderMatchingSystem.OrderMatching.CompletedOrder;

public class OrderSellRequest {
	   private Double sellerPrice;
	    private Integer sellerQty;
		public Double getSellerPrice() {
			return sellerPrice;
		}
		public void setSellerPrice(Double sellerPrice) {
			this.sellerPrice = sellerPrice;
		}
		public Integer getSellerQty() {
			return sellerQty;
		}
		public void setSellerQty(Integer sellerQty) {
			this.sellerQty = sellerQty;
		}
	    
}
