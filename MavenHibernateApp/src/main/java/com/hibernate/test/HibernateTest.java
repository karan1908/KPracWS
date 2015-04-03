package com.hibernate.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hibernate.domain.Department;
import com.hibernate.domain.Employee;
import com.hibernate.util.HibernateUtil;
 
public class HibernateTest {
 
public static void main(String[] args) {
          
        Session session = HibernateUtil.getSessionFactory().openSession();
  
        session.beginTransaction();
 
        Department department = new Department("linux");
        
        List<Employee> empList = new ArrayList<Employee>();
        empList.add(new Employee("Manav"));
        empList.add(new Employee("Mithun"));
        
        department.setEmployees(empList);
        
        session.persist(department);
 
        session.getTransaction().commit();
        
        Query q = session.createQuery("From Employee");
                 
        List<Employee> resultList = q.list();
        System.out.println("No.of Employess:" + resultList.size());
        for (Employee next : resultList) {
            System.out.println("Next Employee: " + next);
        }
        
        HibernateUtil.shutdown();
 
    }//main
    
}