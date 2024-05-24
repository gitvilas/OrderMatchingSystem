package com.StockExchangeOrderMatchingSystem.OrderMatching.PendingOrders;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Pending_Order")
public class PendingOrder {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    private Integer buyerQty;
    private Double buyerPrice;
    private Double sellerPrice;
    private Integer sellerQty;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
