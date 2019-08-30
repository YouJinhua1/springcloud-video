package com.yjh.ribbon.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	public User(Long id, String username) {
		super();
		this.id = id;
		this.username = username;
	}
	
	public User() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	@Column
	private String username;

	@Column
	private short age;

	@Column
	private BigDecimal balance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", age=" + age + ", balance=" + balance
				+ "]";
	}

}
