package model;

import java.util.Arrays;

public class College {
	ClassroomBag classroomBag;
	CourseBag courseBag;
	PersonBag personBag;
	TextbookBag textbookBag;

	private final int PERSONBAG_MAXSIZE = 9;
	private final int TEXTBOOKBAG_MAXSIZE = 9;
	private final int COURSEBAG_MAXSIZE = 9;
	private final int CLASSROOMBAG_MAXSIZE = 6;

	public College() {
		personBag = new PersonBag(PERSONBAG_MAXSIZE);
		textbookBag = new TextbookBag(TEXTBOOKBAG_MAXSIZE);
		courseBag = new CourseBag(COURSEBAG_MAXSIZE);
		classroomBag = new ClassroomBag(CLASSROOMBAG_MAXSIZE);
		load();

	}

	public ClassroomBag getClassroomBag() {
		return classroomBag;
	}

	public void setClassroomBag(ClassroomBag classroomBag) {
		this.classroomBag = classroomBag;
	}

	public CourseBag getCourseBag() {
		return courseBag;
	}

	public void setCourseBag(CourseBag courseBag) {
		this.courseBag = courseBag;
	}

	public PersonBag getPersonBag() {
		return personBag;
	}

	public void setPersonBag(PersonBag personBag) {
		this.personBag = personBag;
	}

	public TextbookBag getTextbookBag() {
		return textbookBag;
	}

	public void setTextbookBag(TextbookBag textbookBag) {
		this.textbookBag = textbookBag;
	}

	public void load() {
		personBag.loadPersons();
		textbookBag.loadTextbooks();
		courseBag.loadCoarse();
		classroomBag.loadClassroom();

	}

	public void save() {
		personBag.savePerson();
		textbookBag.saveTextbooks();
		courseBag.SaveCourse();
		classroomBag.saveClassroom();
	}

	public Course[] checkAllClasses(String idNumber){
		Course[] tempCourse= courseBag.getCourseArray();
		int index=0;
		Course[] courseToReturn =new Course[80];
		for(int i  =0;i<tempCourse.length;i++){
			if(personBag.checkCoursesTakingBoolean(idNumber, tempCourse[i].getCourseNumber())==false&&
					personBag.checkCoursesTookBoolean(idNumber, tempCourse[i].getCourseNumber())==false &&
					personBag.checkCoursesToTakeBoolean(idNumber, tempCourse[i].getCourseNumber())==false){

					courseToReturn[index++]=tempCourse[i];

			}
		}return Arrays.copyOf(courseToReturn, index);
	}
}
