package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import model.Nurse;
import model.Patient;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import tool.Add;
import tool.Check;
import viewer.Menu;

public class ListNurse extends HashMap<String, Nurse> {

    Scanner sc = new Scanner(System.in);
    Menu menu = new Menu();
    Add add = new Add();
    ListPatient listP = new ListPatient();

    public boolean addNewNurse(Nurse n) {
        if ((this.isExistStaffID(n.getStaffID())) || (this.isExistID(n))) {
            return false;
        } else {
            this.put(n.getStaffID(), n);
            return true;
        }
    }

    public boolean isExistStaffID(String staffID) {
        return this.containsKey(staffID);
    }

    public boolean existIDOfN(String ID) {
        for (Nurse N : this.values()) {
            if (N.getID().equals(ID)) {
                return true;
            }
        }
        return false;
    }

    public String checkIDOfNurse() {
        String id = null;
        boolean c = true;
        do {
            id = add.addID();
            if (id.trim().equals("")) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (this.existIDOfN(id)) {
                System.out.println("   (!) ID da ton tai! Try again.");
            } else {
                c = false;
            }
        } while (c);
        return id;
    }

    public String checkStaffID() {
        boolean c = true;
        String staffID = null;
        do {
            staffID = add.addStaffID();
            if (staffID.trim().equals("")) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (this.isExistStaffID(staffID)) {
                System.out.println("   (!) StaffID da ton tai !!! try again.");
            } else {
                c = false;
            }
        } while (c);
        return staffID;
    }

    public boolean isExistID(Nurse n) {
        return this.containsValue(n.getID());
    }

    public boolean isExistName(String name) {
        for (Nurse N : this.values()) {
            if (N.getName().equals(name.trim())) {
                return true;
            }
        }
        return false;
    }

    //Các hàm của phương thức find
    public Nurse findNurse(String name) {
        Nurse N = null;
        for (Nurse n : this.values()) {
            if (n.getName().equals(name)) {
                N = n;
            }
        }
        return N;
    }

    public void findN() {
        boolean find = true;
        do {
            String name_ = add.addName();
            if (this.isExistName(name_)) {
                System.out.println(this.findNurse(name_));
                find = false;
            } else {
                System.out.println("   (!) Nurse does not exist");
                int find_ = 0;
                do {
                    menu.findNurse();
                    find_ = sc.nextInt();
                    sc.nextLine();
                    switch (find_) {
                        case 0:
                            System.out.println("       Exit");
                            find = false;
                            break;
                        case 1:
                            find_ = 0;
                            break;
                    }
                } while (find_ != 0);
            }
        } while (find);
    }
//Các hàm của phương thức update

    public void uppdateStaffID() {
        String staffID;
        staffID = add.addStaffID();
        boolean b = this.isExistStaffID(staffID);
        if (b == false) {
            System.out.println("   (!) Nurse does not exist");
        } else {
            this.updateNurse(staffID);
        }
    }

    public void updateGender(Nurse a) {
        String gender = add.addGender();
        a.setGener(gender);
        System.out.println("       Update Success");
    }

    public void updateAddress(Nurse a) {
        String address = add.addAddress();
        a.setAddress(address);
        System.out.println("       Update Success");
    }

    public void updatePhoneNumber(Nurse a) {
        String phoneNumber = add.addPhoneNumber();
        a.setPhoneNumber(phoneNumber);
        System.out.println("       Update Success");
    }

    public void updateDepartment(Nurse a) {
        String deparment = add.addDepartment();
        a.setDepartmnet(deparment);
        System.out.println("       Update Success");
    }

    public void updateShift(Nurse a) {
        String shift = add.addShift();
        a.setShift(shift);
        System.out.println("       Update Success");
    }

    public void updateSalary(Nurse a) {
        double salary = add.addSalary();
        a.setSalary(salary);
        System.out.println("       Update Success");
    }

    public void updateNurse(String staffID) {
        int b = 0;
        Nurse a = this.get(staffID);
        Menu menu = new Menu();
        do {
            menu.updateNurse();
            b = sc.nextInt();
            sc.nextLine();
            switch (b) {
                case 0:
                    System.out.println("       Exit");
                    break;
                case 1:
                    this.updateGender(a);
                    break;
                case 2:
                    this.updateAddress(a);
                    break;
                case 3:
                    this.updatePhoneNumber(a);
                    break;
                case 4:
                    this.updateDepartment(a);
                    break;
                case 5:
                    this.updateShift(a);
                    break;
                case 6:
                    this.updateSalary(a);
                    break;
                default:
                    System.out.println("       Try Again");
            }
        } while (b != 0);
    }
//Các hàm của phương thức Delete

    public boolean continueDeleteIfExist(boolean delete) {
        delete = true;
        System.out.println("       Delete Fail");
        int delete__ = 0;
        do {
            menu.deleteNurse();
            delete__ = sc.nextInt();
            sc.nextLine();
            switch (delete__) {
                case 0:
                    System.out.println("       Exit");
                    delete = false;
                    break;
                case 1:
                    delete__ = 0;
                    break;
            }
        } while (delete__ != 0);
        return delete;
    }

    public boolean checkDelete(boolean delete, String staffID_, boolean x) {
        delete = true;
        boolean q = true;
        do {
            menu.check();
            String check_ = sc.nextLine();
            if (check_.trim().equals("y")) {
                q = false;
                if (!x) {
                    delete = false;
                    System.out.print(this.deleteNurse(staffID_));
                } else {
                    delete = this.continueDeleteIfExist(delete);
                }
            } else if (check_.trim().equals("n")) {
                this.continueDeleteIfNotExist(delete);
                q = false;
                break;
            } else {
                System.out.println("   (!) Try Again");
            }
        } while (q);
        return delete;
    }

    public boolean continueDeleteIfNotExist(boolean delete) {
        delete = true;
        int delete_ = 0;
        do {
            menu.deleteNurse();
            delete_ = sc.nextInt();
            sc.nextLine();
            switch (delete_) {
                case 0:
                    System.out.println("       Exit");
                    delete = false;
                    break;
                case 1:
                    delete_ = 0;
                    break;
            }
        } while (delete_ != 0);
        return delete;
    }


    public String deleteNurse(String staffID) {
        this.remove(staffID);
        return "       Delete Success.\n";
    }
//Phương thức load

    public void loadFile() throws Exception {
        ArrayList<Nurse> arr = new ArrayList<>();
        FileInputStream fileIn = null;
        ObjectInputStream objectIn = null;
        try {
            File file = new File("src\\File\\Nurses.dat");
            fileIn = new FileInputStream(file);
            objectIn = new ObjectInputStream(fileIn);
            Object obj;
            while ((obj = objectIn.readObject()) != null) {
                if (obj instanceof Nurse) {
                    arr.add((Nurse) obj);
                }
            }
            objectIn.close();
            fileIn.close();
            System.out.println("LOADED!!!");
        } catch (EOFException eof) {

        } catch (Exception ex) {
            System.out.println("FAIL!!!");
            throw ex;
        } finally {
            if (objectIn != null) {
                objectIn.close();
            }
            if (fileIn != null) {
                fileIn.close();
            }
        }

        for (Nurse nurse : arr) {
            this.put(nurse.getStaffID(), nurse);
        }
    }
//Phương thức save

    public void saveFile() throws Exception {
        ArrayList<Nurse> list = new ArrayList<>(this.values());
        if (list.isEmpty()) {
            System.out.println("There is no patient in hospital");
        } else {
            FileOutputStream fileOut;
            ObjectOutputStream objectOut;
            try {
                File file = new File("src\\File\\Nurses.dat");
                fileOut = new FileOutputStream(file);
                objectOut = new ObjectOutputStream(fileOut);
                for (Object obj : list) {
                    objectOut.writeObject(obj);
                }
                objectOut.flush();
                objectOut.close();
                fileOut.close();
                System.out.println("SAVED!!!");
            } catch (Exception ex) {
                System.out.println("FAIL!!!");
                throw ex;
            }
        }
    }
}
