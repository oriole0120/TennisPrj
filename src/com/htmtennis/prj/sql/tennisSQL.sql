select * from members;

select F.* from (
		select(row_number() over (order by regdate desc)) num, freeboards.* 
			from freeboards where title like '%a%') F where F.num between 1 and 10

select * from LinkCourts;

SHOW VARIABLES LIKE 'c%';

<<<<<<< HEAD
select * from LinkCourts;

select * from schedules;

select * from members;
=======
select [name] collection korean_Wansung_ci_as from [linkcourts];

select*from schedules;
>>>>>>> refs/remotes/origin/master
