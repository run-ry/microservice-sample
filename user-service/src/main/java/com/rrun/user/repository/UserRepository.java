package com.rrun.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rrun.user.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public List<User> findByStatus(Boolean status);
	public Optional<User> findByUserName(String username);
}
