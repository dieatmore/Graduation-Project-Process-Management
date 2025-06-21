package org.example.graduationprojectprocessmanagement.repository;


import org.example.graduationprojectprocessmanagement.dox.Process;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessRepository extends ListCrudRepository<Process,String> {

}
