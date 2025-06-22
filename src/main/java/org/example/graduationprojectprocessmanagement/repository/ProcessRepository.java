package org.example.graduationprojectprocessmanagement.repository;


import org.example.graduationprojectprocessmanagement.dox.Process;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessRepository extends ListCrudRepository<Process,String> {

    List<Process> findByDepartmentIdAndAuth(String departmentId,String auth);

    List<Process> findByDepartmentId(String departmentId);

    Process findByIdAndDepartmentId(String id,String departmentId);
}
