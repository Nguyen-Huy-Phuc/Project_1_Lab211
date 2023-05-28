package viewer;

import model.Nurse;
import model.Patient;
import controller.ListNurse;
import controller.ListPatient;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tool.Add;
import tool.Check;

public class Main {

    public static void main(String[] args) throws IOException, Exception {
        ListNurse listN = new ListNurse();
        ListPatient listP = new ListPatient();
        Check check = new Check();
        Scanner sc = new Scanner(System.in);
        Add add = new Add();
        // y tá đc add sẵn
        Nurse n1 = new Nurse("001", "Thao", "25", "Female", "Kon Tum", "012456789", "YT01", "Dieu Duong", "Sang", "15000000");
        Nurse n2 = new Nurse("002", "Tien", "25", "Female", "Kon Tum", "012456789", "YT02", "Phu ta", "chieu", "5000000");
        Nurse n3 = new Nurse("003", "Tam", "25", "Male", "Kon Tum", "012456789", "YT03", "Dieu Duong", "toi", "20000000");
        Nurse n4 = new Nurse("004", "The", "25", "Male", "Kon Tum", "012456789", "YT04", "Dieu Duong", "toi", "21000000");
        Nurse n5 = new Nurse("005", "Phuc", "25", "Male", "Kon Tum", "012456789", "YT05", "Giam Doc", "full time", "100000000");
        listN.addNewNurse(n1);
        listN.addNewNurse(n2);
        listN.addNewNurse(n3);
        listN.addNewNurse(n4);
        listN.addNewNurse(n5);
        // Bệnh nhân đc add sẵn
        Patient p1 = new Patient("P0006", "Cir Smith", "30", "Male", "Kon Tum", "0939064869", "Flu", "10/01/2023", "15/05/2023", "YT01", "YT02");
        Patient p2 = new Patient("P0007", "Bill Jamie", "30", "Male", "Kon Tum", "0932123495", "Fever", "10/04/2023", "15/05/2023", "YT02", "YT03");
        Patient p3 = new Patient("P0008", "Ann Smith", "30", "Male", "Kon Tum", "0853321452", "Cough", "11/04/2023", "15/05/2023", "YT03", "YT04");
        Patient p4 = new Patient("P0009", "Ronaldo Delima", "30", "Male", "Kon Tum", "0273456910", "flu", "20/04/2023", "15/05/2023", "YT05", "YT01");
        listP.addNewPatient(p1);
        listP.addNewPatient(p2);
        listP.addNewPatient(p3);
        listP.addNewPatient(p4);
//        final String fileN = "src\\File\\Nurses.dat";
//        final String fileP = "src\\File\\Patients.dat";
        int x = -1;
        Menu menu = new Menu();
        do {
            menu.printMenu();
            String check1 = sc.nextLine();
            if (!check1.matches("\\d+")) {
                System.out.println("   (!) Please enter true fomat");
            } else {
                x = Integer.parseInt(check1);
                switch (x) {
                    case 0:
                        System.out.println("       Exit");
                        break;
                    case 1:
                        int n = -1;
                        do {
                            menu.manageNurse();
                            String check2 = sc.nextLine();
                            if (!check2.matches("\\d+")) {
                                System.out.println("   (!) Please enter true fomat");
                            } else {
                                n = Integer.parseInt(check2);
                                switch (n) {
                                    case 0:
                                        System.out.println("       Exit");
                                        break;
                                    case 1:
                                        int m = -1;
                                        do {
                                            menu.createNurse();
                                            String check4 = sc.nextLine();
                                            if (!check4.matches("\\d+")) {
                                                System.out.println("   (!) Please enter true fomat");
                                            } else {
                                                m = Integer.parseInt(check4);
                                                switch (m) {
                                                    case 0:
                                                        System.out.print("       Exit");
                                                        break;
                                                    case 1:
                                                        String iD = listN.checkIDOfNurse();
                                                        String name = check.checkName();
                                                        String age = check.checkAge();
                                                        String gender = check.checkGender();
                                                        String address = check.checkAddress();
                                                        String phoneNumber = check.checkPhoneNumber();
                                                        String staffID = listN.checkStaffID();
                                                        String department = check.checkDepartment();
                                                        String shift = check.checkShift();
                                                        String salary = check.checkSalary();
                                                        Nurse N = new Nurse(iD, name, age, gender, address, phoneNumber, staffID, department, shift, salary);
                                                        listN.addNewNurse(N);
                                                        break;
                                                    default:
                                                        System.out.println("   (!) Try Again");
                                                }
                                            }
                                        } while (m != 0);
                                        break;
                                    case 2:
                                        listN.findN();
                                        break;
                                    case 3:
                                        listN.updateStaffID();
                                        break;
                                    case 4:
                                        boolean delete = true;
                                        do {
                                            String staffID_ = add.addStaffID();
                                            boolean b_ = listN.isExistStaffID(staffID_);
                                            boolean y = listP.checkNurseAssigned(staffID_);
                                            if (b_) {
                                                delete = listN.checkDelete(delete, staffID_, y);
                                            } else {
                                                System.out.println("   (!) Nurse does not exist");
                                                delete = listN.continueDeleteIfNotExist(delete);
                                            }
                                        } while (delete);
                                        break;
                                    case 5:
                                        listN.saveFile();
                                        break;
                                    case 6:
                                        listN.loadFile();
                                        break;
                                    default:
                                        System.out.println("   (!) Try Again");
                                }

                            }
                        } while (n != 0);
                        break;
                    case 2:
                        int y = -1;
                        do {
                            menu.managePatient();
                            String check3 = sc.nextLine();
                            if (!check3.matches("\\d+")) {
                                System.out.println("   (!) Please enter true fomat");
                            } else {
                                y = Integer.parseInt(check3);
                                switch (y) {
                                    case 0:
                                        System.out.println("       Exit");
                                        break;
                                    case 1:
                                        int k = -1;
                                        do {
                                            menu.createPatient();
                                            String check5 = sc.nextLine();
                                            if (!check5.matches("\\d+")) {
                                                System.out.println("   (!) Please enter true fomat");
                                            } else {
                                                k = Integer.parseInt(check5);
                                                switch (k) {
                                                    case 0:
                                                        System.out.println("       Exit");
                                                        break;
                                                    case 1:
                                                        String id = listP.checkIDOfListPatient();
                                                        String name = check.checkName();
                                                        String age = check.checkAge();
                                                        String gender = check.checkGender();
                                                        String address = check.checkAddress();
                                                        String phoneNumber = check.checkPhoneNumber();
                                                        String diagnosis = check.checkDiagnosis();
                                                        String admissionDate = check.checkAdimissionDate();
                                                        String dischargeDate = check.checkDischargeDate();
                                                        String nurseAssigned1 = null;
                                                        boolean checkN1 = true;
                                                        do{
                                                        nurseAssigned1 = listP.checkNurseAssignedNumber1();
                                                        if(!listN.isExistStaffID(nurseAssigned1))
                                                            System.out.println("   (!) Nurse does not exist");
                                                        else 
                                                            checkN1 =  false;
                                                        }while(checkN1);
                                                        String nurseAssigned2 = null;
                                                        boolean checkN2 = true;
                                                        do{
                                                        nurseAssigned2 = listP.checkNurseAssignedNumber2();
                                                        if(!listN.isExistStaffID(nurseAssigned2))
                                                            System.out.println("   (!) Nurse does not exist");
                                                        else 
                                                            checkN2 =  false;
                                                        }while(checkN2);
                                                        Patient P = new Patient(id, name, age, gender, address, phoneNumber, diagnosis, admissionDate, dischargeDate, nurseAssigned1, nurseAssigned2);
                                                        listP.addNewPatient(P);
                                                        break;
                                                    default:
                                                        System.out.println("   (!) Try Again");
                                                }
                                            }
                                        } while (k != 0);
                                        break;
                                    case 2:
                                        listP.displayP();
                                        break;
                                    case 3:
                                        listP.sortP();
                                        break;
                                    case 4:
                                        listP.saveFile();
                                        break;
                                    case 5:
                                        listP.loadFile();
                                        break;
                                    default:
                                        System.out.println("   (!) Try Again");
                                }

                            }
                        } while (y != 0);
                        break;
                    default:
                        System.out.println("   (!) Try Again");
                }

            }
        } while (x != 0);
    }

}
