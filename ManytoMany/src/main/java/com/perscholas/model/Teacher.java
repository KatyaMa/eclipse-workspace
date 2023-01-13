package com.perscholas.model;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * Teacher class has a collection (Set<E>) of elements, because when you map a many-to-many association, 
 * you should use a Set instead of a List as the attribute type. 
 * Otherwise, Hibernate will take a very inefficient approach to removing entities from the association. 
 * It will remove all records from the association table and re-insert the remaining ones. 
 * You can avoid that by using a Set instead of a List as the attribute type.
 */
@Entity
@Table(name="Teacher")
public class Teacher{
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private int tit;
	private String salary;
	private String Teachername;
	
	 @ManyToMany(targetEntity = Cohort.class)
	 private Set CohortSet;
	public Teacher(String salary, String teachername, Set CohortSet) {
	this.salary = salary;
	this.Teachername = teachername;
	this.CohortSet = CohortSet;
		
	}
	public Teacher() {
		super();
	}
	
	public Set getCohortSet() {
		return CohortSet;
	}
	public void setCohortSet(Set cohortSet) {
		CohortSet = cohortSet;
	}
	public int getTit() {
		return tit;
	}
	public void setTit(int tit) {
		this.tit = tit;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getTeachername() {
		return Teachername;
	}
	public void setTeachername(String teachername) {
		Teachername = teachername;
	}
}