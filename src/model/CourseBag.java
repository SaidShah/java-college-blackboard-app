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
import java.util.Arrays;

public class CourseBag implements Serializable{
	private Course[] courseBag;
	private int numOfElements;


	public CourseBag(int maxSize) {
		courseBag = new Course[maxSize];
		numOfElements = 0;
	}

	public void SaveCourse() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("data/courses.dat");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			FileOutputStream secondOutputStream = new FileOutputStream("data/numOfCourses.dat");
			DataOutputStream dataStream = new DataOutputStream(secondOutputStream);
			objectOutputStream.writeObject(courseBag);
			dataStream.writeInt(numOfElements);
			objectOutputStream.close();
			dataStream.close();
		} catch (IOException e) {

		}
	}

	public void loadCoarse() {
		try {
			FileInputStream fileInputStream = new FileInputStream("data/courses.dat");
			ObjectInputStream objectStream = new ObjectInputStream(fileInputStream);
			FileInputStream secondInputStream = new FileInputStream("data/numOfCourses.dat");
			DataInputStream dataStream = new DataInputStream(secondInputStream);
			numOfElements = dataStream.readInt();
			courseBag = (Course[]) objectStream.readObject();
			objectStream.close();
			dataStream.close();
		} catch (IOException | ClassNotFoundException e) {

		}
	}

	public void exportCourses() {
		File file = new File("data/courses.txt");
		if(file !=null) {
		try {
			PrintWriter pw = new PrintWriter(file);
			for(int i = 0; i <courseBag.length;i++) {
				pw.write("Course: "+courseBag[i].getCourseTitle()+"Course Number: "+courseBag[i].getCourseNumber()+"Number of Credits: "+
						courseBag[i].getNumOfCredits()+"Textbook ISBN "+courseBag[i].getTextBookISBN()+"\n");
			}
			pw.close();

		} catch (FileNotFoundException e) {
			}
		}
	}

	public void add(Course course) {
		if (numOfElements == courseBag.length) {
			doubleArray();
			courseBag[numOfElements++] = course;
		} else if (course != null) {
			courseBag[numOfElements++] = course;
		}
	}

	public void doubleArray() {
		Course[] temp = courseBag;
		courseBag = new Course[courseBag.length +1];
		for (int i = 0; i < temp.length; i++) {
			courseBag[i] = temp[i];
		}
	}

	public Course[] getCourseArray() {
		return Arrays.copyOf(courseBag, numOfElements);// deep copy of array
	}


	public int getElements() {
		return numOfElements;
	}

	public void display() {
		for (int i = 0; i < numOfElements; i++) {
			System.out.println(courseBag[i]);
		}
	}

	public Course findByCourseNumber(String courseNumber) {
		for (int i = 0; i < numOfElements; i++) {
			if (courseBag[i].getCourseNumber().equals(courseNumber)) {
				return courseBag[i];
			}
		}
		return null;
	}

	public boolean findByCourseNumberBoolean(String courseNumber) {
		boolean isThere = false;
		for (int i = 0; i < numOfElements; i++) {
			if (courseBag[i].getCourseNumber().equalsIgnoreCase(courseNumber)) {
				isThere=true;
			}
		}
		return isThere;
	}
	


	public Course removeByCourseNumber(String courseNumber) {
		for (int i = 0; i < numOfElements; i++) {
			if (courseBag[i].getCourseNumber().equalsIgnoreCase(courseNumber)) {
				return removeCourse(i);
			}
		}
		return null;
	}

	public Course removeCourse(int cNum) {
		Course tempCourse = courseBag[cNum];
		for (int i = cNum; i < numOfElements - 1; i++) {
			courseBag[i] = courseBag[i + 1];
		}
		numOfElements--;
		return tempCourse;
	}

}
