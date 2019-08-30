package com.yjh.feign.entity;

import java.math.BigDecimal;

public class User {

	private Long id;

	private String name;

	private String username;

	private short age;

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
