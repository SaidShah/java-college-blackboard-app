package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Student extends Person implements Serializable{
	private Major major;
	private int coursesTookIndex;
	private int coursesTakingIndex;
	private int coursesToTakeIndex;
	private Grade[] coursesTook = new Grade[2];
	private Grade[] coursesTaking = new Grade[2];
	private Grade[] coursesToTake = new Grade[2];
	transient Scanner input;
	
	public Student(Name name, Address address, String phone, Major major) {
		super(phone, name, address);
/*		coursesTookIndex = 0;
		coursesTakingIndex = 0;
		coursesToTakeIndex = 0;*/
		this.major = major;
		File file = new File("data/coursesTookIndex.txt");
		File file2 = new File("data/coursesTakingIndex.txt");
		File file3 = new File("data/coursesToTakeIndex.txt");
		try {
			 input = new Scanner(file);
			coursesTookIndex = input.nextInt();
			input = new Scanner(file2);
			coursesTakingIndex=input.nextInt();
			input = new Scanner(file3);
			coursesToTakeIndex = input.nextInt();
			input.close();
		} catch (FileNotFoundException e1) {
		}
		
		try {
			PrintWriter pw = new PrintWriter("data/coursesTookIndex.txt");
			pw.println(coursesTookIndex);
			pw.close();
			PrintWriter pw2= new PrintWriter("data/coursesTakingIndex.txt");
			pw2.println(coursesTakingIndex);
			pw2.close();
			PrintWriter pw3= new PrintWriter("data/coursesToTakeIndex.txt");
			pw3.println(coursesToTakeIndex);
			pw3.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public void addCoursesTook(Grade newCoursesTook) {
		if (coursesTookIndex == coursesTook.length) {
			doubleCoursesTookArray();
			coursesTook[coursesTookIndex++] = newCoursesTook;
		} else if (newCoursesTook !=null) {
			coursesTook[coursesTookIndex++] = newCoursesTook;
		}
	}

	public void doubleCoursesTookArray() {
		Grade[] tempTook = coursesTook;
		coursesTook = new Grade[coursesTook.length+1];
		for (int i = 0; i < tempTook.length; i++) {
			if(tempTook[i] !=null) {
			coursesTook[i] = tempTook[i];
			}
		}

		
	}

	public void displayCoursesTook(){
		for(int i = 0; i < coursesTookIndex;i++) {
			System.out.println(coursesTook[i]);
		}
	}

	public Grade[] getCoursesTook() {
		return coursesTook;
	}

	public int getCoursesTookIndex() {
		return coursesTookIndex;
	}

	public void addCoursesTaking(Grade newCoursesTaking) {
		if (coursesTakingIndex == coursesTaking.length) {
			doubleCoursesTakingArray();
			this.coursesTaking[coursesTakingIndex++] = newCoursesTaking;
		} else if(newCoursesTaking !=null){
			coursesTaking[coursesTakingIndex++] = newCoursesTaking;
		}
	}

	public void doubleCoursesTakingArray() {
		Grade[] tempTaking = coursesTaking;
		coursesTaking = new Grade[coursesTaking.length+1];
		for (int i = 0; i < tempTaking.length; i++) {
				if(tempTaking[i]!=null) {
			coursesTaking[i] = tempTaking[i];
			}
		}
	}

	public void displayCoursesTaking() {
		for(int i = 0; i < coursesTakingIndex;i++) {
			System.out.println(coursesTaking[i]);
		}
	}

	public Grade[] getCoursesTaking() {
		return Arrays.copyOf(coursesTaking, coursesTakingIndex);
	}

	public int getCoursesTakingIndex() {
		return coursesTakingIndex;
	}

	public void addCoursesToTake(Grade coursesToTake) {
		if (coursesToTakeIndex == this.coursesToTake.length) {
			doubleCoursesToTakeArray();
			this.coursesToTake[coursesToTakeIndex++] = coursesToTake;
		} else if (coursesToTake != null){
			this.coursesToTake[coursesToTakeIndex++] = coursesToTake;
		}
	}

	public void doubleCoursesToTakeArray() {
		Grade[] tempToTake = this.coursesToTake;
		this.coursesToTake = new Grade[this.coursesToTake.length +1];
		for (int i = 0; i < tempToTake.length; i++) {
			this.coursesToTake[i] = tempToTake[i];
		}
	}
	
	public Grade removeCourseTaking(String courseNumber) {
		
		int courseFound;
		for(courseFound =0;courseFound<coursesTakingIndex;courseFound++) {
			if(coursesTaking[courseFound].getCourseNumber().equalsIgnoreCase(courseNumber)) {
				return removeCourseTakingIndex(courseFound);
			}
		}return null;
	}
	
	public Grade removeCourseTakingIndex(int index) {
		Grade tempGrade=coursesTaking[index];
		for(int i =index;i<coursesTakingIndex-1;i++) {
			coursesTaking[i]=coursesTaking[i+1];
		}
		coursesTakingIndex--;
		return tempGrade;
	}
	

	public void displayCoursesToTake() {
		for(int i = 0; i < coursesToTakeIndex;i++) {
			System.out.println(coursesToTake[i]);
		}
	}

	public int getCoursesToTakeIndex() {
		return coursesToTakeIndex;
	}

	public Grade[] getCoursesToTake() {
		return coursesToTake;
	}
	
	public void exportCoursesToTake() {
		File file = new File("data/coursesToTake.txt");
		if(file !=null) {
		try {
			PrintWriter pw = new PrintWriter(file);
			for(int i = 0; i <coursesToTake.length;i++) {
					pw.write("Course Number: "+coursesToTake[i].getCourseNumber()+"\n");
				
			}
			pw.close();
			
		} catch (FileNotFoundException e) {
			}
		}
	}
	
	public void exportCoursesTaking() {
		File file = new File("data/coursesTaking.txt");
		if(file !=null) {
		try {
			PrintWriter pw = new PrintWriter(file);
			for(int i = 0; i <coursesTaking.length;i++) {
					pw.write("Course Number: "+coursesTaking[i].getCourseNumber()+"\n");
				
			}
			pw.close();
			
		} catch (FileNotFoundException e) {
			}
		}
	}
	
	
	
	@Override
	public String toString() {
		return "Student " + super.toString() + ", major: " + major;
	}

}
