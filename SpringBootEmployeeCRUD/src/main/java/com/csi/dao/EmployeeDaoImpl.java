package com.csi.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import com.csi.model.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
	
	public static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
	@Override
	public List<Employee> getData() {
		
		Session session = factory.openSession();
		List<Employee> empList = session.createQuery("from Employee").list();
		
		return empList;
	}

	@Override
	public void saveData(Employee employee) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(employee);
		transaction.commit();
	}

	@Override
	public void updateData(int empId, Employee employee) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> empList = session.createQuery("from Employee").list();
		
		for(Employee e: empList) {
			
			if(e.getEmpId()==empId)
			{
				e.setEmpName(employee.getEmpName());
				e.setEmpSalary(employee.getEmpSalary());
				
				session.update(e);
				transaction.commit();
			}
		}
		
	}

	@Override
	public void deleteData(int empId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> empList = session.createQuery("from Employee").list();
		
		for(Employee e: empList) {
			
			if(e.getEmpId()==empId)
			{
				
				 session.delete(e);
				transaction.commit();
			}
		}
	}

}
