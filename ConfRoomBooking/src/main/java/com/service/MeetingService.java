package com.service;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MeetingDao;
import com.entity.MeetingRoom;

@Service
public class MeetingService {

	@Autowired
	private MeetingDao meetingDao;
	
	public Collection<MeetingRoom> getAllrooms() throws SQLException{
		return meetingDao.getAllrooms();
	}

	public MeetingRoom getRoomByNameId(int id) throws SQLException {
		return this.meetingDao.getRoomByNameId(id);
	}


	
	public MeetingRoom bookRoomByNameId(MeetingRoom meeting) {
		MeetingRoom room = this.meetingDao.bookRoomByNameId(meeting);
		return room;
	}


}
