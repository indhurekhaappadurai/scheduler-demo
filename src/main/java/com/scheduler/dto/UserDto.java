package com.scheduler.dto;

public class UserDto {

    public String firstName;
    public int frequency;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public UserDto(String firstName, int frequency) {
        this.firstName = firstName;
        this.frequency = frequency;
    }

}
