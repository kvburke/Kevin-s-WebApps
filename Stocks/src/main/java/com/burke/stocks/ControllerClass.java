package com.burke.stocks;



import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping(value= "/Controller1", method = RequestMethod.GET)
public class ControllerClass {
	
	StockOverTime global = new StockOverTime();
	
	
	ServiceClass ServiceClass = new ServiceClass();
	@RequestMapping(value="/stock", method = RequestMethod.POST, headers="Content-type=application/json")
	public void enterstock(@RequestBody Stock stock) {
		
		System.out.println(stock.getSymbol());
		System.out.println(stock.getPrice());
		System.out.println(stock.getMonthpurchased());
		 ServiceClass.ServiceEnterStock(stock);
		return;
		
}

	@RequestMapping(value="/portfolio", method = RequestMethod.GET)
	public @ResponseBody List<Percentages> portfoliopercentages(){
		return ServiceClass.PortfolioPercentages();
		
	}
	
	
	@RequestMapping(value="/stockovertimeget", method = RequestMethod.GET)
	public @ResponseBody List<Price> stockovertimeget(StockOverTime StockOvertime){
		StockOvertime.symbol=this.global.getSymbol();
		StockOvertime.startmonth=this.global.getStartmonth();
		StockOvertime.endmonth=this.global.getEndmonth();
		System.out.println("Symbol transferred over"+ StockOvertime.getSymbol());
		System.out.println("Start month transferred over"+StockOvertime.getStartmonth());
		System.out.println("Endmonth transferred over"+ StockOvertime.getEndmonth());
		return ServiceClass.stockOverTime(StockOvertime);	
		}
	
	@RequestMapping(value="/stockovertime", method = RequestMethod.POST)
	public @ResponseBody List<Price> stockovertime(@RequestBody StockOverTime StockOvertime){
		System.out.println("POST REQUEST SUCCESS FOR /STOCKOVERTIME");
		System.out.println(StockOvertime.getSymbol());
		System.out.println(StockOvertime.getStartmonth());
		System.out.println(StockOvertime.getEndmonth());
		 ServiceClass.stockOverTime(StockOvertime);
		 this.global.setSymbol(StockOvertime.getSymbol());
			System.out.println("Symbol intialized at"+ StockOvertime.getSymbol());
		 this.global.setStartmonth(StockOvertime.getStartmonth());
		 this.global.setEndmonth(StockOvertime.getEndmonth());
		
		 return ServiceClass.stockOverTime(StockOvertime);
		}
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String showHomePage() {
		return "redirect:/views/index.html"; 
	   }
	
	@RequestMapping(value="/reset", method = RequestMethod.POST)
	public void reset(){
		ServiceClass.reset();
		return;
	}
	
	}