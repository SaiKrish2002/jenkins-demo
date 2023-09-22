package com.example.demo;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is mandatory")
	@Size(max = 15)
//owner name is mandatory and should be within 15 values
    private String ownerName;
    @Pattern(regexp = "^[a-zA-Z]+$", message = "city should only contain letters")
    private String city;
	@NotBlank(message = "state is mandatory")
	//state is mandatory
    private String state;
    private Integer pin;
    @Min(value=1000 ,message = "balance should not be less than 0")
    private float balance;
    private Date createdDate;
    private AccountStatus status;
    private ACCOUNTTYPE type;
	public ACCOUNTTYPE getType() {
		return type;
	}
	public void setType(ACCOUNTTYPE type) {
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getPin() {
		return pin;
	}
	public void setPin(Integer pin) {
		// Validate pin to have exactly 6 digits
		String pinStr = String.valueOf(pin);
		if (pinStr.length() == 6) {
			this.pin = pin;
		} else {
			throw new IllegalArgumentException("Pin must have6 digits exactly.");
		}
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public AccountStatus getStatus() {
		return status;
	}
	public void setStatus(AccountStatus status) {
		this.status = status;
	}

    
}
