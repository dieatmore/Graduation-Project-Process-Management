explain
select * from process p
where p.id = '1386211231264301056';

explain
select * from process p
where p.id = '1386211231264301056' and p.department_id = '1385868917132124160';

select * from user u where u.department_id='1385868917132124160' and u.student ->> '$.teacherId' = '1385826789966927296';


UPDATE process_score ps
SET ps.detail = '{
  "teacherName": "王老师",
  "score": 88.5,
  "detail": [
    {"number": "STU2023001", "score": 92},
    {"number": "STU2023002", "score": 85},
    {"number": "STU2023003", "score": 88}
  ]
}'
WHERE ps.id = '1234567890123456789';

SELECT  ps.id, student_id,name, process_id,teacher_id, detail
FROM process_score ps
         JOIN user u ON ps.student_id = u.id
WHERE ps.process_id =1385934577505820672
  AND u.student ->> '$.teacherId' =1385826789966927296;

select ps.id,name,number, student_id,process_id,teacher_id, detail
from process_score ps
         right join user u ON ps.student_id = u.id and ps.process_id =1385934577505820672
where u.student ->> '$.teacherId' =1385826789966927296;