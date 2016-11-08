
/*
 * Execute the below script before starting th eapplication in CONSOLE H2 DB
 * */


Create table ROOM_INFO (
		ROOM_NO VARCHAR2(9), 
		ROOM_NAME VARCHAR2(30), 
		START_TIME TIMESTAMP(6), 
		END_TIME TIMESTAMP(6), 
		BOOKED_BY VARCHAR2(3)
		);
		
INSERT INTO ROOM_INFO values ('1','East Block',NULL,NULL,'N/A');
INSERT INTO ROOM_INFO values ('2','West Block',NULL,NULL,'N/A');
INSERT INTO ROOM_INFO values ('3','South Block',NULL,NULL,'N/A');
INSERT INTO ROOM_INFO values ('4','North Block',NULL,NULL,'N/A');
