package com.alweimine.userinfo.repo;

import com.alweimine.userinfo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseRepo extends JpaRepository<User, Integer> {
}
