package com.example.demo.repository;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(value="select r from Role r inner join UserHasRole ur on r.id = ur.role.id where ur.user.id=:userId")
    List<Role> getAllByUserId(Long userId);

}
