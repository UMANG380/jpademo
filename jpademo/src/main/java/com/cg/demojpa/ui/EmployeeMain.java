package com.cg.demojpa.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.cg.demojpa.dto.Address;
import com.cg.demojpa.dto.Department;
import com.cg.demojpa.dto.Employee;
import com.cg.demojpa.dto.Project;
import com.cg.demojpa.service.EmployeeService;
import com.cg.demojpa.service.EmployeeServiceImpl;

public class EmployeeMain {
	
	public static void main(String[] args) throws ParseException {
		EmployeeService service = new EmployeeServiceImpl();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the operation you want to perform");
		System.out.println("1. Insert");
		System.out.println("2. Delete");
		System.out.println("3. View");
		System.out.println("4. Show Salary");
		
	
		int choice = sc.nextInt();
		
		switch(choice) {
				
		case 1: for(int i=0;i<2;i++) {
				
				Employee emp = new Employee();
				Address addr = new Address();
				Project pro = new Project();
				Department dep = new Department();
				
				System.out.println("Enter id");
				int id = sc.nextInt();
				System.out.println("Enter Name");
				String name = sc.next();
				System.out.println("Enter Salary");
				double sal = sc.nextDouble();
				System.out.println("Enter date");
				String date = sc.next();
				SimpleDateFormat st = new SimpleDateFormat("yyyy/MM/dd");
				Date dateNew = st.parse(date);
				System.out.println("Enter city");
				String city = sc.next();
				System.out.println("Enter state");
				String state = sc.next();
				System.out.println("Enter pin code");
				int pincode = sc.nextInt();
				System.out.println("Ennter Project Id");
				int pid = sc.nextInt();
				System.out.println("Enter Project Name");
				String pname = sc.next();
				System.out.println("Enter Project Cost");
				double pcost = sc.nextDouble();
				System.out.println("Enter Department Id");
				int depId =sc.nextInt();
				System.out.println("Enter Department Name");
				String depName = sc.next();
				
				
				emp.setEmpId(id);
				emp.setEmpName(name);
				emp.setEmpSalary(sal);
				emp.setDateOfJoining(dateNew);
				emp.setAddr(addr);
				emp.setProj(pro);
				emp.setDep(dep);
				
				pro.setProjId(pid);
				pro.setProjCost(pcost);
				pro.setProjName(pname);
				
				addr.setCity(city);
				addr.setState(state);
				addr.setPincode(pincode);
				
				dep.setDepId(depId);
				dep.setDepName(depName);
				
				service.addEmployee(emp);
				
				}				
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
