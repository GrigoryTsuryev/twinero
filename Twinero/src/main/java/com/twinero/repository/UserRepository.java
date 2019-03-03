package com.twinero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twinero.jpa.UserDAO;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, String> {

}
