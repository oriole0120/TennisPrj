SELECT * FROM FREEBOARDS;

INSERT INTO FREEFILES
	VALUES('tennis', '23', GETDATE(), 'aaaaaa');
	
INSERT INTO PHOTOBOARDS 
	VALUES('2', 'deian', GETDATE(), '샘플데이터', '사진도 없닼ㅋㅋㅋ', 0, 0, 'B');
	
INSERT INTO PHOTOBOARDS 
	VALUES('3', 'deian', GETDATE(), '샘플데이터2', '사진어케올림?!', 5, 1, 'B');	

INSERT INTO PHOTOBOARDS 
	VALUES('4', 'deian', GETDATE(), '샘플데이터3', '사진도 안되는데 비디오 어캄?', 12, 5, 'B');	
	
INSERT INTO PHOTOBOARDS 
	VALUES('5', 'deian', GETDATE(), '샘플데이터4', '망한건갘ㅋㅋㅋ', 2, 3, 'B');		
	
SELECT N.* FROM (
	SELECT ( ROW_NUMBER() OVER (ORDER BY REGDATE DESC) ) NUM, PHOTOBOARDS.*
	FROM PHOTOBOARDS
	 ) N
WHERE N.NUM BETWEEN 1 AND 20;	

SELECT COUNT(*) CNT FROM PhotoBoards;	
	
SELECT ISNULL(MAX(CAST(CODE AS INT)), 0)+1 CODE FROM PHOTOBOARDS;	
	
INSERT INTO PHOTOBOARDS(CODE, WRITER, REGDATE, TITLE, CONTENTS, HIT, THUMB, AUTHORITY) VALUES(?, ?, Getdate(), ?, ?, 0, 0, 'B');	
	
SELECT * FROM INFORMATIONBOARDS WHERE CODE = '17';	

SELECT * FROM LINKCOURTS;

INSERT INTO LINKCOURTS VALUES ('1', '한성대테니스장', '성북구 삼선동 한성대 테니스장', '765-5528', 'www.hansung.ac.kr');

SELECT N.* FROM (SELECT ( ROW_NUMBER() OVER (ORDER BY REGDATE DESC) ) NUM, FREEBOARDS.*FROM FREEBOARDS WHERE 'title' LIKE '' ) N WHERE N.NUM BETWEEN 1 AND 10;
<<<<<<< HEAD


SELECT * FROM FREEBOARDS WHERE CODE = '11';

select * from linkcourts;

SELECT ISNULL(MAX(CAST(CODE AS INT)), 0)+1 CODE FROM PHOTOFILES";


INSERT INTO PHOTOFILES(PHOTONAME, PHOTOCODE, REGDATE, FILESIZE, FILESRC) 
VALUES('img-sha', '1', GETDATE(), '1,221,668', '/TennisPrj/WebContent/root/members/Gallery/upload/bg-img-sha-orig.png');


SELECT COUNT(*) CNT FROM PHOTOBOARDS


SELECT COUNT(*) CNT FROM PHOTOBOARDS WHERE TITLE LIKE '456';
=======

<<<<<<< HEAD
SELECT * FROM FREEBOARDS WHERE CODE = '11';

=======
<<<<<<< HEAD
SELECT * FROM FREEBOARDS WHERE CODE = '11';

select * from linkcourts;
=======
<<<<<<< HEAD
>>>>>>> refs/remotes/origin/master
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD

SELECT ISNULL(MAX(CAST(CODE AS INT)), 0)+1 CODE FROM PHOTOFILES";

INSERT INTO FREEBOARDS(CODE, WRITER, REGDATE, TITLE, CONTENTS, HIT, THUMB, AUTHORITY) 
VALUES('0', 'admin', Getdate(), 'b', 'c', 0, 0, 'B');

select * from freeboards; 


INSERT INTO PHOTOFILES(PHOTONAME, PHOTOCODE, REGDATE, FILESIZE, FILESRC) 
VALUES('img-sha', '1', GETDATE(), '1,221,668', '/TennisPrj/WebContent/root/members/Gallery/upload/bg-img-sha-orig.png');


SELECT COUNT(*) CNT FROM PHOTOBOARDS

=======
SELECT * FROM FREEBOARDS WHERE CODE = '11';
	
=======
SELECT * FROM FREEBOARDS WHERE CODE = '11';
>>>>>>> refs/remotes/origin/master
>>>>>>> refs/remotes/origin/master
>>>>>>> refs/remotes/origin/master
>>>>>>> refs/remotes/choose_remote_name/master
