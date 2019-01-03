package model;

import java.io.Serializable; 
import java.util.Scanner;

public class Address implements Serializable{
	private String streetNumber;
	private String city;
	private String state;
	private String zip;
	private String streetName;
	transient Scanner keyboard = new Scanner(System.in);

	public Address(String streetNumber, String streetName, String city, String state, String zip) {
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.setZip(zip);

	}

	public Address(Address address) {
		this.streetNumber = address.streetNumber;
		this.streetName = address.streetName;
		this.city = address.city;
		this.state = address.state;
		this.zip = address.zip;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		boolean isZip = false;
		do {
			try {
				zip = checkZip(zip);
				isZip = true;
			} catch (ZipCodeException e) {
				System.out.println(e.getMessage());
				zip = keyboard.nextLine();
			}
		} while (!isZip);
	}

	public String checkZip(String thisZip) throws ZipCodeException {
		thisZip = thisZip.replaceAll("[^0-9]", "");
		if (thisZip.length() != 5) {
			throw new ZipCodeException("the zip code is invalid please re-enter a valid zip code ");
		}
		return zip = thisZip;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	@Override
	public String toString() {
		return "" + streetNumber + ", streetName: " + streetName + ", city: " + city + ", state: " + state + ", zip: "
				+ zip;
	}

}
