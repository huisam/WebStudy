-- 1번
select * from emp where year(hiredate) = 2014;
-- 2번
select * from emp where ename like '%S%';
-- 3번
select * from emp where comm is null;
-- 4번
select avg(sal), max(sal), min(sal), count(sal) from emp group by deptno;
-- 5번
select ename, deptno, sal, (sal*12)*1.5 as '연봉' from emp where deptno = 30;
-- 6번
select ename, sal, format(sal*0.15,0) as '경조비' from emp where sal >= 2000;
-- 7번
select deptno, avg(sal), sum(sal), max(sal), min(sal) from emp group by deptno order by avg(sal) desc;