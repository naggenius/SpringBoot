package com.entity;

import java.util.Date;

public class MeetingRoom {

	private int roomNum;

	private String roomName;

	private Date from;

	private Date to;

	private String bookedBy;

	public MeetingRoom(int roomNum, String roomName, Date from, Date to,
			String bookingStatus) {
		this.roomNum = roomNum;
		this.roomName = roomName;
		this.from = from;
		this.to = to;
		this.bookedBy = bookingStatus;
	}

	public MeetingRoom() {
	}


	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public String getBookedBy() {
		return bookedBy;
	}

	public void setBookedBy(String bookingStatus) {
		this.bookedBy = bookingStatus;
	}

}
