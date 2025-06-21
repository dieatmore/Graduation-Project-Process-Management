package org.example.graduationprojectprocessmanagement.repository;

import org.example.graduationprojectprocessmanagement.dox.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    User findByNumber(String number);
}
