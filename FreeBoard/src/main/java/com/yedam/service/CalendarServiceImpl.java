package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.CalendarMapper;
import com.yedam.vo.CalendarVO;

public class CalendarServiceImpl implements CalendarService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
	
	@Override
	public List<CalendarVO> eventList() {
		return mapper.eventList();
	}

	@Override
	public boolean addEvent(CalendarVO calendar) {
		return mapper.insertEvent(calendar) == 1;
	}

	@Override
	public boolean removeEvent(int eventNo) {
		return mapper.deleteEvent(eventNo) > 0;
	}

	@Override
	public boolean updateEvent(CalendarVO calendar) {
		return mapper.updateEvent(calendar) == 1;
	}


}
