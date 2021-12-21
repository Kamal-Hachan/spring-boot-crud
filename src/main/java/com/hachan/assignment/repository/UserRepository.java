package com.hachan.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hachan.assignment.Bean.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
