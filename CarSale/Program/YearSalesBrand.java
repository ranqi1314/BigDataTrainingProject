package com.xuedao.web;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xuedao.bean.YearBrandSales;
import com.xuedao.service.YearBrandSalesService;
import net.sf.json.JSONArray;
public class YearSalesBrand extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String year = request.getParameter("year");
		YearBrandSalesService ybss = new YearBrandSalesService();
		List<YearBrandSales> yearBrandList = ybss.getYearBrandSalesService(year);
		JSONArray json = JSONArray.fromObject(yearBrandList);	
		response.getWriter().write(json.toString());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
