package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.CalendarService;
import com.yedam.service.CalendarServiceImpl;
import com.yedam.vo.CalendarVO;

public class AddEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");

		String title = req.getParameter("title");
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		
		
		
		CalendarService svc = new CalendarServiceImpl();
		
		CalendarVO calendar = new CalendarVO();
		calendar.setTitle(title);
		calendar.setStartDate(startDate);
		calendar.setEndDate(endDate);
		
		boolean isSuccess = svc.addEvent(calendar);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(isSuccess);
		resp.getWriter().print(json);
	}

}
