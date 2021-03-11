package com.xuedao.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.xuedao.bean.MonthTypeVolume;
import com.xuedao.util.JDBCConnection;
public class MonthTypeVolumeDao {
	// 获取指定月时间类型销量前10数据
	public List<MonthTypeVolume> getMonthType(String month) {
		List<MonthTypeVolume> monthTypeVolumeList = new ArrayList<MonthTypeVolume>();
		try {
			Connection conf = JDBCConnection.jdbcUtil();	
			String sql = "select * from month_type_volume where month = ? order by sales_data desc limit 10";
			PreparedStatement ps = conf.prepareStatement(sql);
			ps.setString(1, month);
			ResultSet rs = ps.executeQuery();	
			while(rs.next()) {
				MonthTypeVolume monthTypeVolume = new MonthTypeVolume();
				monthTypeVolume.setMonth(rs.getString(1));
				monthTypeVolume.setCar_type(rs.getString(2));
				monthTypeVolume.setSales_data(rs.getInt(3));
				monthTypeVolumeList.add(monthTypeVolume);
			}		
			rs.close();
			ps.close();
			conf.close();		
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return monthTypeVolumeList;
	}
}
