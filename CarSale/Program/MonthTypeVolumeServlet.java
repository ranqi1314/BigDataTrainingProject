package com.xuedao.web;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xuedao.bean.MonthTypeVolume;
import com.xuedao.service.MonthTypeVolumeService;
import net.sf.json.JSONArray;
public class MonthTypeVolumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String y = request.getParameter("year");
		String m = request.getParameter("month");
		String month = y +"-"+ m;
		MonthTypeVolumeService mtvs = new MonthTypeVolumeService();
		List<MonthTypeVolume> monthTypeVolumeList = mtvs.getMonthType(month);
		JSONArray monthTypeVolume = JSONArray.fromObject(monthTypeVolumeList);
		response.getWriter().write(monthTypeVolume.toString());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
