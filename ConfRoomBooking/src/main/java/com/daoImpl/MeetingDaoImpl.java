package com.daoImpl;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.MeetingDao;
import com.entity.MeetingRoom;

@Repository
public class MeetingDaoImpl implements MeetingDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	static String insertSql = "INSERT INTO ROOM_INFO VALUES (?,?,?,?,?)";

	@Transactional(readOnly = true)
	public Collection<MeetingRoom> getAllrooms() throws SQLException {
		// System.out.println("Query employees: platform->" + platform);
		Collection<MeetingRoom> roomlist = new ArrayList<>();
		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from ROOM_INFO");
		return mapRow(list, roomlist);
	}

	public MeetingRoom getRoomByNameId(int id) throws SQLException {
		Collection<MeetingRoom> roomlist = new ArrayList<>();

		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from ROOM_INFO where ROOM_NO = ?", id);

		return mapRow(list, roomlist).iterator().next();
	}

	public MeetingRoom bookRoomByNameId(MeetingRoom room) {

		Integer cnt = jdbcTemplate.queryForObject(
				"SELECT count(*) FROM ROMM_INFO WHERE ROOM_NO  = ? AND BOOKED_BY = 'N/A')", Integer.class,
				room.getRoomNum());
		if (cnt != null && cnt > 0) {
			int row = jdbcTemplate.update(
					"update ROMM_INFO set START_TIME = ?, END_TIME = ?, BOOKED_BY  = ? where ROOM_NO = ? and BOOKED_BY = 'N/A'",
					room.getFrom(), room.getTo(), room.getBookedBy(), room.getRoomNum());
			System.out.println(row + " rows updated.");

		} else {
			Object[] params = new Object[] { room.getRoomNum(), room.getRoomName(), room.getFrom(), room.getTo(),
					room.getBookedBy() };
			int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR };
			int row = jdbcTemplate.update(insertSql, params, types);
			System.out.println(row + " rows inserted.");
		}
		return room;

	}

	public Collection<MeetingRoom> mapRow(List<Map<String, Object>> list, Collection<MeetingRoom> roomlist)
			throws SQLException {
		for (Map<String, Object> row : list) {
			MeetingRoom room = new MeetingRoom();
			room.setRoomNum(Integer.valueOf(row.get("ROOM_NO").toString()));
			room.setRoomName(row.get("ROOM_NAME").toString());
			room.setFrom((Date) (checkNull(row.get("START_TIME"))));
			room.setTo((Date) (checkNull(row.get("END_TIME"))));
			room.setBookedBy(checkNull(row.get("BOOKED_BY")).toString());
			roomlist.add(room);
		}
		return roomlist;
	}

	private Object checkNull(Object o) {

		if (null != o) {
			return o;
		} else {
			return null;
		}
	}

}
