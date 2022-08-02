package com.scheduler.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scheduler.entity.User_Data;
import com.scheduler.entity.User_Details;
import com.scheduler.repo.User_DataRepo;
import com.scheduler.repo.User_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class SchedulerService implements SchedulingConfigurer {

    @Autowired
    UserSevice userSevice;

    @Autowired
    User_Repo user_repo;

    @Autowired
    User_DataRepo user_dataRepo;

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= user_repo.count(); i++) {
                    try {
                        User_Details details = new User_Details();
                        details = userSevice.getByFrequency(i);
                        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(details));
                        User_Data data= new User_Data();
                        data.setFrequency(details.getFrequency());
                        data.setFirstName(details.getFirstName());
                        user_dataRepo.save(data);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                    int seconds = 0;
                    try {
                        seconds = userSevice.getByFrequency(i).getFrequency() * 60000;
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        Thread.sleep(seconds);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        Thread.interrupted();
                    }
                }


            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                Calendar nextExecutionTime = new GregorianCalendar();
                Date lastActualExecutionTime = triggerContext.lastActualExecutionTime();
                nextExecutionTime.setTime(lastActualExecutionTime != null ? lastActualExecutionTime : new Date());
                nextExecutionTime.add(Calendar.MINUTE, getNewExecutionTime());
                return nextExecutionTime.getTime();
            }
        });

    }
//g
    private int getNewExecutionTime() {
        return 1;
    }
}
