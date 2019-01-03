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

public class ClassroomBag implements Serializable {

	private Classroom[] classrooms;
	private int numOfElems;

	
	public ClassroomBag(int maxSize) {
		
		classrooms = new Classroom[maxSize];
		numOfElems = 0;
	}
	
	public void loadClassroom() {
		try {
			FileInputStream fileInputStream = new FileInputStream("data/classrooms.dat");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			FileInputStream secondInputStream = new FileInputStream("data/numberOfClassrooms.dat");
			DataInputStream dataInputStream = new DataInputStream(secondInputStream);
			numOfElems = dataInputStream.readInt();
			classrooms = (Classroom[]) objectInputStream.readObject();
			objectInputStream.close();
			dataInputStream.close();
		} catch (IOException | ClassNotFoundException e) {
			
		}
	}
	
	public void exportClassroom() {
		File file = new File("data/classrooms.txt");
		if(file !=null) {
		try {
			PrintWriter pw = new PrintWriter(file);
			for(int i = 0; i <classrooms.length;i++) {
				pw.write(" Building: "+classrooms[i].getBuilding()+" Room number: "+classrooms[i].getRoomNumber()+
							"Number of Seats: "+classrooms[i].getNumberOfSeats()+"\n");
			}
			pw.close();
			
		} catch (FileNotFoundException e) {
			}
		}
	}

	public void add(Classroom classroom) {
		if (numOfElems == classrooms.length) {
			doubleArray();
			classrooms[numOfElems++] = classroom;
		} else if(classroom !=null){
			classrooms[numOfElems] = classroom;
			numOfElems++;
		}

	}

	public void doubleArray() {
		Classroom[] temp = classrooms;
		classrooms = new Classroom[classrooms.length +1];
		for (int i = 0; i < temp.length; i++) {
			classrooms[i] = temp[i];
		}
	}

	public void display() {
		for (int i = 0; i < numOfElems; i++) {
			System.out.println(classrooms[i]);
		}
	}

	public Classroom[] getClassrromArray() {
		return Arrays.copyOf(classrooms, numOfElems);
	}

	public int getNumOfElems() {
		return numOfElems;
	}
	
	public boolean checkIfRoomIsAvailable(String roomNumber) {
		boolean isThere = false;
		for(int i = 0; i < numOfElems;i++) {
			if(classrooms[i].getRoomNumber().equals(roomNumber)) {
				isThere=true;
			}
		}return isThere;
	}

	public Classroom removeByRoomNumber(String roomNumber) {
		for (int i = 0; i < numOfElems; i++) {
			if (roomNumber.equalsIgnoreCase(classrooms[i].getRoomNumber())) {
				return removeClassroom(i);
			}
		}
		return null;
	}

	public Classroom removeClassroom(int index) {
		Classroom tempClassroom = classrooms[index];
		for (int i = index; i < numOfElems - 1; i++) {
			classrooms[i] = classrooms[i + 1];

		}
		numOfElems--;
		return tempClassroom;
	}

	public void setCourseByRoomNum(Course course, String roomNum) {
		for (int i = 0; i < numOfElems; i++) {
			if (classrooms[i].getRoomNumber().equals(roomNum)) {
				classrooms[i].setCourse(course);
			}
		}
	}
	
	public void saveClassroom() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("data/classrooms.dat");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			FileOutputStream secondFileStream = new FileOutputStream("data/numberOfClassrooms.dat");
			DataOutputStream dataStream = new DataOutputStream(secondFileStream);
			objectOutputStream.writeObject(classrooms);
			dataStream.writeInt(numOfElems);
			dataStream.close();
			objectOutputStream.close();
		} catch (IOException e) {
			
		}
	}
	

}














