package com.burke.stocks;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;




	public class PriceMapper implements RowMapper<Price> {
		   public Price mapRow(ResultSet rs, int rowNum) throws SQLException {
		      Price price = new Price();
		    
		      price.setPrice(rs.getInt("Price"));
		      price.setMonthpurchased(rs.getInt("Monthpurchased"));
		      return price;
		   }
		}	
	
	
	
	


