package tool;

import controller.ListNurse;
import controller.ListPatient;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Nurse;
import model.Patient;

/**
 * Lớp kiểm tra thông tin đầu vào
 *
 * @author Nguyễn Huy Phúc
 */
public class Check {

    Add add = new Add();
    Scanner sc = new Scanner(System.in);

    public String checkName() {
        String name = null;
        boolean c = true;
        do {
            name = add.addName();
            if (!name.trim().equals("")) {
                c = false;
            } else {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            }
        } while (c);
        return name;
    }

    public String checkAge() {
        boolean c = true;
        String age = null;
        do {
            age = add.addAge();
            if (age.trim().equals("")) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (!age.matches("\\d+")) {
                System.out.println("   (!) Age is not true !!! try again.");
            } else {
                c = false;
            }
        } while (c);
        return age;
    }

    public String checkGender() {
        boolean c = true;
        String gender = null;
        do {
            gender = add.addGender();
            if (!gender.trim().equals("")) {
                c = false;
            } else {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            }
        } while (c);
        return gender;
    }

    public String checkAddress() {
        boolean c = true;
        String address = null;
        do {
            address = add.addAddress();
            if (!address.trim().equals("")) {
                c = false;
            } else {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            }
        } while (c);
        return address;
    }

    public String checkPhoneNumber() {
        boolean c = true;
        String phoneNumber = null;
        do {
            phoneNumber = add.addPhoneNumber();
            if (phoneNumber.trim().equals("")) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (!phoneNumber.matches("\\d+")) {
                System.out.println("   (!) Phone number is not true !!! try again.");
            } else {
                c = false;
            }
        } while (c);
        return phoneNumber;
    }

    public String checkDiagnosis() {
        boolean c = true;
        String diagnosis = null;
        do {
            diagnosis = add.addDiagnosis();
            if (!diagnosis.trim().equals("")) {
                c = false;
            } else {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            }
        } while (c);
        return diagnosis;
    }

    public String checkAdimissionDate() {
        boolean c = true;
        String adimissionDate = null;
        do {
            adimissionDate = add.addAdimissionDate();
            String pattern = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/((19|20)\\d\\d)$";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(adimissionDate);
            if (matcher.matches()) {
                c = false;
            } else {
                System.out.println("   (!) Please enter correct format (dd/MM/yyyy) !!! Try again.");
            }
        } while (c);
        return adimissionDate;
    }

    public String checkDischargeDate() {
        boolean c = true;
        String dischargeDate = null;
        do {
            dischargeDate = add.addDischargeDate();
            String pattern = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/((19|20)\\d\\d)$";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(dischargeDate);
            if (matcher.matches()) {
                c = false;
            } else {
                System.out.println("   (!) Please enter correct format (dd/MM/yyyy) !!! Try again.");
            }
        } while (c);
        return dischargeDate;
    }

    public String checkDepartment() {
        boolean c = true;
        String department = null;
        do {
            department = add.addDepartment();
            if (department.length() > 50) {
                System.out.println("   (!) Enter up to 50 characters !!! try again.");
            } else if (department.trim().equals("")) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else {
                c = false;
            }
        } while (c);
        return department;
    }

    public String checkShift() {
        boolean c = true;
        String shift = null;
        do {
            shift = add.addShift();
            if (!shift.trim().equals("")) {
                c = false;
            } else {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            }
        } while (c);
        return shift;
    }

    public String checkSalary() {
        boolean c = true;
        String salary = null;
        do {
            salary = add.addSalary();
            if (salary.trim().equals("")) {
                System.out.println("   (!) Please enter a non-null value !!! Try again.");
            } else if (!salary.matches("\\d+")) {
                System.out.println("   (!) Salary is not true !!! try again.");
            } else {
                c = false;
            }
        } while (c);
        return salary;
    }

    public String checkSortedBy() {
        boolean check = true;
        String sortedBy = null;
        do {
            sortedBy = add.addSortedBy();
            if (sortedBy.equalsIgnoreCase("name") || sortedBy.equalsIgnoreCase("id")) {
                check = false;
            } else {
                System.out.println("   (!) Try Again");
            }
        } while (check);
        return sortedBy;
    }

    public String checkSortOrder() {
        boolean check = true;
        String sortedOrder = null;
        do {
            sortedOrder = add.addSortOrder();
            if (sortedOrder.contains("asc") || sortedOrder.contains("desc")) {
                check = false;
            } else {
                System.out.println("   (!) Try Again");
            }
        } while (check);
        return sortedOrder;
    }

}
