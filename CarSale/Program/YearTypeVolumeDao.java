package com.xuedao.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.xuedao.bean.YearTypeVolume;
import com.xuedao.util.JDBCConnection;
public class YearTypeVolumeDao {
	// 获取指定月时间品牌销量前10数据
	public List<YearTypeVolume> getYearType(String year) {	
		List<YearTypeVolume> yearTypeList = new ArrayList<YearTypeVolume>();	
		try {
			Connection conf = JDBCConnection.jdbcUtil();		
			String sql = "select * from year_type_volume where year = ? order by sales_data desc limit 10";
			PreparedStatement ps = conf.prepareStatement(sql);
			ps.setString(1, year);		
			ResultSet rs = ps.executeQuery();		
			while(rs.next()) {
				YearTypeVolume yeartype = new YearTypeVolume();
				yeartype.setYear(rs.getString(1));
				yeartype.setCar_type(rs.getString(2));
				yeartype.setSales_data(rs.getInt(3));			
				yearTypeList.add(yeartype);
			}		
			rs.close();
			ps.close();
			conf.close();	
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println(e.toString());
		}	
		return yearTypeList;
	}	
}
