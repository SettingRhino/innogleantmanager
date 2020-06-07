1.내장 데이터 베이스를 쓰고, 나중에 옮겨 달기엔 너무 시간이 오래 걸릴듯합니다.
그래서 생각한게 mysql환경을 똑같이 만든 일단 view나 구성도들부터 완성하고 막판에 DB구성하는 식으로..
ex)
DB는 더이상 건들지 말고 일단 홈페이지 흐름도부터 만들기.
막판에 정해진 table구성 만들어서 넣고 끝내기.

일단 초기 DB 상태.
mysql사용자-antmanager
(사용자 추가해서 스키마 지정해주면 됩니다.)
https://diaryofgreen.tistory.com/132
안되면 카톡주세요
패스워드-dlshrmf12!@
스키마-antmanagerdb
만들고 
아래꺼 복붙
create table users(
	username varchar(50) not null primary key,
	password varchar(50) not null,
	enabled boolean not null
);

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

--지금은 일단 security부터 시험해봤습니다.[security-context.xml참고]
	--로그인은 test,test로 로그인 가능.
	-/**부분은 일단 로그인해야 사용가능인데 테스트때마다 로그인하기 귀찮아서 permitAll로 해놨습니다.
	-db서 비번가져오는건 잠시 주석처리
--어차피 각자 DB라서 테스트는 그냥 해도 상관없습니다.
--일단 어떤기능 할지 이것저것 테스트해보고, 필요한 column값 합의해서 AWS에 최종적으로 DB올리면 되니 상관을 없을듯합니다.