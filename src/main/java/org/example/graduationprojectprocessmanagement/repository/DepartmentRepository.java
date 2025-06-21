package org.example.graduationprojectprocessmanagement.repository;

import org.example.graduationprojectprocessmanagement.dox.Department;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends ListCrudRepository<Department,String> {

    @Query("""
           SELECT EXISTS (
           SELECT 1
           FROM department
           WHERE name=:name);
           """)
    boolean existsByName(String name);
}
