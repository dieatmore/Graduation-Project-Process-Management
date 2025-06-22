package org.example.graduationprojectprocessmanagement.repository;

import org.example.graduationprojectprocessmanagement.dox.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends ListCrudRepository<User, String> {

    User findByNumber(String number);

//    List<User> findStudentByTeacherId(String departmentId, String teacherId);
}
