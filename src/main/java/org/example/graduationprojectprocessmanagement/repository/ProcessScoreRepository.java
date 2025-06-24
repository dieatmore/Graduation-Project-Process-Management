package org.example.graduationprojectprocessmanagement.repository;

import org.example.graduationprojectprocessmanagement.dox.ProcessScore;
import org.example.graduationprojectprocessmanagement.dto.ProcessScoreUserDTO;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessScoreRepository extends ListCrudRepository<ProcessScore,String> {

    @Modifying
    @Query("""
            update process_score ps set ps.detail=:detail where ps.id=:processScoreId;
           """)
    void updateScore(String processScoreId, String detail);

//    List<ProcessScore> findByTeacherIdAndProcessId(String teacherId, String processId);

    @Query("""
           select ps.id,name,number, student_id,process_id,teacher_id, detail
           from process_score ps
           right join user u ON ps.student_id = u.id and ps.process_id =:processId
           where u.student ->> '$.teacherId' =:teacherId
           """)
    List<ProcessScoreUserDTO> findByUteacherId(String teacherId, String processId);

    @Query("""     
           select ps.id,name,number,student_id,process_id,teacher_id,detail
           from process_score ps
           right join user u on ps.student_id=u.id and ps.process_id=:processId
           where u.department_id=:departmentId
             and u.group_number=:groupNumber
             and u.id !=:teacherId;
           """)
    List<ProcessScoreUserDTO> findByGroupNumber(String departmentId,String processId,int groupNumber,String teacherId);

    ProcessScore findByProcessIdAndStudentId(String processId, String studentId);
}
