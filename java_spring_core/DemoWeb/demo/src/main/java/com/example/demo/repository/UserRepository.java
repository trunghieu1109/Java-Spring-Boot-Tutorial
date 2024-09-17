package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Distinct
//    @Query(value = "select distinct from User u where u.firstName=:firstName and u.lastName=:lastName")
    public List<User> findDistinctByFirstNameAndLastName(String firstName, String lastName);

    @Query(value="select u from tbl_user u inner join tbl_address a on u.id = a.user_id where a.city=?1", nativeQuery = true)
    public List<User> getAllUser(String city);

    public List<User> findByLastName(String lastName);

    public List<User> findByLastNameOrDateOfBirth(String lastName, Date dateOfBirth);

//    find...By....And....
//    read...By....Or.....
//    query...By....And....
//    count...By....Or....
//    get...By....And....

}

