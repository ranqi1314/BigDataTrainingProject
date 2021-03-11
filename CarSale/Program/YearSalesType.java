package com.xuedao.web;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xuedao.bean.YearTypeVolume;
import com.xuedao.service.YearTypeVolumeService;
import net.sf.json.JSONArray;
public class YearSalesType extends HttpServlet {
	private static final long serialVersionUID = 1L;     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String year = request.getParameter("year");	
		YearTypeVolumeService ytvs = new YearTypeVolumeService();
		List<YearTypeVolume> yearType = ytvs.getYearTypeVolume(year);	
		JSONArray json = JSONArray.fromObject(yearType);		
		response.getWriter().write(json.toString());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
