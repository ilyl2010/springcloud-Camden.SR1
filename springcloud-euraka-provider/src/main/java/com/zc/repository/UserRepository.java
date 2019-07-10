package com.zc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zc.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
