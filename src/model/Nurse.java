package model;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Nurse extends Person implements Serializable {

    private String staffID;
    private String departmnet;
    private String shift;
    private double salary;
//----------------------------------------------------------------------//

    public Nurse(String iD, String name, int age, String gender, String address, String phoneNumber, String staffID, String departmnet, String shift, double salary) {
        super(iD, name, age, gender, address, phoneNumber);
        this.staffID = staffID;
        this.departmnet = departmnet;
        this.shift = shift;
        this.salary = salary;
    }
//-----------------------------------------------------------------------//

    public String getStaffID() {
        return staffID;
    }

    public String getDepartmnet() {
        return departmnet;
    }

    public String getShift() {
        return shift;
    }

    public double getSalary() {
        return salary;
    }
//---------------------------------------------------------------------//

    public void setStaffID(String staffID) {
        if (!staffID.trim().equals("")) {
            this.staffID = staffID;
        } else {
            this.staffID = "NULL";
        }
    }

    public void setDepartmnet(String departmnet) {
        if (departmnet.length() >= 0 && departmnet.length() <= 50) {
            this.departmnet = departmnet;
        } else {
            this.departmnet = "NULL";
        }
    }

    public void setShift(String shift) {
        if (!shift.trim().equals("")) {
            this.shift = shift;
        } else {
            this.shift = "NULL";
        }
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            this.salary = 0;
        }
    }

//-------------------------------------------------------------------------//     
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###,###,### vnd");
        return String.format("       %s,%s,%d,%s,%s,%s,%s,%s,%s",
                getStaffID(), getName(), getAge(), getGender(), getAddress(), getPhoneNumber(), getDepartmnet(), getShift(), df.format(getSalary()));
    }

}
