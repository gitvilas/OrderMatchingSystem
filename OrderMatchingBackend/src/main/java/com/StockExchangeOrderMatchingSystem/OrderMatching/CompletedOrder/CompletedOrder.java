package com.StockExchangeOrderMatchingSystem.OrderMatching.CompletedOrder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Completed_Order")
public class CompletedOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    private Double price;
    private Integer qty;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
}
