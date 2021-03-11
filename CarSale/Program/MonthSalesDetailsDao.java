package com.xuedao.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.xuedao.bean.MonthSalesDetails;
import com.xuedao.util.JDBCConnection;
public class MonthSalesDetailsDao {
	// 获取指定月时间品牌销量前10数据
	public List<MonthSalesDetails> getMonthSalesDetails(String month, String brand) {
		List<MonthSalesDetails> msdList = new ArrayList<MonthSalesDetails>();
		try {
			Connection conf = JDBCConnection.jdbcUtil();
			String sql = "select * from month_sales_details where month = ? and brand = ?";
			PreparedStatement ps = conf.prepareStatement(sql);
			ps.setString(1, month);
			ps.setString(2, brand);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				MonthSalesDetails msd = new MonthSalesDetails();
				msd.setMonth(rs.getString(1));
				msd.setBrand(rs.getString(2));
				msd.setCar_type(rs.getString(3));
				msd.setSales_data(rs.getInt(4));	
				msdList.add(msd);
			}
			rs.close();
			ps.close();
			conf.close();	
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return msdList;
	}
}
