
package viewer;


public class Menu {
    
    
    public static void printMenu(){
        System.out.println("      **********************************************************");
        System.out.println("      *       WELCOME TO OPTIONS WITH HOSPITAL MANAGEMENT      *");
        System.out.println("      **********************************************************");
        System.out.println("      *        0. Quit                                         *");
        System.out.println("      *        1. Nurse's management                           *");
        System.out.println("      *        2. Patient's management                         *");
        System.out.println("      **********************************************************");
        System.out.print("      **(Note: Your options from 0 - 2): ");
    }
    
    public static void manageNurse(){
        System.out.println("      ---------------------------------------------------------");
        System.out.println("      |                   NURSE'S MANAGEMENT                   |");
        System.out.println("       -------------------------------------------------------- ");
        System.out.println("      |        0. Quit                                         |");
        System.out.println("      |        1. Create a nurse                               |");
        System.out.println("      |        2. Find the nurse                               |");
        System.out.println("      |        3. Update the nurse                             |");
        System.out.println("      |        4. Delete the nurse                             |");
        System.out.println("      |        5. Save nurse                                   |");
        System.out.println("      |        6. Load nurse                                   |");
        System.out.println("       -------------------------------------------------------- ");
        System.out.print("      **(Note: Your options from 0 - 6): ");
    }
    
    public static void createNurse(){
        System.out.println("       -------------------------------------------------------- ");
        System.out.println("      |                   NURSE'S MANAGEMENT                   |");
        System.out.println("       -------------------------------------------------------- ");
        System.out.println("      |        0. Quit                                         |");
        System.out.println("      |        1. Add another nurse                            |");
        System.out.println("       -------------------------------------------------------- ");
        System.out.print("      **(Note: Your options from 0 - 1): ");
    }
    
    public static void findNurse(){
        System.out.println("       -------------------------------------------------------- ");
        System.out.println("      |        0. Quit                                         |");
        System.out.println("      |        1. Continue find nurse                          |");
        System.out.println("       -------------------------------------------------------- ");
        System.out.print("      **(Note: Your options from 0 - 1): ");
    }
    
    public static void deleteNurse(){
        System.out.println("       -------------------------------------------------------- ");
        System.out.println("      |        0. Quit                                         |");
        System.out.println("      |        1. Continue delete nurse                        |");
        System.out.println("       -------------------------------------------------------- ");
        System.out.print("      **(Note: Your options from 0 - 1): ");
    }
    
    public static void check(){
        System.out.println("       -------------------------------------------------------- ");
        System.out.println("      |                   Are you sure                         |");
        System.out.println("       -------------------------------------------------------- ");
        System.out.println("      |                   y = Yes                              |");
        System.out.println("      |                   n = No                               |");
        System.out.println("       -------------------------------------------------------- ");
        System.out.print("      **(Note: Your options 'y' or 'n' : ");
    }
    
    public static void createPatient(){
        System.out.println("       -------------------------------------------------------- ");
        System.out.println("      |                   PATIENT'S MANAGEMENT                 |");
        System.out.println("       -------------------------------------------------------- ");
        System.out.println("      |        0. Quit                                         |");
        System.out.println("      |        1. Add another patient                          |");
        System.out.println("       -------------------------------------------------------- ");
        System.out.print("      **(Note: Your options from 0 - 1): ");
    }
    
    public static void updateNurse(){
        System.out.println("       -------------------------------------------------------- ");
        System.out.println("      |                   NURSE'S MANAGEMENT                   |");
        System.out.println("       -------------------------------------------------------- ");
        System.out.println("      |        0. Quit                                         |");
        System.out.println("      |        1. Update gender                                |");
        System.out.println("      |        2. Update address                               |");
        System.out.println("      |        3. Update phone                                 |");
        System.out.println("      |        4. Update department                            |");
        System.out.println("      |        5. Update shift                                 |");
        System.out.println("      |        6. Update salary                                |");
        System.out.println("       --------------------------------------------------------");
        System.out.print("      **(Note: Your options from 0 - 6): ");
    }
    
    public static void managePatient(){
        System.out.println("      **********************************************************");
        System.out.println("      |                   PATIENT'S MANAGEMENT                 |");
        System.out.println("      **********************************************************");
        System.out.println("      |        0. Quit                                         |");
        System.out.println("      |        1. Add a patient                                |");
        System.out.println("      |        2. Display patients                             |");
        System.out.println("      |        3. Sort the patients list                       |");
        System.out.println("      |        4. Save patient                                 |");
        System.out.println("      |        5. Load patient                                 |");
        System.out.println("      **********************************************************");
        System.out.print("      **(Note: Your options from 0 - 5): ");
        
    }
}
