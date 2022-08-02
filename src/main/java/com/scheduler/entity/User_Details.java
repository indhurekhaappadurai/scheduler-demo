package com.scheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User_Details{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeIDNumber")
    private int employeeIDNumber;

    @Column(name = "firstName")
    private String firstName;

    @Column(name="frequency")
    private int frequency;
}
