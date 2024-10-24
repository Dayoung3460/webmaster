package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.CalendarService;
import com.yedam.service.CalendarServiceImpl;
import com.yedam.vo.CalendarVO;

public class UpdateEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");

		int eventNo = Integer.parseInt(req.getParameter("eventNo"));
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		
		CalendarService svc = new CalendarServiceImpl();
		
		CalendarVO calendar = new CalendarVO();
		calendar.setEventNo(eventNo);
		calendar.setStartDate(startDate);
		calendar.setEndDate(endDate);
		
		boolean isSuccess = svc.updateEvent(calendar);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(isSuccess);
		resp.getWriter().print(json);
	}

}
