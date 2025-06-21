package org.example.graduationprojectprocessmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.example.graduationprojectprocessmanagement.dox.Process;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessRepository extends CrudRepository<Process,String> {

}
