package com.massiverun.user.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.massiverun.pojo.Address;
import com.massiverun.pojo.Material;

/**
 * 
 * @author Nilamber Kumar
 *
 */
@Entity
@Table(name="user_detail")
public class UserDetail implements Serializable{

	@Id
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen",strategy="foreign",parameters=@Parameter(name="property",value="user"))
	private Long id;
	
	 
	@PrimaryKeyJoinColumn
	@OneToOne(fetch=FetchType.LAZY)
	private User user;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="dob")
	private Date date;
	
	@Column(name="email")
	private String email;
	
	@Column(name="identification_number")
	private String idNo;
	
	@Column(name="mobile_no")
	private String mobileNo;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="permanent_address",referencedColumnName="id")
	private Address permanentAddress;

	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="correspondance_address",referencedColumnName="id")
	private Address correspondanceAddress;

	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="office_address",referencedColumnName="id")
	private Address officeAddress;

	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="photo_material",referencedColumnName="id")
	private Material photoMaterial;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="doc_material",referencedColumnName="id")
	private Material docMaterial;
	
	
	public Material getPhotoMaterial() {
		return photoMaterial;
	}

	public void setPhotoMaterial(Material photoMaterial) {
		this.photoMaterial = photoMaterial;
	}

	public Material getDocMaterial() {
		return docMaterial;
	}

	public void setDocMaterial(Material docMaterial) {
		this.docMaterial = docMaterial;
	}

	public Address getCorrespondanceAddress() {
		return correspondanceAddress;
	}

	public void setCorrespondanceAddress(Address correspondanceAddress) {
		this.correspondanceAddress = correspondanceAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
	
	
	
}
