package com.scheduler.repo;

import com.scheduler.entity.User_Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_DataRepo extends JpaRepository<User_Data,Integer> {
}
