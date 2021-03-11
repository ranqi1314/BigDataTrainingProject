package com.xuedao.web;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xuedao.bean.MonthBrandSales;
import com.xuedao.service.MonthBrandSalesService;
import net.sf.json.JSONArray;
public class MonthlyBrandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String y = request.getParameter("year");
		String m = request.getParameter("month");
		String month = y +"-"+ m;
		MonthBrandSalesService mbss = new MonthBrandSalesService();
		List<MonthBrandSales> monthBrand = mbss.getMonthBrand(month);
		JSONArray monthBrandJson = JSONArray.fromObject(monthBrand);
		response.getWriter().write(monthBrandJson.toString());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
