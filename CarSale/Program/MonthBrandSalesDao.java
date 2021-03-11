package com.xuedao.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.xuedao.bean.MonthBrandSales;
import com.xuedao.util.JDBCConnection;
public class MonthBrandSalesDao {
	// 获取指定月时间品牌销量前10数据
	public List<MonthBrandSales> getMonthBrand(String month) {
		List<MonthBrandSales> monthBrandList = new ArrayList<MonthBrandSales>();
		try {
			Connection conf = JDBCConnection.jdbcUtil();
			String sql = "select * from month_brand_sales where month = ? order by sales_data desc limit 10";
			PreparedStatement ps = conf.prepareStatement(sql);
			ps.setString(1, month);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				MonthBrandSales monthBrand = new MonthBrandSales();
				monthBrand.setMonth(rs.getString(1));
				monthBrand.setBrand(rs.getString(2));
				monthBrand.setSales_data(rs.getInt(3));
				monthBrandList.add(monthBrand);
			}
			rs.close();
			ps.close();
			conf.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return monthBrandList;
	}
}
