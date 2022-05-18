package com.assignment.java.question1;

import com.assignment.java.question1.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i< size; i++){
            String empInput = sc.nextLine();
            String[] splitStrings = empInput.split(" ");
            Employee emp = new Employee(Integer.parseInt(splitStrings[0]), splitStrings[1], Integer.parseInt(splitStrings[2]));
            list.add(emp);
        }

        for(Employee e: list) System.out.println(e.toString());

    }
}
