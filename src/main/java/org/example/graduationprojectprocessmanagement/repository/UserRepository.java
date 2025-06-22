package org.example.graduationprojectprocessmanagement.repository;

import org.example.graduationprojectprocessmanagement.dox.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends ListCrudRepository<User, String> {

    User findByNumber(String number);

    @Query("""
           select * from user u where u.department_id=:departmentId and u.student->>'$.teacherId'=:teacherId;
           """)
    List<User> findStudentByTeacherId(String departmentId, String teacherId);

    @Query("""
           select * from user u where u.department_id=:departmentId and u.role=:role and u.group_number=:groupNumber;
           """)
    List<User> findByRoleAndGroupNumber(String departmentId, String role, int groupNumber);
}
