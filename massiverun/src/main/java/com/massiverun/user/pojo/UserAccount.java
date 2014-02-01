package com.massiverun.user.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_account")
public class UserAccount implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="credit_point")
	private Double creditPoint;
	
	@Column(name="gift_point")
	private Double giftPoint;

	@OneToOne(mappedBy="userAccount")
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getCreditPoint() {
		return creditPoint;
	}

	public void setCreditPoint(Double creditPoint) {
		this.creditPoint = creditPoint;
	}

	public Double getGiftPoint() {
		return giftPoint;
	}

	public void setGiftPoint(Double giftPoint) {
		this.giftPoint = giftPoint;
	}
	
}
