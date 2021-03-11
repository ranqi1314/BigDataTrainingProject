package com.xuedao.service;
import java.util.List;
import com.xuedao.bean.MonthBrandSales;
import com.xuedao.dao.MonthBrandSalesDao;
public class MonthBrandSalesService {
	public List<MonthBrandSales> getMonthBrand(String month) {
		MonthBrandSalesDao mbsd = new MonthBrandSalesDao();
		return mbsd.getMonthBrand(month);
	}
}
