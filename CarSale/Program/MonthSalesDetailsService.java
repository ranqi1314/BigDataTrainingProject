package com.xuedao.service;
import java.util.List;
import com.xuedao.bean.MonthSalesDetails;
import com.xuedao.dao.MonthSalesDetailsDao;
public class MonthSalesDetailsService {
	public List<MonthSalesDetails> getMonthSalesDetailsService(String month, String brand) {
		MonthSalesDetailsDao msdd = new MonthSalesDetailsDao();
		return msdd.getMonthSalesDetails(month, brand);
	}
}
