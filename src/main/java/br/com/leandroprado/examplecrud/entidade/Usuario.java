package br.com.leandroprado.examplecrud.entidade;

import java.util.Date;

public class Usuario {
	private int id;
	private String lastName;
	private String firstName;
	private Date enrollmateDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Date getEnrollmateDate() {
		return enrollmateDate;
	}
	public void setEnrollmateDate(Date enrollmateDate) {
		this.enrollmateDate = enrollmateDate;
	}
	

}
