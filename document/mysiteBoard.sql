######################################
# board 만들기
######################################

-- -----------------------------------------------------
# web 계정에서 실행
-- -----------------------------------------------------

-- db 조회 ----------------------------------------------
show databases;
-- db 선택 ----------------------------------------------
use web_db;

show tables;


-- !!!테이블 삭제!!! --------------------------------------------
drop table board;


-- *테이블 생성 --------------------------------------------
create table board(
	no			integer 		primary key		
    ,title		varchar2(500)	not null
    ,content	text
    ,reg_date 	datetime		not null
    ,reg_date 	datetime
);

-- 테이블 조회 --------------------------------------------
select *
from board
;

-- 등록
insert into board
values(null, '강수빈', '1313', '안녕하시렵니까', now())
;

insert into board
values(null, '정성찬', '2222', '안녕하세요', now())
;

insert into board
values(null, '이찬영', '3333', 'Hi~ 에이치아이~', now())
;


insert into board(name, password, content, reg_date)
values('강수빈', '1111', '안녕하수꽈', now())
;

insert into board(name, password, content)
values('이름', '비밀번호', '내용')
;

-- 수정
update board
set 
where no = ?
;



-- 삭제
delete from board
where no = 4
;

