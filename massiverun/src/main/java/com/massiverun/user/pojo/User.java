package com.massiverun.user.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;


/**
 * 
 * @author Nilamber Kumar
 *
 */
@Entity
@Table(name="user")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Type(type="yes_no")
	@Column(name="state")
	private Boolean state;
	
	@Type(type="yes_no")
	@Column(name="active")
	private Boolean active;
	

	@Column(name="user_type")
	@Enumerated(EnumType.STRING)
	private UserType userType;

	@Column(name="user_role")
	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	@OneToOne(mappedBy="user",fetch=FetchType.LAZY ,cascade=CascadeType.ALL)
	private UserDetail userDetail;

	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="user_account_id",referencedColumnName="id")
	private UserAccount userAccount;


	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	
	public Long getId() {
		return id;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
		
	}
	
	/**
	 * 
	 * User Type
	 *
	 */
	public static enum UserType
	{
		PREMIUM("premium"),
		NORMAL("normal");
		
		private  String type;
		private UserType(String type)
		{
			this.type=type;
		}
		
		
		public static UserType getUserType(String userTypeVal)
		{
			for(UserType userType:values())
			{
				if(userType.getType().equals(userTypeVal))
				{
					return userType;
				}
			}
			return null;
		}


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}
	}
	
	/**
	 * 
	 * User Role
	 *
	 */
	public static enum UserRole
	{
		ADMIN("premium"),
		USER("user");
		
		private  String role;
		private UserRole(String role)
		{
			this.role=role;
		}
		
		
		public static UserRole getUserRole(String userRoleVal)
		{
			for(UserRole userRole:values())
			{
				if(userRole.getRole().equals(userRoleVal))
				{
					return userRole;
				}
			}
			return null;
		}


		public String getRole() {
			return role;
		}


		public void setType(String role) {
			this.role = role;
		}
	}
	
	
	
}
