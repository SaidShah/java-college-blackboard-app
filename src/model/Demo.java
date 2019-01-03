package model;

import java.io.Serializable;
import java.util.Arrays;

public class Demo implements Serializable {

	public static void main(String[] args) {

	/*	Student s1 = new Student(new Name("john", "smith"),
				new Address("7", "Glenda dr", "Deer Park", "New York", "11729"), "6312564856", Major.COMPUTER_SCIENCE);
		Student s2 = new Student(new Name("mike", "carlin"),
				new Address("35", "Carrol lane", "deer park", "New Jersey", "11985"), "6319598564", Major.MATH);
		Student s3 = new Student(new Name("jose", "ramos"),
				new Address("17", "Long Island ave", "deer park", "new mexico", "11458"), "6314587594", Major.SCIENCE);
		Student s4 = new Student(new Name("Shaquille", "Oneal"),
				new Address("27", "Osceila dr", "Forest Hills", "New York", "11854"), "6316588456",
				Major.COMPUTER_SCIENCE);
		Student s5 = new Student(new Name("Patrick", "Ewing"),
				new Address("95", "Knicks lane", "Dix Hills", "New Jersey", "18547"), "6312548795", Major.ENGLISH);

		Faculty f1 = new Faculty(new Name("carlos", "johnson"),
				new Address("85", "Peanut dr", "deer park", "Florida", "11254"), "6314587545", "89 Office dr", "45215",
				"Mr");
		Faculty f2 = new Faculty(new Name("james", "cassidy"),
				new Address("957", "Nicolls rd", "deer hills", "New Hampshire", "11729"), "6318594567",
				"7 dix hills rd", "785215", "Mr");
		Faculty f3 = new Faculty(new Name("michael", "jordan"),
				new Address("68", "college dr", "dix hills ", "connecticut", "11356"), "6312546985", "87 New York Ave",
				"29635", "Miss");*/

		PersonBag personBag = new PersonBag(9);
		 personBag.loadPersons();


		/*personBag.add(s1);
		personBag.add(s2);
		personBag.add(s3);
		personBag.add(s4);
		personBag.add(s5);
		personBag.add(f1);
		personBag.add(f2);
		personBag.add(f3);
*/


/*		 System.out.println("----"+personBag.findById("00000000").getPassword());
		 System.out.println("----"+personBag.findById("00000001").getPassword());
		 System.out.println("----"+personBag.findById("00000003").getPassword());
		 System.out.println("----"+personBag.findById("00000004").getPassword());
		 System.out.println("----"+personBag.findById("00000005").getPassword());
		 System.out.println("----"+personBag.findById("00000006").getPassword());
		 System.out.println("----"+personBag.findById("00000007").getPassword());*/

/*
		((Student) personBag.getPerson(0)).addCoursesTook(new Grade("CST111", "B"));
		((Student) personBag.getPerson(0)).addCoursesTook(new Grade("CST112", "A+"));
		((Student) personBag.getPerson(0)).addCoursesTook(new Grade("MAT126", "B"));
		((Student) personBag.getPerson(0)).addCoursesTook(new Grade("MAT145", "A"));
		((Student) personBag.getPerson(0)).addCoursesTaking(new Grade("CST172"));
		((Student) personBag.getPerson(0)).addCoursesTaking(new Grade("ENG101"));
		((Student) personBag.getPerson(0)).addCoursesTaking(new Grade("CEM214"));
		((Student) personBag.getPerson(0)).addCoursesToTake(new Grade("PHY122"));
		((Student) personBag.getPerson(0)).addCoursesToTake(new Grade("SCI115"));

		((Student) personBag.getPerson(1)).addCoursesTook(new Grade("SCI115", "A+"));
		((Student) personBag.getPerson(1)).addCoursesTook(new Grade("PHY122", "C+"));
		((Student) personBag.getPerson(1)).addCoursesTook(new Grade("CEM214", "B"));
		((Student) personBag.getPerson(1)).addCoursesTook(new Grade("ENG101", "D"));
		((Student) personBag.getPerson(1)).addCoursesTaking(new Grade("CST172"));
		((Student) personBag.getPerson(1)).addCoursesTaking(new Grade("MAT145"));
		((Student) personBag.getPerson(1)).addCoursesToTake(new Grade("MAT126"));
		((Student) personBag.getPerson(1)).addCoursesToTake(new Grade("CST112"));
		((Student) personBag.getPerson(1)).addCoursesToTake(new Grade("CST111"));

		((Student) personBag.getPerson(2)).addCoursesTook(new Grade("CST172", "A"));
		((Student) personBag.getPerson(2)).addCoursesTook(new Grade("ENG101", "C"));
		((Student) personBag.getPerson(2)).addCoursesTook(new Grade("MAT126", "B+"));
		((Student) personBag.getPerson(2)).addCoursesTaking(new Grade("SCI115"));
		((Student) personBag.getPerson(2)).addCoursesTaking(new Grade("CST111"));
		((Student) personBag.getPerson(2)).addCoursesTaking(new Grade("CEM214"));
		((Student) personBag.getPerson(2)).addCoursesTaking(new Grade("MAT145"));
		((Student) personBag.getPerson(2)).addCoursesToTake(new Grade("CST112"));
		((Student) personBag.getPerson(2)).addCoursesToTake(new Grade("PHY122"));

		((Student) personBag.getPerson(3)).addCoursesTook(new Grade("PHY122", "A+"));
		((Student) personBag.getPerson(3)).addCoursesTook(new Grade("CEM214", "C"));
		((Student) personBag.getPerson(3)).addCoursesTook(new Grade("SCI115", "D+"));
		((Student) personBag.getPerson(3)).addCoursesTaking(new Grade("CST111"));
		((Student) personBag.getPerson(3)).addCoursesTaking(new Grade("CST112"));
		((Student) personBag.getPerson(3)).addCoursesToTake(new Grade("ENG101"));
		((Student) personBag.getPerson(3)).addCoursesToTake(new Grade("MAT126"));
		((Student) personBag.getPerson(3)).addCoursesToTake(new Grade("MAT145"));
		((Student) personBag.getPerson(3)).addCoursesToTake(new Grade("CST172"));

		((Student) personBag.getPerson(4)).addCoursesTook(new Grade("ENG101", "A+"));
		((Student) personBag.getPerson(4)).addCoursesTook(new Grade("CST172", "B+"));
		((Student) personBag.getPerson(4)).addCoursesTook(new Grade("PHY122", "C"));
		((Student) personBag.getPerson(4)).addCoursesTook(new Grade("MAT145", "D+"));
		((Student) personBag.getPerson(4)).addCoursesTaking(new Grade("CST112"));
		((Student) personBag.getPerson(4)).addCoursesTaking(new Grade("MAT126"));
		((Student) personBag.getPerson(4)).addCoursesToTake(new Grade("CST111"));
		((Student) personBag.getPerson(4)).addCoursesToTake(new Grade("CEM214"));
		((Student) personBag.getPerson(4)).addCoursesToTake(new Grade("SCI115"));

		 personBag.savePerson();*/
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("DISPLAY PEOPLE");
		personBag.display();
/*		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("FOUND BY ID " + personBag.findById("00000007"));
		System.out.println("---------------------------------------------------------------------------------");
	//	 System.out.println("REMOVED BY ID " + personBag.removeById("0000009"));

		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("DISPLAY PEOPLE AFTER REMOVED 1 BY ID");
		personBag.display();*/

		TextbookBag textBookBag = new TextbookBag(9);
		 textBookBag.loadTextbooks();
		System.out.println();
		
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("DISPLAY TEXTBOOKS");
		/*Textbook t1 = new Textbook("Intro to java first edition", new Name("James", "Michael"), "Suny Publishing",
				"658-4521-956", 106.65);
		Textbook t2 = new Textbook("Advanced programming 2nd edition", new Name("michael", "johnson"),
				"SCCC Publishing", "125-4521-458", 125.52);
		Textbook t3 = new Textbook("Precalculus 1st edition", new Name("Pablo", "Escobar"), "School Publishing",
				"336-9564-985", 195.65);
		Textbook t4 = new Textbook("Algebra 1st Edition", new Name("Eddie", "Klump"), "Suffolk Publishing",
				"458-8565-721", 115.15);
		Textbook t5 = new Textbook("Intro to Database", new Name("Kim", "Jung Un"), "Nassau Publishing", "785-6546-783",
				85.52);
		Textbook t6 = new Textbook("Grammar 1st Editiion", new Name("Eric", "Peterson"), "Kids Publishing",
				"458-2548-658", 125.75);
		Textbook t7 = new Textbook("Chemistry 2nd Edition", new Name("Charlie", "Murphy"), "Genuine Publishing",
				"754-5842-458", 85.15);
		Textbook t8 = new Textbook("Intro Physics", new Name("Dr.Barack", "Obama"), "Washington Publishing",
				"785=4587=214", 285.12);
		Textbook t9 = new Textbook("Science 2nd Edition", new Name("Bill", "Nye"), "Mars Publishing", "458-7596-365",
				75.60);

		textBookBag.add(t1);
		textBookBag.add(t2);
		textBookBag.add(t3);
		textBookBag.add(t4);
		textBookBag.add(t5);
		textBookBag.add(t6);
		textBookBag.add(t7);
		textBookBag.add(t8);
		textBookBag.add(t9);
*/
		//textBookBag.display();
	//	 textBookBag.saveTextbooks();
/*		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("FOUND TEXTBOOK BY ISBN");
		System.out.println(textBookBag.findByIsbn("125-4521-458"));
		System.out.println("---------------------------------------------------------------------------------");
		// System.out.println("REMOVED TEXTBOOK BY ISBN " +
		// textBookBag.removeByIsbn("125-4521-458"));
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("DISPLAY TEXTBOOKS AFTER REMOVED 1 BY ISBN");
*/
		
		textBookBag.display();
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("DISPLAY COURSES");
		/*Course c1 = new Course("Intro to java", "CST111", 3);
		Course c2 = new Course("Advanced Programming", "CST112", 4);
		Course c3 = new Course("Precalculus Math", "MAT126", 3);
		Course c4 = new Course("Algebra", "MAT145", 3);
		Course c5 = new Course("Database", "CST172", 4);
		Course c6 = new Course("English", "ENG101", 2);
		Course c7 = new Course("Chemistry", "CHEM214", 3);
		Course c8 = new Course("Physics", "PHY122", 5);
		Course c9 = new Course("Science", "SCI115", 3);
*/
		CourseBag courseBag = new CourseBag(9);
		courseBag.loadCoarse();

		/*courseBag.add(c1);
		courseBag.add(c2);
		courseBag.add(c3);
		courseBag.add(c4);
		courseBag.add(c5);
		courseBag.add(c6);
		courseBag.add(c7);
		courseBag.add(c8);
		courseBag.add(c9);

		c1.setFacultyID(f1.getId());
		c2.setFacultyID(f1.getId());
		c3.setFacultyID(f1.getId());
		c4.setFacultyID(f2.getId());
		c5.setFacultyID(f2.getId());
		c6.setFacultyID(f2.getId());
		c7.setFacultyID(f3.getId());
		c8.setFacultyID(f3.getId());
		c9.setFacultyID(f3.getId());

		c1.setTextBookISBN(t1.getIsbn());
		c2.setTextBookISBN(t2.getIsbn());
		c3.setTextBookISBN(t3.getIsbn());
		c4.setTextBookISBN(t4.getIsbn());
		c5.setTextBookISBN(t5.getIsbn());
		c6.setTextBookISBN(t6.getIsbn());
		c7.setTextBookISBN(t7.getIsbn());
		c8.setTextBookISBN(t8.getIsbn());
		c9.setTextBookISBN(t9.getIsbn());*/

		courseBag.display();
/*		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("FOUND BY COURSE NUMBER " + courseBag.findByCourseNumber("CSE118"));
		System.out.println("---------------------------------------------------------------------------------");
		// System.out.println("REMOVED THIS TEXTBOOK BY COURSE NUMBER" +
		// courseBag.removeByCourseNumber("CST112"));
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("DISPLAY TEXTBOOKS AFTER REMOVING BY COURSE NUMBER");
		courseBag.display();
		System.out.println("---------------------------------------------------------------------------------");*/
	//courseBag.SaveCourse();

/*		System.out.println("Courses to Take ================================================================");
		Grade[] coursesTook1 = ((Student) personBag.getPerson(2)).getCoursesTaking();

		for (int i = 0; i < ((Student) personBag.getPerson(2)).getCoursesTakingIndex(); i++) {
			System.out.println(coursesTook1[i]);
		}
		System.out.println("courses taking =============================================================");

		Grade[] coursesToTake1 = ((Student) personBag.getPerson(0)).getCoursesTaking();
		for (int i = 0; i < ((Student) personBag.getPerson(0)).getCoursesTakingIndex(); i++) {
			System.out.println(coursesToTake1[i]);
		}
		System.out.println();
		System.out.println("Credits Took "
				+ CreditsAndGPACalculator.getCredits(((Student) personBag.getPerson(1)).getCoursesTookIndex(),
						((Student) personBag.getPerson(1)).getCoursesTook(), courseBag));

		System.out.println("Credits Taking "
				+ CreditsAndGPACalculator.getCredits(((Student) personBag.getPerson(1)).getCoursesTakingIndex(),
						((Student) personBag.getPerson(1)).getCoursesTaking(), courseBag));

		System.out.println("Credits To Take "
				+ CreditsAndGPACalculator.getCredits(((Student) personBag.getPerson(1)).getCoursesToTakeIndex(),
						((Student) personBag.getPerson(1)).getCoursesToTake(), courseBag));

		System.out.println();

		System.out.println("total GPA for courses took is "
				+ CreditsAndGPACalculator.getGPA(((Student) personBag.getPerson(1)).getCoursesTookIndex(),
						((Student) personBag.getPerson(1)).getCoursesTook(), courseBag));

		System.out.println();
		System.out.println("total GPA for courses taking is "
				+ CreditsAndGPACalculator.getGPA(((Student) personBag.getPerson(1)).getCoursesTakingIndex(),
						((Student) personBag.getPerson(1)).getCoursesTaking(), courseBag));
		System.out.println();

		System.out.println("total GPA for courses took is "
				+ CreditsAndGPACalculator.getGPA(((Student) personBag.getPerson(3)).getCoursesTookIndex(),
						((Student) personBag.getPerson(3)).getCoursesTook(), courseBag));*/

	/*	System.out.println("new GPA calculator"
				+ CreditsAndGPACalculator.getNewGPA(((Student) personBag.getPerson(1)).getCoursesTook(), courseBag));*/

	/*	Classroom classroom1 = new Classroom("R204", false, "Riverhead Building", false, 34);
		Classroom classroom2 = new Classroom("S129", true, "Smithtown Building", false, 14);
		Classroom classroom3 = new Classroom("S223", true, "Smithtown Building", true, 29);
		Classroom classroom4 = new Classroom("R201", false, "Riverhead Building", true, 30);
		Classroom classroom5 = new Classroom("R114", true, "Riverhead Building", false, 32);
		Classroom classroom6 = new Classroom("S138", true, "Smithtown Building", true, 26);
*/
		ClassroomBag roomBag = new ClassroomBag(6);
		 roomBag.loadClassroom();
		/*roomBag.add(classroom1);
		roomBag.add(classroom2);
		roomBag.add(classroom3);
		roomBag.add(classroom4);
		roomBag.add(classroom5);
		roomBag.add(classroom6);*/

		System.out.println();

		/*
		 * roomBag.setCourseByRoomNum(c3, "S223"); roomBag.display();
		 * roomBag.removeByRoomNumber("S129"); roomBag.removeByRoomNumber("R114");
		 * System.out.println();
		 */

		System.out.println();
		//roomBag.removeByRoomNumber("S129");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("DISPLAY CLASSROOMS");
		roomBag.display();
		//roomBag.saveClassroom();

		System.out.println();
		//Student[] students = personBag.getStudentsArray();
	//	System.out.println("Courses Took GPA "+personBag.getGPACoursesTookById("00000004", courseBag));
	//	System.out.println("Courses Taking GPA "+ personBag.getGPACoursesTakingById("00000000", courseBag));

	

		/*courseBag.findByCourseNumber("css222").setTextBookISBN("458-7596-365");
		courseBag.display();
		textBookBag.findByIsbn(courseBag.findByCourseNumber("css222").getTextBookISBN());
		*/
		//System.out.println(courseBag.findByCourseNumber("cst911"));
		//System.out.println(courseBag.findByCourseNumberBoolean("css222"));
		//System.out.println(roomBag.checkIfRoomIsAvailable("R114"));
		//System.out.println(courseBag.findByCourseNumberBoolean("cst911"));
		//System.out.println(personBag.findPersonIdBoolean("00000006"));
		/*String phones="CST234";
		boolean isworking = phones.matches("([a-zA-Z]{3})([\\d]{3})");
		System.out.println(isworking);*/
		//System.out.println(courseBag.findByCourseNumberBoolean("CST111"));
/*		Grade[] tempCoursesTook1=personBag.getCoursesTookById("00000001");
		Grade[] tempCoursesTaking1=personBag.getCoursesTakingById("00000001");
		Grade[] tempCoursesToTake1=personBag.getCoursesToTakeById("00000001");
		System.out.println(" this one is Took "+Arrays.toString(tempCoursesTook1));
		System.out.println(" this one is Taking "+Arrays.toString(tempCoursesTaking1));
		System.out.println(" this one is Taking "+Arrays.toString(tempCoursesToTake1));*/
	/*	for(int i = 0; i < tempCoursesTook1.length;i++){
			if(tempCoursesTook1[i].getCourseNumber().equalsIgnoreCase(newcourse)){
				System.out.println(tempCoursesTook1[i].getCourseNumber());
				System.out.println("its there");
			}else{
				System.out.println(tempCoursesTook1[i].getCourseNumber());
				System.out.println("its not there yet ");
			}
		}
		System.out.println(tempCoursesTook1.length);
		*/
	/*	System.out.println(personBag.checkCoursesTookBoolean("00000001", newcourse));
		System.out.println(personBag.checkCoursesTakingBoolean("00000001", newcourse));
		System.out.println(personBag.checkCoursesToTakeBoolean("00000001", newcourse));*/
/*		College college = new College();
		Course[] tempCourse =college.checkAllClasses("00000002");
		System.out.println("temp Course not Taken "+Arrays.toString(tempCourse));
		
		((Student) personBag.findById("00000002")).removeCourseTaking("mat145");
		
		Grade[] temp2 = personBag.getCoursesTakingById("00000002");

		System.out.println("courses taking after deletion "+Arrays.toString(temp2));
		System.out.println(temp2.length);*/

}
}