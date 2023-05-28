package controller;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import model.Patient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Nurse;
import tool.Add;
import tool.Check;

/**
 * Dây là lớp chứa các thao tác đôi với bênh nhân
 *
 * @author Nguyễn Huy Phúc
 */
public class ListPatient extends HashMap<String, Patient> implements Serializable {

    Scanner sc = new Scanner(System.in);
    Add add = new Add();
    Check check = new Check();
    private int n = 0;
//Các hàm của phương thức add
//-----------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Phườn thức thêm 1 bệnh nhân mới
     *
     * @param p
     * @return boolean
     */
    public boolean addNewPatient(Patient p) {
        if (this.containsKey(p.getID())) {
            return false;
        } else {
            this.put(p.getID(), p);
            n++;
            p.setN(n);
            return true;
        }
    }

    /**
     * Kiểm tra ID đầu vào có bị trùng hay không
     *
     * @return boolean
     */
    public String checkIDOfListPatient() {
        String id = null;
        boolean c = true;
        do {
            id = add.addID();
            if (id.trim().equals("")) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (this.existIDOfP(id)) {
                System.out.println("   (!) ID already exist! Try again.");
            } else {
                c = false;
            }
        } while (c);
        return id;
    }

    /**
     * Kiểm tra ý tá thứ 1 có tồn tại và đủ điểu kiện để chăm sóc hay không Chọn
     * làm đầu vào
     *
     * @return String
     */
    public String checkNurseAssignedNumber1() {
        ListNurse listN = new ListNurse();
        boolean c = true;
        String nurseAssigned1 = null;
        do {
            nurseAssigned1 = add.addNurseAssignedNumber1();
            if (nurseAssigned1.trim().equals("")) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (this.coutNurseAssigned(nurseAssigned1.trim()) == 2) {
                System.out.println("   (!) One or more nurses are already assigned to other patients. Please try again.");
            } else {
                c = false;
            }
        } while (c);
        return nurseAssigned1;
    }

    /**
     * Kiểm tra ý tá thứ 2 có tồn tại và đủ điểu kiện để chăm sóc hay không Chọn
     * làm đầu vào
     *
     * @return String
     */
    public String checkNurseAssignedNumber2() {
        ListNurse listN = new ListNurse();
        boolean c = true;
        String nurseAssigned2 = null;
        do {
            nurseAssigned2 = add.addNurseAssignedNumber2();
            if (nurseAssigned2.trim().equals("")) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (this.coutNurseAssigned(nurseAssigned2.trim()) == 2) {
                System.out.println("   (!) One or more nurses are already assigned to other patients. Please try again.");
            } else {
                c = false;
            }
        } while (c);
        return nurseAssigned2;
    }
//Các hàm của phương thức chung
//-----------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Kiểm tra ý tá có tồn tịa hay không
     *
     * @param nurseAssigned
     * @return boolean
     */
    public boolean checkNurseAssigned(String nurseAssigned) {
        for (Patient P : this.values()) {
            if (P.getNurseAssigned1().equalsIgnoreCase(nurseAssigned) || P.getNurseAssigned2().equalsIgnoreCase(nurseAssigned)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Kiểm tra y tá đang chăm sóc bao nhiêu người
     *
     * @param nurseAssigned
     * @return int
     */
    public int coutNurseAssigned(String nurseAssigned) {
        int x = 0;
        for (Patient P : this.values()) {
            if (P.getNurseAssigned1().equalsIgnoreCase(nurseAssigned) || P.getNurseAssigned2().equalsIgnoreCase(nurseAssigned)) {
                x++;
            }
        }
        return x;
    }

    /**
     * Kiểm tra ID của bệnh nhân có tồn tại hay không
     *
     * @param id
     * @return boolean
     */
    public boolean existIDOfP(String id) {
        for (Patient p : this.values()) {
            if (p.getID().equals(id)) {
                return true;
            }
        }
        return false;
    }
//Phương thức display
//-----------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Kiểm tra định dạng ngày bắt đầu Chọn làm đầu vào
     *
     * @return String
     */
    public String checkStartDate() {
        boolean checkD = true;
        String sDate = "";
        do {
            sDate = add.addAdimissionDate();
            String pattern = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/((19|20)\\d\\d)$";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(sDate);
            if (matcher.matches()) {
                checkD = false;
            } else {
                System.out.println("   (!) Please enter correct format (dd/MM/yyyy) !!! Try again.");
            }
        } while (checkD);
        return sDate;
    }

    /**
     * Kiểm tra định dạng ngày kết thúc Chọn làm đầu vào
     *
     * @return
     */
    public String checkEndDate() {
        boolean checkD_ = true;
        String eDate = "";
        do {
            eDate = add.addDischargeDate();
            String pattern = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/((19|20)\\d\\d)$";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(eDate);
            if (matcher.matches()) {
                checkD_ = false;
            } else {
                System.out.println("   (!) Please enter correct format (dd/MM/yyyy) !!! Try again.");
            }
        } while (checkD_);
        return eDate;
    }

    /**
     * Thao tác in ra những bệnh nhân trong khảng thời gian đã cho
     *
     * @param startDate
     * @param endDate
     */
    public void displayPatient(String startDate, String endDate) {
        LocalDate sDate = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate eDate = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        List<Patient> patientList = new ArrayList<>(this.values());
        Collections.sort(patientList, Comparator.comparing(Patient::getN));
        for (Patient p : patientList) {
            if (p.getAdmissionDate().isAfter(sDate) && p.getAdmissionDate().isBefore(eDate)) {
                System.out.println(p);
            }
        }
    }

    /**
     * In ra theo định dạng cho sẵn
     */
    public void displayP() {
        System.out.println("       LIST OF PATIENTS");
        String sDate = this.checkStartDate();
        String eDate = this.checkEndDate();
        System.out.print("       ");
        for (int i = 0; i < 82; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("       |%-5s|%-10s|%-15s|%-15s|%-15s|%-15s|\n", "NO", "Patient ID", "Admission Date", "Full name", "Phone", "Diagnosis");
        System.out.print("       ");
        for (int i = 0; i < 82; i++) {
            System.out.print("-");
        }
        System.out.println();
        this.displayPatient(sDate, eDate);
    }
//Các hàm của Phương thức sort
//-----------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Sort tăng dần theo tên
     */
    public void sortPatientASCByName() {
        List<Patient> patientList = new ArrayList<Patient>(this.values());
        Collections.sort(patientList, new Comparator<Patient>() {
            public int compare(Patient p1, Patient p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });
        for (Patient P : patientList) {
            System.out.println(P);
        }
    }

    /**
     * Sort giảm dần theo tên
     */
    public void sortPatientDESCByName() {
        List<Patient> patientList = new ArrayList<Patient>(this.values());
        Collections.sort(patientList, new Comparator<Patient>() {
            public int compare(Patient p1, Patient p2) {
                return p2.getName().compareTo(p1.getName());
            }
        });
        for (Patient P : patientList) {
            System.out.println(P);
        }
    }

    /**
     * Sort tăng dần theo ID
     */
    public void sortPatientASCByID() {
        List<Patient> patientList = new ArrayList<Patient>(this.values());
        Collections.sort(patientList, new Comparator<Patient>() {
            public int compare(Patient p1, Patient p2) {
                return p1.getID().compareTo(p2.getID());
            }
        });
        for (Patient P : patientList) {
            System.out.println(P);
        }
    }

    /**
     * Sort giảm dần theo ID
     */
    public void sortPatientDESCByID() {
        List<Patient> patientList = new ArrayList<Patient>(this.values());
        Collections.sort(patientList, new Comparator<Patient>() {
            public int compare(Patient p1, Patient p2) {
                return p2.getID().compareTo(p1.getID());
            }
        });
        for (Patient P : patientList) {
            System.out.println(P);
        }
    }

    /**
     * In ra sort tăng dần theo name
     */
    public void displaySortASCByName() {
        for (int i = 0; i < 82; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("       |%-5s|%-10s|%-15s|%-15s|%-15s|%-15s|\n", "NO", "Patient ID", "Admission Date", "Full name", "Phone", "Diagnosis");
        System.out.print("       ");
        for (int i = 0; i < 82; i++) {
            System.out.print("-");
        }
        System.out.println();
        this.sortPatientASCByName();
    }

    /**
     * In ra sort giảm dần theo name
     */
    public void displaySortDESCByName() {
        for (int i = 0; i < 82; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("       |%-5s|%-10s|%-15s|%-15s|%-15s|%-15s|\n", "NO", "Patient ID", "Admission Date", "Full name", "Phone", "Diagnosis");
        System.out.print("       ");
        for (int i = 0; i < 82; i++) {
            System.out.print("-");
        }
        System.out.println();
        this.sortPatientDESCByName();
    }

    /**
     * In ra sort tăng dần theo ID
     */
    public void displaySortASCByID() {
        for (int i = 0; i < 82; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("       |%-5s|%-10s|%-15s|%-15s|%-15s|%-15s|\n", "NO", "Patient ID", "Admission Date", "Full name", "Phone", "Diagnosis");
        System.out.print("       ");
        for (int i = 0; i < 82; i++) {
            System.out.print("-");
        }
        System.out.println();
        this.sortPatientASCByID();
    }

    /**
     * In ra sort dần theo ID
     */
    public void displaySortDESCByID() {
        for (int i = 0; i < 82; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("       |%-5s|%-10s|%-15s|%-15s|%-15s|%-15s|\n", "NO", "Patient ID", "Admission Date", "Full name", "Phone", "Diagnosis");
        System.out.print("       ");
        for (int i = 0; i < 82; i++) {
            System.out.print("-");
        }
        System.out.println();
        this.sortPatientDESCByID();
    }
/**
 * Các thao tác của hàm sort
 */
    public void sortP() {
        boolean check1 = true;
        do {
            System.out.println("       LIST OF PATIENTS");
            String sortedBy = check.checkSortedBy();
            String sortOrder = check.checkSortOrder();
            if (sortOrder.equalsIgnoreCase("asc") && sortedBy.contains("name")) {
                check1 = false;
                this.displaySortASCByName();
            } else if (sortOrder.equalsIgnoreCase("desc") && sortedBy.contains("name")) {
                check1 = false;
                this.displaySortDESCByName();
            } else if (sortOrder.equalsIgnoreCase("asc") && sortedBy.contains("id")) {
                check1 = false;
                this.displaySortASCByID();
            } else if (sortOrder.equalsIgnoreCase("desc") && sortedBy.contains("id")) {
                check1 = false;
                this.displaySortDESCByID();
            } else {
                System.out.println("       Try Again");
            }
        } while (check1);
    }
//Phương thức load
//-----------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Phương thức lấy dữ liệu từ file Patients
     *
     * @throws Exception
     */
    public void loadFile() throws Exception {
        ArrayList<Patient> arr = new ArrayList<>();
        FileInputStream fileIn = null;
        ObjectInputStream objectIn = null;
        try {
            File file = new File("src\\File\\Patients.dat");
            fileIn = new FileInputStream(file);
            objectIn = new ObjectInputStream(fileIn);
            Object obj;
            while ((obj = objectIn.readObject()) != null) {
                if (obj instanceof Patient) {
                    arr.add((Patient) obj);
                }
            }
            objectIn.close();
            fileIn.close();

        } catch (EOFException eof) {
            System.out.println("       LOADED!!!");
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

        for (Patient patient : arr) {
            this.put(patient.getID(), patient);
        }
    }
//Phương thức save
//-----------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * Phương thức lưu dữ liệu của bệnh nhân trong chương trình vào file
     * Patients
     *
     * @throws Exception
     */
    public void saveFile() throws Exception {
        ArrayList<Patient> list = new ArrayList<>(this.values());
        if (list.isEmpty()) {
            System.out.println("       There is no patient in hospital");
        } else {
            FileOutputStream fileOut;
            ObjectOutputStream objectOut;
            try {
                fileOut = new FileOutputStream("src\\File\\Patients.dat");
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
