package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Distinct
//    @Query(value = "select distinct from User u where u.firstName=:firstName and u.lastName=:lastName")
    public List<User> findDistinctByFirstNameAndLastName(String firstName, String lastName);

    @Query(value="select * from User u inner join Address a on u.id = a.user_id where a.city=?1")
    public List<User> getAllUser(String city);


}
