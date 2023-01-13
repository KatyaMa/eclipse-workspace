package com.HibernateAnnotation.HibernateJPA;
import com.hib.controller.findUser_Hql;
/**
In the App.java class, create an object of the findUser_Hql class. And call the findUser() method as shown below: *
 */
public class App 
{
    public static void main( String[] args )
    {
    	findUser_Hql u = new findUser_Hql();
     	//u.findUser();
     	
     	//u.findUserSelect();

   	    //u.getRecordbyId();

   	    //u.getrecords();
   	    
   	    //u.getmaxSalary();
   	    
   	    u.getmaxSalaryGroupBy();
    }
}
