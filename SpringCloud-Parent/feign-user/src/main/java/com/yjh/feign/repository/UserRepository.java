package com.yjh.feign.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yjh.feign.entity.User;


@Repository
public interface UserRepository extends JpaRepository <User, Long> {

}
