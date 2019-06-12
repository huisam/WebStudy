-- 1번 테이블 구조
desc emp;
-- 2번 이름이 k로 시작하는 
select empno, ename, hiredate, sal from emp where ENAME like 'K%';
-- 3번 입사일이 2000년도인 사람
select * from emp where year(hiredate) = 2000;
-- 4번
select * from emp where comm is not null;
-- 5번
select ename, deptno, sal from emp where deptno = 30 and sal >= 1500;
-- 6번
select * from emp where deptno = 30 order by empno;
-- 7번
select * from emp order by sal desc;
-- 8번
select * from emp order by deptno, sal desc;
-- 9번
select * from emp order by deptno desc, ename, sal desc;
-- 10번
select ename, sal, sal*comm/100 as '커미션 금액', (sal*comm/100 + sal) as '총액' from emp where comm is not null order by (sal*comm/100 + sal) desc;
-- 11번
select ename, sal, (sal)*13/100 as '보너스 금액', deptno from emp where deptno = 10;
-- 12번
select ename, sal, format((sal/60),1) as '시간당 임금' from emp;
-- 13번
select ename, sal, format((sal/100)*15,2) as '회비' from emp where sal >= 1500 and sal <= 3000;
-- 14번
select ename, sal, format((sal/10)*9,0) as '실수령액' from emp order by (sal/10)*9 desc;
-- 15번
select substring(lcase(ename),1,3) from emp where length(ename) >= 6;
-- 16번
select avg(sal), max(sal), min(sal), count(sal) from emp where deptno = 10 group by deptno;
-- 17번
select deptno, job, count(job) from emp group by deptno, job order by deptno;
-- 18번
select deptno, job, count(job) from emp group by deptno, job having count(job) >= 4;
-- 19번
select ename, hiredate, datediff(curdate(),hiredate) as '근무일수' from emp;
-- 20번
select ename, year(curdate()) - year(hiredate) as '근속년수' from emp;
