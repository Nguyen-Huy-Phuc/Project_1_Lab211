
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;

public class Patient extends Person implements Serializable
{
    private String diagnosis;
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String nurseAssigned1;
    private String nurseAssigned2;
    public int n;
//----------------------------------------------------------------//
    public Patient( String iD, String name, int age, String gender, String address, String phoneNumber,String diagnosis, String admissionDate, String dischargeDate, String nurseAssigned1, String nurseAssigned2) {
        super(iD, name, age, gender, address, phoneNumber);
        setDiagnosis(diagnosis);
        setAdmissionDate(admissionDate);
        setDischargeDate(dischargeDate);
        setNurseAssigned1(nurseAssigned1);
        setNurseAssigned2(nurseAssigned2);
    }
//----------------------------------------------------------------//
    public String getDiagnosis() {
        return diagnosis;
    }

    public LocalDate getAdmissionDate() {
        return this.admissionDate;
    }

    public LocalDate getDischargeDate() {
        return this.dischargeDate;
    }

    public String getNurseAssigned1() {
        return nurseAssigned1;
    }
    public String getNurseAssigned2() {
        return nurseAssigned2;
    }
    
    public int getN(){
        return n;    
    }
    
  //---------------------------------------------------------------//

    public void setDiagnosis(String diagnosis) {
        if(!diagnosis.trim().equals("")) this.diagnosis = diagnosis;
        else diagnosis = "NULL";
    }


    public void setAdmissionDate(String admissionDate) throws DateTimeParseException {
        LocalDate date = LocalDate.parse(admissionDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
          this.admissionDate = date;
    }

    public void setDischargeDate(String dischargeDate) throws DateTimeParseException {
        LocalDate date = LocalDate.parse(dischargeDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
          this.dischargeDate = date;
    }

    public void setNurseAssigned1(String nurseAssigned1) {
       if(!nurseAssigned1.trim().equals("")) this.nurseAssigned1 = nurseAssigned1;
       else nurseAssigned1 = "NULL";
    }
    public void setNurseAssigned2(String nurseAssigned2) {
       if(!nurseAssigned2.trim().equals("")) this.nurseAssigned2 = nurseAssigned2;
       else nurseAssigned2 = "NULL";
    }
    
    public void setN(int n){
        this.n = n;   
    }
    
//-------------------------------------------------------------------------//
    public String toString(){
        String s = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        s+=String.format("       |%-5d|%-10s|%-15s|%-15s|%-15s|%-15s|\n",n,getID(),dtf.format(getAdmissionDate()),getName(),getPhoneNumber(),getDiagnosis());
        s +="       ";
        for(int i=0;i<82;i++){
            s += "-";
        } 
        s+="\n";
        return s;
    }
}

    

