package org.example.graduationprojectprocessmanagement.repository;

import org.example.graduationprojectprocessmanagement.dox.ProcessScore;
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

    List<ProcessScore> findByTeacherIdAndProcessId(String teacherId, String processId);
}
