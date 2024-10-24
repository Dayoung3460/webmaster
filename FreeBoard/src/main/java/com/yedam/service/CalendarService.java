package com.yedam.service;

import java.util.List;

import com.yedam.vo.CalendarVO;

public interface CalendarService {
	List<CalendarVO> eventList();
	boolean addEvent(CalendarVO calendar);
	boolean removeEvent(int eventNo);
	boolean updateEvent(CalendarVO calendar);
}
