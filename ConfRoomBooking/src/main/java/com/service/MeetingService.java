package com.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MeetingDao;
import com.entity.MeetingRoom;

@Service
public class MeetingService {

	@Autowired
	private MeetingDao meetingDao;
	
	public Collection<MeetingRoom> getAllrooms(){
		return meetingDao.getAllrooms();
	}

	public MeetingRoom getRoomByNameId(int id) {
		return this.meetingDao.getRoomByNameId(id);
	}


	
	public void bookRoomByNameId(MeetingRoom meeting) {
		this.meetingDao.bookRoomByNameId(meeting);
	}


}
