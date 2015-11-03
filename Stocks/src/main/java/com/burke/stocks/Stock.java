package com.burke.stocks;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
@JsonAutoDetect
public class Stock {

private String Symbol;
private int Price;
private int Monthpurchased;





@JsonProperty("Symbol")
public String getSymbol() {
	return this.Symbol;
}
public void setSymbol(String symbol) {
	this.Symbol = symbol;
}
@JsonProperty("Price")
public int getPrice() {
	return this.Price;
}
public void setPrice(int price) {
	this.Price = price;
}
@JsonProperty("Monthpurchased")
public int getMonthpurchased() {
	return this.Monthpurchased;
}
public void setMonthpurchased(int monthpurchased) {
	this.Monthpurchased = monthpurchased;
}






}