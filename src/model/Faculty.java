package model;

import java.io.Serializable;

public class Faculty extends Person implements Serializable {
	private String officeAddress;
	private String salary;
	private String title;

	public Faculty(Name name, Address address, String phone, String officeAddress, String salary, String title) {
		super(phone, name, address);
		this.officeAddress = officeAddress;
		this.salary = salary;
		this.title = title;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Faculty " + super.toString() + ", officeAddress: " + officeAddress + ", salary: " + salary + ", title: "
				+ title;
	}

}
