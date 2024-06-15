package com.library.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.app.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{

}
