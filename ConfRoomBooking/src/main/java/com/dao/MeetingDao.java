package com.dao;

import java.util.Collection;

import com.entity.MeetingRoom;

public interface MeetingDao {


	public Collection<MeetingRoom> getAllrooms();
	
	public MeetingRoom getRoomByNameId(int id);

	
	public void bookRoomByNameId(MeetingRoom student);


}
