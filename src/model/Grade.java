package model;

import java.io.Serializable;
import java.util.Scanner;

public class Grade implements Serializable{
	private String courseNumber;
	private String courseLetterGrade;
	private double studentGPA;
	transient Scanner keyboard = new Scanner(System.in);

	public Grade(String courseNumber, String courseLetterGrade) {
		super();
		this.courseNumber = courseNumber;
		this.setLetterGrade(checkGrade(courseLetterGrade));
	}

	public Grade(String courseNumber) {
		super();
		this.courseNumber = courseNumber;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getLetterGrade() {
		return courseLetterGrade;
	}

	public void setLetterGrade(String letterGrade) {
		this.courseLetterGrade = letterGrade;
	}

	public String checkGrade(String theGrade) {
		theGrade = theGrade.replaceAll("[^A-DFa-df+]", "");
		while (theGrade.length() >2) {
			System.out.println("please enter a valid grade ");
			theGrade = keyboard.nextLine();
			theGrade = theGrade.replaceAll("[^A-DFa-df+]", "");
		}
		return theGrade;
	}

	public double StudentGPA() {
		studentGPA = 0.0;
		if (courseLetterGrade.equals( "A+")) {
			studentGPA = 4.0;
		} else if (courseLetterGrade.equals( "A")) {
			studentGPA = 3.8;
		} else if (courseLetterGrade.equals( "B+")) {
			studentGPA = 3.4;
		} else if (courseLetterGrade.equals( "B")) {
			studentGPA = 3.0;
		} else if (courseLetterGrade.equals( "C+")) {
					studentGPA = 2.7;
		} else if (courseLetterGrade.equals( "C")) {
				studentGPA = 2.3;
		} else if (courseLetterGrade.equals( "D+")) {
						studentGPA = 2.0;
		} else if (courseLetterGrade.equals( "D")) {
			studentGPA = 1.5;
		} else {
			studentGPA = 0.0;
		}
		return studentGPA;
	}

	@Override
	public String toString() {
		return "Grade courseNumber: " + courseNumber + ", letterGrade: " + courseLetterGrade;
	}
}
