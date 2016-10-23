package com.contoller;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.MeetingRoom;
import com.service.MeetingService;

@RestController
@RequestMapping("/rooms")
public class MeetingController {

	@Autowired
	private MeetingService meetingService;
	
	@RequestMapping(method = RequestMethod.GET)
	private Collection<MeetingRoom> getAllrooms() throws SQLException{
		return meetingService.getAllrooms();
	}
	
	@RequestMapping(value = "/{roomNum}", method = RequestMethod.GET)
	public MeetingRoom getRoomByNameId(@PathVariable("roomNum") int roomNum) throws SQLException {
		return meetingService.getRoomByNameId(roomNum);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON_VALUE)
	public MeetingRoom bookRoomByNameId(@RequestBody MeetingRoom s) {
		MeetingRoom room = meetingService.bookRoomByNameId(s);
		return room;
	}

}
