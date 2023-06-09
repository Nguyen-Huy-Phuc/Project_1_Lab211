package model;

import java.io.Serializable;
/**
 * Lớp chứa các thuộc tính chung của 1 người
 * @author Nguyễn Huy Phúc
 */
public class Person implements Serializable {

    private String iD;
    private String name;
    private String age;
    private String gender;
    private String address;
    private String phoneNumber;
//-------------------------------------------------------------------------------------------------------//

    public Person(String iD, String name, String age, String gender, String address, String phoneNumber) {
        this.iD = iD;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
//-------------------------------------------------------------------------------------------------------//

//-------------------------------------------------------------------------------------------------------//
    public String getID() {
        return iD;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
//-------------------------------------------------------------------------------------------------------//

    public void setID(String iD) {
        if (!iD.trim().equals("")) {
            this.iD = iD;
        } else {
            this.iD = "NULL";
        }
    }

    public void setName(String name) {
        if (!name.trim().equals("")) {
            this.name = name;
        } else {
            this.name = "NULL";
        }
    }

    public void setAge(String age) {
        if (!age.trim().equals("")) {
            this.age = age;
        } else {
            this.age = "NULL";
        }
    }

    public void setGener(String gener) {
        if (!gener.trim().equals("")) {
            this.gender = gener;
        } else {
            this.gender = "NULL";
        }
    }

    public void setAddress(String address) {
        if (!address.trim().equals("")) {
            this.address = address;
        } else {
            this.address = "NULL";
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("\\d+")) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "NULL";
        }
    }
    //-------------------------------------------------------------------------------------------------------//  

    @Override
    public String toString() {
        return String.format("%s,%s,%d,%s,%s", getID(), getName(), getAge(), getGender(), getAddress(), getPhoneNumber());
    }

}
