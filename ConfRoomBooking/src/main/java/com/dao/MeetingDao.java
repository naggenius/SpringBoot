package com.dao;

import java.sql.SQLException;
import java.util.Collection;

import com.entity.MeetingRoom;

public interface MeetingDao {


	public Collection<MeetingRoom> getAllrooms() throws SQLException;
	
	public MeetingRoom getRoomByNameId(int id) throws SQLException;

	
	public MeetingRoom bookRoomByNameId(MeetingRoom student);


}
