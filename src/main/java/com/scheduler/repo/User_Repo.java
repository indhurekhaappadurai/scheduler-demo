package com.scheduler.repo;

import com.scheduler.entity.User_Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface User_Repo extends JpaRepository<User_Details,Integer> {

    @Query("SELECT v from User_Details v where v.frequency= :frequency")
    public User_Details getByFrequency(@Param("frequency") int frequency);
}
