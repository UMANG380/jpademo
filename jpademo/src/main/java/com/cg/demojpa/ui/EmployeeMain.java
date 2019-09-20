package com.cg.demojpa.ui;

import java.util.List;
import java.util.Scanner;

import com.cg.demojpa.dto.Employee;
import com.cg.demojpa.service.EmployeeService;
import com.cg.demojpa.service.EmployeeServiceImpl;

public class EmployeeMain {
	
	public static void main(String[] args) {
		EmployeeService service = new EmployeeServiceImpl();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the operation you want to perform");
		System.out.println("1. Insert");
		System.out.println("2. Delete");
		System.out.println("3. View");
		System.out.println("4. Show Salary");
		int choice = sc.nextInt();
		switch(choice) {
				
		case 1: System.out.println("Enter id");
				int id = sc.nextInt();
				System.out.println("Enter Name");
				String name = sc.next();
				System.out.println("Enter Salary");
				double sal = sc.nextDouble();
				Employee emp = new Employee();
				emp.setEmpId(id);
				emp.setEmpName(name);
				emp.setEmpSalary(sal);
				service.addEmployee(emp);
				break;
		case 2: System.out.println("Enter the employee id");
				int eid = sc.nextInt();
				service.removeEmployee(eid);
				break;
		case 3: List<Employee> empList = service.showAll();
				for(Employee employee:empList) {
					System.out.println(employee);
				}
				break;
		case 4:System.out.println("Enter salary range");
		       double min=sc.nextDouble();
		       double max=sc.nextDouble();
			   empList = service.findBetweenSalary(min, max);
			   for(Employee employee:empList) {
				   System.out.println(employee);
			   }
			   break;
		}
	}
}
