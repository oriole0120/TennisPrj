
SELECT COUNT(*) CNT, 'TITLE' FROM PHOTOBOARDS WHERE writer like '%dei%';

select * from photoboards where Writer like 'deian';


select * from photoboards where 'code' like '11';

select * from authoritylists

select * from members

select * from photofiles

INSERT INTO Members(mid, pwd, name, email, phone, studentnum, authority) 
	VALUES('BBBBB','0000','ぞぞぞぞ','ABC@DEF.COM','012-364-7890','0','Associate')

select * from noticeFiles where noticecode = '10'

SELECT F.* FROM (SELECT(ROW_NUMBER() OVER ( ORDER BY REGDATE DESC)) NUM, FREEBOARDS.* FROM FREEBOARDS WHERE TITLE LIKE '%%') F WHERE F.NUM BETWEEN 21 AND 25; 

INSERT INTO PHOTOBOARDS(CODE, WRITER, REGDATE, TITLE, CONTENTS, HIT, THUMB, AUTHORITY) 
	VALUES(#{code}, #{writer}, GETDATE(), #{title}, #{contents}, 0, 0, 'B')
	
	select code, eventdate, contents from schedules where code = '2'
	
	SELECT N.* 
			FROM(SELECT (ROW_NUMBER() OVER(ORDER BY regdate DESC))NUM, SCHEDULES.* 
					FROM SCHEDULES WHERE 'title' LIKE '3%') N
							WHERE N.NUM BETWEEN 1 AND 20