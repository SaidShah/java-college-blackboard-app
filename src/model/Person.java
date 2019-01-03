package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

public class Person implements Serializable {
	private String id;
	private String phone;
	private Name name;
	private Address address;
	String password;
	private static int idCounter = 0;
	transient Scanner keyboard = new Scanner(System.in);
	transient Scanner input;
	public Person(String phone, Name name, Address address) {

		final int ID_LENGTH = 8;
		File file = new File("data/idCounter.txt");
		try {
			 input = new Scanner(file);
			idCounter = input.nextInt();
			input.close();
		} catch (FileNotFoundException e1) {
		}
		this.id = String.valueOf(idCounter++);

		for (int i = ID_LENGTH; i > String.valueOf(idCounter).length(); i--) {
			id = '0' + id;
		}


		this.setPhone(checkPhone(phone));
		this.name = name;
		this.address = address;

		try {
			PrintWriter pw = new PrintWriter("data/idCounter.txt");
			pw.println(idCounter);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	public Person() {

	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Name getName() {
		return new Name(name);
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getAddress() {
		return new Address(address);
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String checkPhone(String phone) {
		phone = phone.replaceAll("[^0-9]", "");
		while (phone.length() != 10) {
			System.out.println("The phone number is not valid, please enter a valid phone number ");
			phone = keyboard.nextLine();
			phone = phone.replaceAll("[^0-9]", "");
		}
		phone = "(" + phone.substring(0, 3) + ")" + phone.substring(3, 6) + "-" + phone.substring(6, 10);
		return phone;
	}

//	public Student getStudent() {
//		return student;
//	}
//
//	public Faculty getFaculty() {
//		return faculty;
//	}

	public String getId() {
		return id;
	}

	public static void setIdCounter(int idCounter) {
		Person.idCounter = idCounter;
	}

	@Override
	public String toString() {
		return "name: " + name + ", address: " + address + ", id: " + id + ", phone: " + phone;
	}

}
