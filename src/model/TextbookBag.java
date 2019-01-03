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

public class TextbookBag implements Serializable{
	private Textbook[] textbag;
	int numOfElements;

	public TextbookBag(int maxSize) {
		textbag = new Textbook[maxSize];
		numOfElements = 0;
	}

	public void saveTextbooks() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("data/textbooks.dat");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			FileOutputStream secondOutputStream = new FileOutputStream("data/numberOfTextbooks.dat");
			DataOutputStream dataStream = new DataOutputStream(secondOutputStream);
			dataStream.writeInt(numOfElements);
			objectOutputStream.writeObject(textbag);
			objectOutputStream.close();
			dataStream.close();
		} catch (IOException e) {

		}
	}
	
	public void loadTextbooks() {
		try {

			FileInputStream fileInputStream = new FileInputStream("data/textbooks.dat");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			FileInputStream secondInputStream = new FileInputStream("data/numberOfTextbooks.dat");
			DataInputStream dataStream = new DataInputStream(secondInputStream);
			numOfElements = dataStream.readInt();
			textbag = (Textbook[]) objectInputStream.readObject();
			objectInputStream.close();
			dataStream.close();
		} catch (IOException | ClassNotFoundException e) {

		}
		
	}
	
	public void exportTextbooks() {
		File file = new File("data/textbooks.txt");
		if(file !=null) {
		try {
			PrintWriter pw = new PrintWriter(file);
			for(int i = 0; i <textbag.length;i++) {
				pw.write("Textbook Title: "+ textbag[i].getTitle()+" Publisher: "+textbag[i].getPublisher()+" ISBN: " + textbag[i].getIsbn()
							+" Price: "+textbag[i].getPrice()+"\n");
			}
			pw.close();
			
		} catch (FileNotFoundException e) {
			}
		}
	}

	public void add(Textbook textbook) {
		if (numOfElements == textbag.length) {
			doubleArray();
			textbag[numOfElements++] = textbook;
		} else if (textbook != null) {
			textbag[numOfElements++] = textbook;
		}
	}

	public void doubleArray() {
		Textbook[] temp = textbag;
		textbag = new Textbook[textbag.length +1];
		for (int i = 0; i < temp.length; i++) {
			textbag[i] = temp[i];
		}
	}

	public void display() {
		for (int i = 0; i < numOfElements; i++) {
			System.out.println(textbag[i]);
		}
	}

	public Textbook findByIsbn(String isbn) {
		for (int i = 0; i < numOfElements; i++) {
			if (textbag[i].getIsbn().equals(isbn)) {
				return textbag[i];
			}
		}
		return null;
	}
	
	public Textbook[] getTextbookArray() {
		return Arrays.copyOf(textbag, numOfElements);
	}
	
	public boolean isTextbookThereBoolean(String theIsbn) {
		boolean isThere=false;
		for(int i =0;i<numOfElements;i++) {
			if(textbag[i].getIsbn().replaceAll("[^0-9]", "").equals(theIsbn.replaceAll("[^0-9]", ""))) {
				isThere=true;
			}
		}return isThere;
	}

	public Textbook removeByIsbn(String isbn) {
		for (int i = 0; i < numOfElements; i++) {
			if (textbag[i].getIsbn().replaceAll("[^0-9]", "").equals(isbn.replaceAll("[^0-9]", ""))) {
				return removeBook(i);
			}
		}
		return null;
	}

	public Textbook removeBook(int bookNum) {
		Textbook tempBook = textbag[bookNum];
		for (int i = bookNum; i < numOfElements - 1; i++) {
			textbag[i] = textbag[i + 1];
		}
		numOfElements--;
		return tempBook;
	}

	public int getSizeOfTextbook() {
		return textbag.length;
	}
}
