package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.CalendarVO;

public interface CalendarMapper {
	List<CalendarVO> eventList();
	int insertEvent(CalendarVO calendar);
	int deleteEvent(int eventNo);
	int updateEvent(CalendarVO calendar);
}
