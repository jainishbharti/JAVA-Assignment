package com.assignment.multipledatabases.dao.tenant1;

import com.assignment.multipledatabases.entity.tenant1.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> { }
