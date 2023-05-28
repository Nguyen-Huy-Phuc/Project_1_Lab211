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

/**
 * Đây là lớp chứa các thao tác của y tá
 *
 * @author Nguyễn Huy Phúc
 */
public class ListNurse extends HashMap<String, Nurse> {

    Scanner sc = new Scanner(System.in);
    Menu menu = new Menu();
    Add add = new Add();
    Check check = new Check();
    ListPatient listP = new ListPatient();

    //các phương thức add
//-----------------------------------------------------------------------------------------------------------------------------------------//
    /**
     * Phương thức thêm 1 y tá mới
     *
     * @param n
     * @return boolean
     */
    public boolean addNewNurse(Nurse n) {
        if ((this.isExistStaffID(n.getStaffID())) || (this.isExistID(n))) {
            return false;
        } else {
            this.put(n.getStaffID(), n);
            return true;
        }
    }

    /**
     * Kiểm tra xem ID nhập vào có bị trùng hay không Chọn làm đầu vào
     *
     * @return ID
     */
    public String checkIDOfNurse() {
        String id = null;
        boolean c = true;
        do {
            id = add.addID();
            if (id.trim().equals("")) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (this.existIDOfN(id)) {
                System.out.println("   (!) ID already exist! Try again.");
            } else {
                c = false;
            }
        } while (c);
        return id;
    }

    /**
     * Kiểm tra xem staffID nhập vào có bị trùng hay không Chọn làm đầu vào
     *
     * @return StaffID
     */
    public String checkStaffID() {
        boolean c = true;
        String staffID = null;
        do {
            staffID = add.addStaffID();
            if (staffID.trim().equals("")) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (this.isExistStaffID(staffID)) {
                System.out.println("   (!) StaffID already exist !!! try again.");
            } else {
                c = false;
            }
        } while (c);
        return staffID;
    }
//các Phương thức chung
//-----------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Kiểm tra xem staffID của y tá có tồn tại hay không
     *
     * @param staffID
     * @return boolean
     */
    public boolean isExistStaffID(String staffID) {
        return this.containsKey(staffID);
    }

    /**
     * Kiểm tra xem ID của y tá có tồn tại hay không bằng ID
     *
     * @param ID
     * @return boolean
     */
    public boolean existIDOfN(String ID) {
        for (Nurse N : this.values()) {
            if (N.getID().equals(ID)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Kiểm tra xem ID của y tá có tồn tại hay không bằng ý tá đó
     *
     * @param n
     * @return boolean
     */
    public boolean isExistID(Nurse n) {
        return this.containsValue(n.getID());
    }

    /**
     * Kiểm tra xem tên ý tá đó có tồn tại hay không
     *
     * @param name
     * @return
     */
    public boolean isExistName(String name) {
        for (Nurse N : this.values()) {
            if (N.getName().equals(name.trim())) {
                return true;
            }
        }
        return false;
    }

    //Các hàm của phương thức find
    //-----------------------------------------------------------------------------------------------------------------------------------------//
    /**
     * Phương thức tìm ý tá theo tên
     *
     * @param name
     * @return Nurse
     */
    public Nurse findNurse(String name) {
        Nurse N = null;
        for (Nurse n : this.values()) {
            if (n.getName().equals(name)) {
                N = n;
            }
        }
        return N;
    }

    /**
     * Các thao tác của phương thức find
     */
    public void findN() {
        boolean find = true;
        do {
            String name_ = add.addName();
            if (this.isExistName(name_)) {
                System.out.println(this.findNurse(name_));
                find = false;
            } else {
                System.out.println("   (!) Nurse does not exist");
                menu.findNurse();
                int find_ = -1;
                String check = sc.nextLine();
                if (!check.matches("\\d+")) {
                    System.out.println("   (!) Please enter true fomat");
                } else {
                    do {
                        find_ = Integer.parseInt(check);
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
            }
        } while (find);
    }
    //Các hàm của phương thức Update
    //-----------------------------------------------------------------------------------------------------------------------------------------//

    public void updateStaffID() {
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
        String gender = check.checkGender();
        a.setGener(gender);
        System.out.println("       Update Success");
    }

    public void updateAddress(Nurse a) {
        String address = check.checkAddress();
        a.setAddress(address);
        System.out.println("       Update Success");
    }

    public void updatePhoneNumber(Nurse a) {
        String phoneNumber = check.checkPhoneNumber();
        a.setPhoneNumber(phoneNumber);
        System.out.println("       Update Success");
    }

    public void updateDepartment(Nurse a) {
        String deparment = check.checkDepartment();
        a.setDepartmnet(deparment);
        System.out.println("       Update Success");
    }

    public void updateShift(Nurse a) {
        String shift = check.checkShift();
        a.setShift(shift);
        System.out.println("       Update Success");
    }

    public void updateSalary(Nurse a) {
        String salary = check.checkSalary();
        a.setSalary(salary);
        System.out.println("       Update Success");
    }

    /**
     * Các thao tác của phương thức Update
     *
     * @param staffID
     */
    public void updateNurse(String staffID) {
        int b = -1;
        Nurse a = this.get(staffID);
        do {
            menu.updateNurse();
            String check = sc.nextLine();
            if (!check.matches("\\d+")) {
                System.out.println("   (!) Please enter true fomat");
            } else {
                b = Integer.parseInt(check);
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
                        System.out.println("   (!) Try Again");
                }
            }
        } while (b != 0);
    }

    /**
     * Phương thức thao tác tiếp tục nếu staffID có tồn tại
     *
     * @param delete
     * @return boolean
     */
    //Các hàm của phương thức Delete
//-----------------------------------------------------------------------------------------------------------------------------------------//
    public boolean continueDeleteIfExist(boolean delete) {
        delete = true;
        System.out.println("       Delete Fail");
        int delete__ = -1;
        do {
            menu.deleteNurse();
            String check = sc.nextLine();
            if (!check.matches("\\d+")) {
                System.out.println("       Please enter true fomat");
            } else {
                delete__ = Integer.parseInt(check);
                switch (delete__) {
                    case 0:
                        System.out.println("       Exit");
                        delete = false;
                        break;
                    case 1:
                        delete__ = 0;
                        break;
                }
            }
        } while (delete__ != 0);
        return delete;
    }

    /**
     * Phương thức kiểm tra người dùng có xác nhận xóa không
     *
     * @param delete
     * @param staffID_
     * @param x
     * @return boolean
     */
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

    /**
     * Phương thức thao tác tiếp tục nếu staffID không tồn tại
     *
     * @param delete
     * @return boolean
     */
    public boolean continueDeleteIfNotExist(boolean delete) {
        delete = true;
        int delete_ = -1;
        do {
            menu.deleteNurse();
            String check = sc.nextLine();
            if (!check.matches("\\d+")) {
                System.out.println("   (!)  Please enter true fomat");
            } else {
                delete_ = Integer.parseInt(check);
                switch (delete_) {
                    case 0:
                        System.out.println("       Exit");
                        delete = false;
                        break;
                    case 1:
                        delete_ = 0;
                        break;
                    default:
                        System.out.println("   (!) Try Again");
                }
            }
        } while (delete_ != 0);
        return delete;

    }

    /**
     * Phương thức xóa theo staffID
     *
     * @param staffID
     * @return
     */
    public String deleteNurse(String staffID) {
        this.remove(staffID);
        return "       Delete Success.\n";
    }
//Phương thức load
    //-----------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Phương thức lấy dữ liệu từ file Nurses
     *
     * @throws Exception
     */
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
            System.out.println("       LOADED!!!");
        } catch (EOFException eof) {

        } catch (Exception ex) {
            System.out.println("       FAIL!!!");
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
    //-----------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Phương thức lưu dữ liệu của y tá trong chương trình vào file Nurses
     *
     * @throws Exception
     */
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
                System.out.println("       SAVED!!!");
            } catch (Exception ex) {
                System.out.println("       FAIL!!!");
                throw ex;
            }
        }
    }
}
