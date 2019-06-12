## 데이터베이스

#### 
```text
스키마 = 데이터베이스
테이블 = 표
```

#### 명령어 정리
```sql
-- SELECT 컬럼명, 컬럼명
-- [FROM 테이블명]
-- [WHERE 조건]
-- [GROUP BY 컬럼명]
-- [HAVING 조건]
-- [ORDER BY 컬럼명 표현]
-- [LIMIT 행카운트]
-- [AS 별칭]
-- [IFNULL(값, 디폴트값)]
-- [CONCAT(sal, '원')] 집어넣기
-- ;

show databases; -- 데이터 베이스 목록 보여달라
show tables; -- 테이블 목록 조회
create database [name]; -- 데이터 베이스 만들기
drop database [name] -- 데이터 베이스 삭제
use [name] -- 데이터 베이스을 선택하여 이용
create table [name]([colum] [type(size)), type(sie) ]) -- 테이블 생성
create table mytable(name VARCHAR(10), price INT(10), local VARCHAR(10)); -- 테이블 생성 예시
desc [name] -- 테이블 구조 보기
insert into [name] ([colum], [colum], ...) values([val], [val], ...); -- 테이블에 데이터 삽입

select [colum], [colum], [colum] -- 열을 선택하고
from [name] -- 테이블에 해당하는 열에 대한 데이터 조회하고
where [condition]; -- 조건에 해당하는 데이터 출력

select empno as 사번, ename as 이름, concat(sal, '원') from emp; -- empno을 '사번'이라 별칭, sal끝에는 '원'을 붙이자
select ENAME from emp where ENAME like '_o%'; -- 두번째 글자가 o인 사람만 출력 _: 1글자, %: 0~n글자
select distinct deptno from emp; -- 중복을 제거하여 출력
select * from emp where COMM is null; -- 커미션이 null 인 사람 조회
select * from emp where deptno = 10 or deptno = 30; -- 파이썬 과 조건연산자는 동일
select * from emp where (job, deptno) in (('manager', 10) ,('salesman', 20)); -- 직책이 매니저 부서번호 10

```