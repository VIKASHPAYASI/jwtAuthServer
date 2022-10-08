package com.pp.authserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pp.authserver.entities.User;

@Repository
public interface UserRegistrationRepository extends JpaRepository<User, Long>{

}
