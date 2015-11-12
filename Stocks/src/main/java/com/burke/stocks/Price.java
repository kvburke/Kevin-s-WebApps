package com.burke.stocks;


public class Price {

	public Price(){
		
	}
	public Price(int price, int monthpurchased){
		this.Price= price;
		this.Monthpurchased=monthpurchased;
	}
	
	private int Price;
	private int Monthpurchased;


	
	public int getPrice() {
		return this.Price;
	}
	public void setPrice(int price) {
		this.Price = price;
	}
	
	public int getMonthpurchased() {
		return this.Monthpurchased;
	}
	public void setMonthpurchased(int monthpurchased) {
		this.Monthpurchased = monthpurchased;
	}








}