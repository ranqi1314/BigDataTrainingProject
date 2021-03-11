package com.xuedao.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.xuedao.bean.YearBrandSales;
import com.xuedao.util.JDBCConnection;
public class YearBrandSalesDao {
	// 获取指定月时间品牌销量前10数据
	public List<YearBrandSales> getYearBrand(String year) {
		List<YearBrandSales> yearBrandSalesList = new ArrayList<YearBrandSales>();
		try {
			Connection conf = JDBCConnection.jdbcUtil();	
			String sql = "select * from year_brand_sales where year = ? order by sales_data desc limit 10";
			PreparedStatement ps = conf.prepareStatement(sql);
			ps.setString(1, year);	
			ResultSet rs = ps.executeQuery();	
			while(rs.next()) {
				YearBrandSales yearBrand = new YearBrandSales();
				yearBrand.setYear(rs.getString(1));
				yearBrand.setBrand(rs.getString(2));
				yearBrand.setSales_data(rs.getInt(3));
				
				yearBrandSalesList.add(yearBrand);
			}
			rs.close();
			ps.close();
			conf.close();	
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println(e.toString());
		}	
		return yearBrandSalesList;
	}
}
