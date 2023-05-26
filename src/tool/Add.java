package tool;

import controller.ListNurse;
import controller.ListPatient;
import java.util.Scanner;
import model.Nurse;
import model.Patient;

public class Add {
    Scanner sc = new Scanner(System.in);

    public String addID() {
        System.out.print("    -> Enter ID: ");
        String id = sc.nextLine();
        return id;
    }

    public String addName() {
        System.out.print("    -> Enter Name: ");
        String name = sc.nextLine();
        return name;
    }

    public int addAge() {
        System.out.print("    -> Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        return age;
    }

    public String addGender() {
        System.out.print("    -> Enter Gender: ");
        String gender = sc.nextLine();
        return gender;
    }

    public String addAddress() {
        System.out.print("    -> Enter Adress: ");
        String address = sc.nextLine();
        return address;
    }

    public String addPhoneNumber() {
        System.out.print("    -> Enter Phone Number: ");
        String phoneNumber = sc.nextLine();
        return phoneNumber;
    }

    public String addStaffID() {
        System.out.print("    -> Enter StaffID: ");
        String staffID = sc.nextLine();
        return staffID;
    }

    public String addDepartment() {
        System.out.print("    -> Enter Department: ");
        String department = sc.nextLine();
        return department;
    }

    public String addShift() {
        System.out.print("    -> Enter Shift: ");
        String shift = sc.nextLine();
        return shift;
    }

    public double addSalary() {
        System.out.print("    -> Enter Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();
        return salary;
    }

    public String addDiagnosis() {
        System.out.print("    -> Enter Diagnosis: ");
        String diagnosis = sc.nextLine();
        return diagnosis;
    }

    public String addAdimissionDate() {
        System.out.print("    -> Enter Adimission Date: ");
        String adimissionDate = sc.nextLine();
        return adimissionDate;
    }

    public String addDischargeDate() {
        System.out.print("    -> Enter DischargeDate: ");
        String dischargeDate = sc.nextLine();
        return dischargeDate;
    }

    public String addNurseAssignedNumber1() {
        System.out.print("    -> Enter Nurse Assigned Number 1: ");
        String nurseAssigned1 = sc.nextLine();
        return nurseAssigned1;
    }

    public String addNurseAssignedNumber2() {
        System.out.print("    -> Enter Nurse Assigned Number 2: ");
        String nurseAssigned2 = sc.nextLine();
        return nurseAssigned2;
    }

    public String addSortedBy() {
        System.out.print("       Sorted by: ");
        String sortedBy = sc.nextLine();
        return sortedBy;
    }

    public String addSortOrder() {
        System.out.print("       Sort order: ");
        String sortOrder = sc.nextLine();
        return sortOrder;
    }
   
    
}
