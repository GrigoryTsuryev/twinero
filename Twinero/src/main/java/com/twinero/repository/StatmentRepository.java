package com.twinero.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twinero.jpa.Statment;



@Repository
public interface StatmentRepository extends JpaRepository<Statment, Serializable>  {

}
