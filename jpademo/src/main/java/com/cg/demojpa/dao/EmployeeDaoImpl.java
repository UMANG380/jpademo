package com.cg.demojpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transaction;

import com.cg.demojpa.dto.Employee;
import com.cg.demojpa.dto.Project;

public class EmployeeDaoImpl implements EmployeeDao {
	@PersistenceContext
	
	EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("demojpa");

	public Employee save(Employee emp) {
		
		
		EntityManager em = entityFactory.createEntityManager();
		EntityTransaction tran = em.getTransaction();
		tran.begin();
		//em.persist(emp.getProj());
		em.persist(emp);
		
		
		tran.commit();
		
		
		return null;
	}

	public List<Employee> findAll() {
		
		EntityManager em = entityFactory.createEntityManager();
		Query query = em.createQuery("FROM Employee ");
		List<Employee> empList=query.getResultList();
		return empList;
		
	}

	public void remove(Integer empId) {
		EntityManager em = entityFactory.createEntityManager();
		Employee empRemove=em.find(Employee.class, empId);
		EntityTransaction tran = em.getTransaction();
		tran.begin();
		em.remove(empRemove);
		tran.commit();
	
	}

	public List<Employee> findBetweenSalary(double min, double max) {
		EntityManager em = entityFactory.createEntityManager();
		Query query = em.createQuery("FROM Employee WHERE empSalary BETWEEN :first AND :second");
		query.setParameter("first", min);
		query.setParameter("second", max);
		List<Employee> empList=query.getResultList();
		return empList;
	}

}
