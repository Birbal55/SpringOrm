package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
//        Student student = new Student(2224,"Beerav","Bihar");
//        int r = studentDao.insert(student);
//        System.out.println("done" + r);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean go = true;
        while(go) {
        	System.out.println("Press 1 For add new student");
            System.out.println("Press 2 For display all students");
            System.out.println("Press 3 For get detail of single student");
            System.out.println("Press 4 For delete students");
            System.out.println("Press 5 For update student");
            System.out.println("Press 6 For exit");
        
            
            try {
            	
            	int input = Integer.parseInt(br.readLine());
//            	if(input == 1) {
//            		//add a new student
//            	}else if(input == 2) {
//            		//display
//            	}
            	
            	switch(input) {
            	case 1:
            		//add a new student
            		System.out.println("Enter user id :");
            		int uId = Integer.parseInt(br.readLine());
            		
            		System.out.println("Enter user name :");
            		String uName = br.readLine();
            		
            		System.out.println("Enter user city :");
            		String uCity = br.readLine();
            		
            		Student s = new Student();
            		s.setStudentId(uId);
            		s.setStudentName(uName);
            		s.setStudentCity(uCity);
            		
            		int r = studentDao.insert(s);
            		System.out.println(r + " student added");
            		System.out.println("******************************************");
            		System.out.println();
            		
            		break;
            	case 2:
            		//display all student
            		System.out.println("**************************");
            		List<Student> allStudents = studentDao.getAllStudents();
            		for(Student st : allStudents) {
            			System.out.println("Id : "+ st.getStudentId());
            			
            			System.out.println("Name : "+ st.getStudentName());
            			System.out.println("City : "+ st.getStudentCity());
                		System.out.println("****************************************");
            		}
            		break;
            	case 3:
            		//get single student data
            		System.out.println("Enter user id :");
            		int userId = Integer.parseInt(br.readLine());
            		Student student = studentDao.getStudent(userId);
            		System.out.println("Id : "+ student.getStudentId());
        			
        			System.out.println("Name : "+ student.getStudentName());
        			System.out.println("City : "+ student.getStudentCity());
        			System.out.println("****************************************");
            		
            		break;
            	case 4:
            		//delete student
            		System.out.println("Enter user id :");
            		int Id = Integer.parseInt(br.readLine());
            		studentDao.deleteStudent(Id);
            		System.out.println("Student deleted..");
            		break;
            	case 5:
            		//update the student
            		break;
            	case 6:
            		//exit
            		go =false;
            		break;
            	}
				
			} catch (Exception e) {
				System.out.println("Invalid input try with another one");
				System.out.println(e.getMessage());
			}
        }
        System.out.println("Thankyou for using my application");
        System.out.println("See you soon !!"); 
        }
}
