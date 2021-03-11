package com.xuedao.web;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xuedao.bean.NationalityRatio;
import com.xuedao.service.NationalityRatioService;
import net.sf.json.JSONArray;
public class NationalityRatioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String y = request.getParameter("year");
		String m = request.getParameter("month");
		String month = y +"-"+ m;	
		System.out.println(month);	
		NationalityRatioService nrs = new NationalityRatioService();
		List<NationalityRatio> list = nrs.getNationalityRatioService(month);		
		JSONArray json = JSONArray.fromObject(list);		
		response.getWriter().write(json.toString());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
