explain
select * from process p
where p.id = '1386211231264301056';

explain
select * from process p
where p.id = '1386211231264301056' and p.department_id = '1385868917132124160';

select * from user u where u.department_id='1385868917132124160' and u.student ->> '$.teacherId' = '1385826789966927296';
