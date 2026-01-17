package com.DBproj;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your choice");
        System.out.println(" 1. Create , 2. Read , 3. Update , 4. Delete");
        int choice = sc.nextInt();
        switch (choice) {

            case 1:
                System.out.println(" enter id , name , email");
                int id = sc.nextInt();
                sc.nextLine();
                String name = sc.nextLine();
                String email = sc.nextLine();
                students student = new students(id, name, email);
                StudentsDAO.createStudent(student);
                break;
            case 2:
                ArrayList<students> list = StudentsDAO.readStudents();
                for (students std : list)
                    System.out.println(std);
                break;

            case 3:
                System.out.println("enter id which you want to update");
                id = sc.nextInt();
                sc.nextLine();
                name = sc.nextLine();
                email = sc.nextLine();
                StudentsDAO.updateStudents(id, name,email);

                break;

            case 4:
                System.out.println("enter id ");
                id = sc.nextInt();
                StudentsDAO.deleteStudent(id);
                break;

            default:
                System.out.println("Enter valid Input");
        }

    }




}