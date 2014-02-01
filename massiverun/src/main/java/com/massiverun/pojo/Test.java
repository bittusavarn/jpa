package com.massiverun.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="test")
@GenericGenerator(name="test-gen", strategy = "increment")
public class Test {
	
	@Id
	@Column(name="idtest")
	@GeneratedValue(generator="test-gen")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="role") 
	private String role;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="testRole",referencedColumnName="id") 
	TestRole testRole;

	public TestRole getTestRole() {
		return testRole;
	}

	public void setTestRole(TestRole testRole) {
		this.testRole = testRole;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
