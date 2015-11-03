package com.burke.stocks;




import java.util.ArrayList;

import java.util.List;




import javax.sql.DataSource;




import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;




@Repository

public class ModelClass {

	

	

	




ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

//@Autowired




private DataSource dataSource = (DataSource)context.getBean("dataSource");




private JdbcTemplate jdbcTemplateObject = (JdbcTemplate)context.getBean("jdbcTemplate");







private int gstartmonth;

private int gendmonth;




public void setDataSource(DataSource dataSource) {

    this.jdbcTemplateObject = new JdbcTemplate(dataSource);

 }










public void ModelEnterStock(Stock stock){

	String SQL = "insert into Stock (Symbol, Price, Monthpurchased) values (?, ?, ?)";

	

	String stocksymbol = stock.getSymbol();

	int stockprice = stock.getPrice();

	int stockmonth = stock.getMonthpurchased();

	

 

      

      jdbcTemplateObject.update( SQL, stocksymbol, stockprice, stockmonth);

      

}




public List<Percentages> PortfolioPercentages(){

	 String SQL = "select Symbol, sum(Price) from Stock.stock Group by Symbol";

	 List <Percentages> percentages=new ArrayList<Percentages>();

	 	percentages = jdbcTemplateObject.query(SQL, 

                              			new PercentagesMapper());




	return percentages;

}




public List<Price> StockOverTime(StockOverTime stockovertime){

	gstartmonth=stockovertime.startmonth;

	gendmonth=stockovertime.endmonth;

	

	String SQL = "select Price, Monthpurchased from Stock where Symbol = '"+stockovertime.getSymbol()+"' AND Monthpurchased >="+stockovertime.getStartmonth()+" AND Monthpurchased <="+stockovertime.getEndmonth()+" ORDER BY Monthpurchased";




	List <Price> stockovertimelist = jdbcTemplateObject.query(SQL, new PriceMapper());

	System.out.print("Execution of POST reponse"+gstartmonth+""+gendmonth);

   




    return stockovertimelist;




}


public void reset(){
	
	
	String SQL = "TRUNCATE TABLE stock";
	 jdbcTemplateObject.update(SQL);
	
}







}