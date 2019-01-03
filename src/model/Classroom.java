package model;

import java.io.Serializable;

public class Classroom implements Serializable{
	private String roomNumber;
	private boolean hasProjector;
	private String building;
	private boolean computerLab;
	private int numberOfSeats;
	private Course course;

	public Classroom(String roomNumber, boolean hasProjector, String building, boolean computerLab, int numberOfSeats) {
		super();
		this.roomNumber = roomNumber;
		this.hasProjector = hasProjector;
		this.building = building;
		this.computerLab = computerLab;
		this.numberOfSeats = numberOfSeats;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public boolean isHasProjector() {
		return hasProjector;
	}

	public void setHasProjector(boolean hasProjector) {
		this.hasProjector = hasProjector;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public boolean isComputerLab() {
		return computerLab;
	}

	public void setComputerLab(boolean computerLab) {
		this.computerLab = computerLab;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Classroom RoomNumber: " + roomNumber + ", hasProjector: " + hasProjector + ", building: " + building
				+ ", computerLab: " + computerLab + ", numberOfSeats: " + numberOfSeats + ", Course: " + getCourse();
	}

}
