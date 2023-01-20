package com.SocietyManagementSystem.testscript.Accounts;

import org.testng.annotations.Test;

import com.crm.SocietyManagementSystem.genericLib.BaseClass;
import com.sms.ObjectRepo.AddStudentPage;
import com.sms.ObjectRepo.HomePage;
import com.sms.ObjectRepo.StudentPage;

public class CreateStudentDeleteStudent extends BaseClass {

	@Test
	public void CreateAndDeleteStudent() throws Throwable
	{

		String StudentId = eu.getDataFromExcell("Student1", 0, 1);
		String Firstname = eu.getDataFromExcell("Student1", 1, 1);
		String Middlename = eu.getDataFromExcell("Student1",2, 1);
		String lastname = eu.getDataFromExcell("Student1", 3, 1);
		String Section = eu.getDataFromExcell("Student1", 4, 1);
		HomePage hp = new HomePage(driver);
		hp.clickAccounts();
		hp.clickStudentLink();
		StudentPage sp= new StudentPage(driver);
		sp.clickAddStudentButton();
		
		AddStudentPage asp= new AddStudentPage(driver);
		asp.uploadImage();
		asp.createStudent(wu, StudentId, Firstname, Middlename, lastname, 1, Section);
		//Search Student
		sp.passValueToSearchTB(StudentId);
		sp.deleteStudent(driver, StudentId);
		System.out.println("Student deleted");
		
	}

}
