package com.example.user.bloodbank;

/**
 * Created by user on 3/25/2017.
 */

public class Donor {
    private String name,bloodGroup,sex,age,address,contactNumber;

    public Donor() {
    }

    public Donor(String name, String bloodGroup, String sex, String age, String address, String contactNumber) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
