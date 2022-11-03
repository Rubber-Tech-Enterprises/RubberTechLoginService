package com.rubbertech.security.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "UserRegistration")
public class UserRegistration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private long id;
	@Size(min = 3,max = 8,message = "first Name rage should be 3 to 8")
	private String fName;
	@Size(min = 3,max = 8,message = "last Name rage should be 3 to 8")
	private String LName;
	@Size(min = 3,max = 15,message = "userId rage should be 3 to 15")
	private String userid;
	@Size(min = 8,max = 15,message = "password range  should be 8 to 15")
	private String password;
	@NotNull
	private String confirmPassword;
	@Size(min = 10,max = 13,message = "mobile Number should be 3 to 13")
	private String mobileNumber;
	@Size(min = 8,max = 20,message = "email id should be 8 to 25")
	private String email;
	@NotNull
	private String gendar;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getLName() {
		return LName;
	}
	public void setLName(String lName) {
		LName = lName;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGendar() {
		return gendar;
	}
	public void setGendar(String gendar) {
		this.gendar = gendar;
	}
	@Override
	public int hashCode() {
		return Objects.hash(LName, confirmPassword, email, fName, gendar, id, mobileNumber, password, userid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRegistration other = (UserRegistration) obj;
		return Objects.equals(LName, other.LName) && Objects.equals(confirmPassword, other.confirmPassword)
				&& Objects.equals(email, other.email) && Objects.equals(fName, other.fName)
				&& Objects.equals(gendar, other.gendar) && id == other.id
				&& Objects.equals(mobileNumber, other.mobileNumber) && Objects.equals(password, other.password)
				&& Objects.equals(userid, other.userid);
	}
	@Override
	public String toString() {
		return "UserRegistration [id=" + id + ", fName=" + fName + ", LName=" + LName + ", userid=" + userid
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", gendar=" + gendar + "]";
	}
	public UserRegistration(long id, @Size(min = 3, max = 8, message = "first Name rage should be 3 to 8") String fName,
			@Size(min = 3, max = 8, message = "last Name rage should be 3 to 8") String lName,
			@Size(min = 3, max = 15, message = "userId rage should be 3 to 15") String userid,
			@Size(min = 8, max = 15, message = "password range  should be 8 to 15") String password,
			@NotNull String confirmPassword,
			@Size(min = 10, max = 13, message = "mobile Number should be 3 to 13") String mobileNumber,
			@Size(min = 8, max = 20, message = "email id should be 8 to 25") String email, @NotNull String gendar) {
		super();
		this.id = id;
		this.fName = fName;
		LName = lName;
		this.userid = userid;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.gendar = gendar;
	}
	public UserRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
