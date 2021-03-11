package com.xuedao.service;
import java.util.List;
import com.xuedao.bean.YearBrandSales;
import com.xuedao.dao.YearBrandSalesDao;
public class YearBrandSalesService {
	public List<YearBrandSales> getYearBrandSalesService(String year) {
		YearBrandSalesDao ybsd = new YearBrandSalesDao();
		return ybsd.getYearBrand(year);
	}
}
