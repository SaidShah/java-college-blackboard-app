package model;

import java.io.Serializable;

public class Course implements Serializable{

	private String courseTitle;
	private String courseNumber;
	private String textBookISBN;
	private int numOfCredits;
	private String facultyID;

	public Course(String courseTitle, String courseNumber, int numOfCredits) {
		super();
		this.courseTitle = courseTitle;
		this.courseNumber = courseNumber;
		this.numOfCredits = numOfCredits;

	}

	public Course(Course course) {
		super();
		this.courseTitle = course.courseTitle;
		this.courseNumber = course.courseNumber;
		this.numOfCredits = course.numOfCredits;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getTextBookISBN() {
		return textBookISBN;
	}

	public void setTextBookISBN(String textBookISBN) {
		this.textBookISBN = textBookISBN;
	}

	public int getNumOfCredits() {
		return numOfCredits;
	}

	public void setNumOfCredits(int numOfCredits) {
		this.numOfCredits = numOfCredits;
	}

	public String getFacultyID() {
		return facultyID;
	}

	public void setFacultyID(String facultyID) {
		this.facultyID = facultyID;
	}

	@Override
	public String toString() {
		return "Course Title: " + courseTitle + ", courseNumber: " + courseNumber + ", textBookISBN: " + textBookISBN
				+ ", numOfCredits: " + numOfCredits + ", facultyID: " + facultyID;
	}
}
