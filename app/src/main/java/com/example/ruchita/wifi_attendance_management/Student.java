package com.example.ruchita.wifi_attendance_management;

/**
 * Created by Manali on 10/6/2017.
 */

public class Student {

    //private variables
    int rollno;
    String name;
    String branch;
    String division;
    String year;
    String HardwareAddress;
    String mobile_no;
    int attendance;
    String password;

    // Empty constructor
    public Student(){

    }
    // constructor

    public Student(int rollno, String name, int att){
        this.rollno = rollno;
        this.name = name;
        this.attendance = att;

    }

    // constructor
    public Student(String name, String branch){
        this.name = name;
        this.branch = branch;
    }
    // getting ID
    public int getID(){
        return this.rollno;
    }

    // setting id
    public void setID(int id){
        this.rollno = id;
    }

    // getting name
    public String getName(){
        return this.name;
    }

    // setting name
    public void setName(String name){
        this.name = name;
    }

    // getting division
    public String getDiv(){
        return this.division;
    }

    // setting div
    public void setDiv(String phone_number){
        this.division = phone_number;
    }

    // getting division
    public String getYear(){
        return this.year;
    }

    // setting div
    public void setYear(String phone_number){
        this.year = phone_number;
    }

    // getting division
    public String getBranch(){
        return this.branch;
    }

    // setting div
    public void setBranch(String phone_number){
        this.branch = phone_number;
    }

    // getting division
    public String getAddress(){
        return this.HardwareAddress;
    }

    // setting div
    public void setAddress(String phone_number){
        this.HardwareAddress = phone_number;
    }

    // getting division
    public String getPassword(){
        return this.password;
    }

    // setting div
    public void setPassword(String phone_number){
        this.password = phone_number;
    }

    // getting division
    public String getMobile_no(){
        return this.mobile_no;
    }

    // setting div
    public void setMobile_no(String phone_number){
        this.mobile_no = phone_number;
    }

    // getting division
    public int getAttendance(){
        return this.attendance;
    }

    // setting div
    public void setAttendance(int phone_number){
        this.attendance = phone_number;
    }
}

