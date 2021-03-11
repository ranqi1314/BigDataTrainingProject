package com.xuedao.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.xuedao.bean.NationalityRatio;
import com.xuedao.util.JDBCConnection;
public class NationalityRatioDao {
	// 获取指定月时间品牌销量前10数据
	public List<NationalityRatio> getNationalityRatio(String month) {	
		List<NationalityRatio> nationalityRatioList = new ArrayList<NationalityRatio>();	
		try {
			Connection conf = JDBCConnection.jdbcUtil();		
			String sql = "select * from nationality_ratio where month = ? order by nationality";
			PreparedStatement ps = conf.prepareStatement(sql);
			ps.setString(1, month);		
			ResultSet rs = ps.executeQuery();	
			while(rs.next()) {		
				NationalityRatio nationalityRatio = new NationalityRatio();
				nationalityRatio.setMonth(rs.getString(1));
				nationalityRatio.setNationality(rs.getString(2));
				nationalityRatio.setProportion(rs.getDouble(3));			
				nationalityRatioList.add(nationalityRatio);
			}		
			rs.close();
			ps.close();
			conf.close();		
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println(e.toString());
		}	
		return nationalityRatioList;
	}
}
