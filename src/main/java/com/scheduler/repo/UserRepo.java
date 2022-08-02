package com.scheduler.repo;

import com.scheduler.entity.User_Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User_Details,Integer> {
}
