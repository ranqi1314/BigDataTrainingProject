package com.xuedao.web;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xuedao.bean.MonthSalesDetails;
import com.xuedao.service.MonthSalesDetailsService;
import net.sf.json.JSONArray;
public class MonthSalesDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String month = request.getParameter("month");
		String brand = request.getParameter("brand");
		MonthSalesDetailsService msds = new MonthSalesDetailsService();
		List<MonthSalesDetails> list = msds.getMonthSalesDetailsService(month, brand);
		JSONArray json = JSONArray.fromObject(list);
		response.getWriter().write(json.toString());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
