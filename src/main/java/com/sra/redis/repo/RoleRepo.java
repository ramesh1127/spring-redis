package com.sra.redis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sra.redis.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

}
