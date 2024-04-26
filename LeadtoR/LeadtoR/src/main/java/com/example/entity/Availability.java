package com.example.entity;
 class Availability {
	private boolean inStock;
	private int quantity;
	
	public Availability() {
		super();
	}
	public Availability(boolean inStock, int quantity) {
		super();
		this.inStock = inStock;
		this.quantity = quantity;
	}
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}


