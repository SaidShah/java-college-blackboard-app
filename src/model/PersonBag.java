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

public class PersonBag implements Serializable {
	private Person[] peoples;
	private int numOfElements;


	public PersonBag(int maxSize) {
		peoples = new Person[maxSize];
		numOfElements = 0;
	}

	public PersonBag() {

	}

	public void savePerson() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("data/persons.dat");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			FileOutputStream secondFileStream = new FileOutputStream("data/numberOfPersons.dat");
			DataOutputStream dataStream = new DataOutputStream(secondFileStream);
			objectOutputStream.writeObject(peoples);
			dataStream.writeInt(numOfElements);
			dataStream.close();
			objectOutputStream.close();
		} catch (IOException e) {

		}
	}

	public void loadPersons() {
		try {
			FileInputStream fileInputStream = new FileInputStream("data/persons.dat");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			FileInputStream secondInputStream = new FileInputStream("data/numberOfPersons.dat");
			DataInputStream dataInputStream = new DataInputStream(secondInputStream);
			numOfElements = dataInputStream.readInt();
			peoples = (Person[]) objectInputStream.readObject();
			objectInputStream.close();
			dataInputStream.close();
		} catch (IOException | ClassNotFoundException e) {

		}
	}
	
	public void exportStudents(){
		File file = new File("data/students.txt");
		if(file !=null) {
		try {
			PrintWriter pw = new PrintWriter(file);
			for(int i = 0; i <peoples.length;i++) {
				if(peoples[i] instanceof Student) {
					pw.write("Student First Name: "+peoples[i].getName().getFirstName()+" Last Name: "+peoples[i].getName().getLastName()
								+" Student ID: "+peoples[i].getId()+" Phone Number: "+peoples[i].getPhone()+"\n");
				}
			}
			pw.close();
			
		} catch (FileNotFoundException e) {
			}
		}
	}
	
	public void exportFaculty(){
		File file = new File("data/faculty.txt");
		if(file !=null) {
		try {
			PrintWriter pw = new PrintWriter(file);
			for(int i = 0; i <peoples.length;i++) {
				if(peoples[i] instanceof Faculty) {
					pw.write("Faculty First Name: "+peoples[i].getName().getFirstName()+" Last Name: "+peoples[i].getName().getLastName()
								+" Student ID: "+peoples[i].getId()+" Phone Number: "+peoples[i].getPhone()+"\n");
				}
			}
			pw.close();
			
		} catch (FileNotFoundException e) {
			}
		}
	}
	

	public void add(Person person) {
		if (numOfElements == peoples.length) {
			doubleArray();
			peoples[numOfElements++] = person;
		} else if (person != null) {
			peoples[numOfElements++] = person;
		}
	}

	public void doubleArray() {
		Person[] temp = peoples;
		peoples = new Person[peoples.length + 1];
		for (int i = 0; i < temp.length; i++) {
			peoples[i] = temp[i];
		}
	}

	public Person findById(String id) {
		for (int i = 0; i < numOfElements; i++) {
			if(peoples[i]!=null){
			if (id.equals(peoples[i].getId())) {
				return peoples[i];
			}
			}
		}
		return null;
	}
	
	public Person[] getPersonBag() {
		return peoples;
	}

	public Person[] getPersonBagCopy(){
		return Arrays.copyOf(peoples, numOfElements);
	}

	public Person removeById(String id) {

		for (int i = 0; i < numOfElements; i++) {
			if (peoples[i].getId().equals(id)) {
				return removeIndex(i);
			}
		}
		return null;
	}

	public Person removeIndex(int index) {
		Person tempPerson = peoples[index];
		for (int i = index; i < numOfElements - 1; i++) {
			peoples[i] = peoples[i + 1];
		}
		numOfElements--;
		return tempPerson;
	}
	

	public void display() {
		for (int i = 0; i < numOfElements; i++) {
			System.out.println(peoples[i]);
		}
	}

	public int getPersonBagSize() {
		return numOfElements;
	}

	public Student[] getStudentsArray() {
		Student[] temp = new Student[10];
		int j = 0;
		for (int i = 0; i < numOfElements; i++) {
			if (peoples[i] instanceof Student) {
				temp[j++] = (Student) peoples[i];

			}
		}
		return temp;
	}


	public Faculty[] getFacultyArray() {
		Faculty[] temp = new Faculty[100];
		int j = 0;
		for (int i = 0; i < numOfElements; i++) {
			if (peoples[i] instanceof Faculty) {
				temp[j++] = (Faculty) peoples[i];

			}
		}
		return temp;
	}

	public double getGPACoursesTookById(String idNumber, CourseBag courseBag) {
		Student[] students = getStudentsArray();
		double gpa = 0;
		int index = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				if (idNumber.equals(students[i].getId())) {
					index = i;
					Grade[] grades = students[index].getCoursesTook();
					gpa = CreditsAndGPACalculator.getNewGPA(grades, courseBag);
					return gpa;
				}
			}
		}
		return 0;
	}

	public double getGPACoursesTakingById(String idNumber, CourseBag courseBag) {
		Student[] students = getStudentsArray();
		double gpa = 0;
		int index = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				if (idNumber.equals(students[i].getId())) {
					index = i;
					Grade[] grades = students[index].getCoursesTaking();
					gpa = CreditsAndGPACalculator.getNewGPA(grades, courseBag);
					return gpa;
				}
			}
		}
		return 0;
	}

	public Grade[] getCoursesTakingById(String idNumber){
		Grade[] tempCoursesTaking = new Grade[20];
		for(int i =0; i < peoples.length;i++){
			if(peoples[i]!=null){
			if(idNumber.equals(peoples[i].getId())){
				if(peoples[i] instanceof Student){
					tempCoursesTaking = ((Student) peoples[i]).getCoursesTaking();
				}
			  }
			}
		}return tempCoursesTaking;
	}
	
	
	public Grade[] getCoursesToTakeById(String idNumber){
		Grade[] tempCoursesToTake = new Grade[20];
		for(int i =0; i < peoples.length;i++){
			if(peoples[i]!=null){
			 if(idNumber.equals(peoples[i].getId())){
				if(peoples[i] instanceof Student){
					tempCoursesToTake = ((Student) peoples[i]).getCoursesToTake();
				}
			  }
			}
		}return tempCoursesToTake;
	}
	public boolean checkCoursesTookBoolean(String idNumber, String courseNumber) {
		boolean courseTook = false;
		Grade[] tempCoursesTook = getCoursesTookById(idNumber);
		for(int i =0;i<tempCoursesTook.length;i++) {
			if(courseNumber.equalsIgnoreCase(tempCoursesTook[i].getCourseNumber())) {
				return courseTook = true;
			}
		}return courseTook;
	}

	public boolean checkCoursesTakingBoolean(String idNumber, String courseNumber) {
		boolean courseTaking = false;
		Grade[] tempCoursesTaking = getCoursesTakingById(idNumber);
		for(int i =0;i<tempCoursesTaking.length;i++) {
			if(courseNumber.equalsIgnoreCase(tempCoursesTaking[i].getCourseNumber())) {
				return courseTaking = true;
			}
		}return courseTaking;
	}
	
	public boolean checkCoursesToTakeBoolean(String idNumber, String courseNumber) {
		boolean courseToTake = false;
		Grade[] tempCoursesToTake = getCoursesToTakeById(idNumber);
		for(int i =0;i<tempCoursesToTake.length;i++) {
			if(courseNumber.equalsIgnoreCase(tempCoursesToTake[i].getCourseNumber())) {
				return courseToTake = true;
			}
		}return courseToTake;
	}

	
	
	public boolean findPersonIdBoolean(String id) {
		boolean isFound = false;
		for (int i = 0; i < numOfElements; i++) {
			if (id.equals(peoples[i].getId())) {
				isFound = true;
			}
		}
		return isFound;
	}
	

	public Grade[] getCoursesTookById(String idNumber){
		Grade[] tempCoursesTook= new Grade[20];
		for(int i =0; i < peoples.length;i++){
			if(peoples[i]!=null){
			if(idNumber.equals(peoples[i].getId())){
				if(peoples[i] instanceof Student){
					tempCoursesTook = ((Student) peoples[i]).getCoursesTook();
				}
			  }
			}
		}return tempCoursesTook;
	}
	
	

	public boolean findPersonPasswordBoolean(String password) {
		boolean isFound = false;
		for (int i = 0; i < numOfElements; i++) {
			if (password.equals(peoples[i].getPassword())) {
				isFound = true;
			}
		}
		return isFound;
	}
	
	

	public Person getStudent() {
		for (int i = 0; i < numOfElements; i++) {
			if (peoples[i] instanceof Student) {
				return peoples[i];
			}
		}
		return null;
	}

	public Person getFaculty() {
		for (int i = 0; i < numOfElements; i++) {
			if (peoples[i] instanceof Faculty) {
				return peoples[i];
			}
		}
		return null;
	}

	public Person getPerson(int index) {
		return peoples[index];
	}
}
