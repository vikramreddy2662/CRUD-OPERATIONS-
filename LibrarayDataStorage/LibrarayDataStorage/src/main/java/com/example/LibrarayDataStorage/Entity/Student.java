package com.example.LibrarayDataStorage.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "libraryData")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	@Column(name = "first_name")
	private String firstname;
	@Column(name = "last_name")
	private String lastname;
	private String College;
	@Column(name = "mobile_number")
	private String mobilenumber;
	/* private Date dateOfissue; */	

	public Student(int id, String firstname, String lastname, String college, String mobilenumber) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.College = college;
		this.mobilenumber = mobilenumber;
		//this.dateOfissue = dateOfissue;
	}

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCollege() {
		return College;
	}

	public void setCollege(String college) {
		College = college;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	/*
	 * public Date getDateOfissue() { return dateOfissue; }
	 * 
	 * public void setDateOfissue(Date dateOfissue) { this.dateOfissue =
	 * dateOfissue; }
	 */

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", College=" + College
				+ ", mobilenumber=" + mobilenumber + "]";
	}

}
