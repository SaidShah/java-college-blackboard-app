package model;

import java.text.DecimalFormat;
import java.util.Arrays;

public class CreditsAndGPACalculator {

	public static int getCredits(int number, Grade[] course, CourseBag masterCourse) {

		int totalCredits = 0;
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < masterCourse.getElements(); j++) {

				if (course[i].getCourseNumber().equals(masterCourse.getCourseArray()[j].getCourseNumber())) {
					totalCredits += masterCourse.getCourseArray()[j].getNumOfCredits();
				}
			}

		}
		return totalCredits;
	}

	public static double getGPA(int number, Grade[] course, CourseBag masterCourse) {

		double totalGPA = 0;
		int totalCredits = 0;
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < masterCourse.getElements(); j++) {
				if (course[i].getCourseNumber().equals(masterCourse.getCourseArray()[j].getCourseNumber())) {
					totalGPA += course[i].StudentGPA() * masterCourse.getCourseArray()[j].getNumOfCredits();
					totalCredits += masterCourse.getCourseArray()[j].getNumOfCredits();
				}
			}
		}
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(1);
		return Double.valueOf(df.format(totalGPA / totalCredits));

	}

	public static double getNewGPA(Grade[] course, CourseBag masterCourse) {
		double totalGPA = 0;
		int totalCredits = 0;
		Course[] courseArray = masterCourse.getCourseArray();
		Grade[] gradeArray = course;
		for (int i = 0; i < gradeArray.length; i++) {

			for (int j = 0; j < masterCourse.getElements(); j++) {
				if (gradeArray[i].getCourseNumber().equals(courseArray[j].getCourseNumber())) {
					totalGPA += gradeArray[i].StudentGPA() * courseArray[j].getNumOfCredits();
					totalCredits += courseArray[j].getNumOfCredits();
				}
			}
		}
		DecimalFormat nf = new DecimalFormat();
		nf.setMaximumFractionDigits(1);
		return Double.valueOf(nf.format(totalGPA / totalCredits));

	}
}
