
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



