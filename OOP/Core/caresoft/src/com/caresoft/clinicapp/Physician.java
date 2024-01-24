package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;
	private Integer IDcopy;
	
	public Physician(Integer IDcopy) {
		super();
		this.IDcopy = IDcopy;
		this.patientNotes = new ArrayList<>();
	}
    
	public boolean assignPin(int pin) {
		String pinToString = String.valueOf(pin);
		boolean pinLength = pinToString.length() == 4;
		if(pinLength) {
			setPin(pin);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean accessAuthorized(Integer confirmedAuthID){
		if(IDcopy.equals(confirmedAuthID)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
	public Integer getIDcopy() {
		return IDcopy;
	}
	
	public void setIDcopy(Integer IDcopy) {
		this.IDcopy = IDcopy;
	}
	
    public ArrayList<String> getPatientNotes() {
    	return patientNotes;
    }
    
    public void setPatientNotes(ArrayList<String> patientNotes) {
    	this.patientNotes = patientNotes;
    }
}
