package com.sra.redis.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sra.redis.model.Role;
import com.sra.redis.repo.RoleRepo;

@RestController
@RequestMapping("/api/role")
@CrossOrigin(origins = "*")
public class RoleController {

	@Autowired
	private RoleRepo roleRepo;

	private static final Logger log = LoggerFactory.getLogger(RoleController.class);

	@GetMapping("/all")
	@Cacheable(value = "roles", key = "'allRoles'")
	public List<Role> getAllRoles() {
		log.info("started time ----> " + new Date().getSeconds());
		List<Role> roles = roleRepo.findAll();
		log.info("end time ----> " + new Date().getSeconds());

		return (roles);

	}

	@PostMapping("/create")
	public ResponseEntity<Role> postMethodName(@RequestBody Role role) {
		return ResponseEntity.ok().body(roleRepo.save(role));
	}

}
