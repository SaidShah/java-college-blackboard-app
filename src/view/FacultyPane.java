package view;

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.*;


public class FacultyPane {
	final int BUTTON_WIDTH = 240;
	final int BUTTON_HEIGHT = 80;
	final String TEXT_FIELD_FONT = "-fx-font: 24 papyrus";
	final String LABEL_FONT = "-fx-font: 34 papyrus";
	final String BUTTON_FONT = "-fx-font: 19 papyrus";
	Scene scene3;
	transient Scanner scannerInput;

	public FacultyPane(College college, Stage stage, Scene scene) {
		Image image = new Image("file:images/image4.png");
		BackgroundImage bgi = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
		          BackgroundSize.DEFAULT);
		Stage stage2 = new Stage();
		stage2.sizeToScene();
		TabPane tabPane = new TabPane();
		Alert alert = new Alert(AlertType.ERROR);

		Tab addStudent = new Tab("Add Student");

		ChoiceBox<Major> majorChoice = new ChoiceBox<>();
		majorChoice.getItems().add(Major.COMPUTER_SCIENCE);
		majorChoice.getItems().add(Major.MATH);
		majorChoice.getItems().add(Major.ENGLISH);
		majorChoice.getItems().add(Major.PSYCHOLOGY);
		majorChoice.getItems().add(Major.HISTORY);
		majorChoice.getItems().add(Major.DATABASE_MANAGEMENT);
		majorChoice.getItems().add(Major.SCIENCE);
		majorChoice.setValue(Major.COMPUTER_SCIENCE);
		majorChoice.setStyle(BUTTON_FONT);

		Text studentText = new Text();
		studentText.setText("Add A Student\n");
		studentText.setStyle(LABEL_FONT);
		studentText.setFill(Color.WHITE);
		Button addStudentButton = new Button("Add");
		addStudentButton.setStyle(BUTTON_FONT);
		addStudentButton.setTextFill(Color.BLUE);
		addStudentButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		Button clearProgram = new Button("Clear");
		clearProgram.setStyle(BUTTON_FONT);
		clearProgram.setTextFill(Color.BLUE);
		clearProgram.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		Button backButton = new Button("Log out");
		backButton.setStyle(BUTTON_FONT);
		backButton.setTextFill(Color.BLUE);
		backButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		Button exitButton = new Button("Exit");
		exitButton.setStyle(BUTTON_FONT);
		exitButton.setTextFill(Color.BLUE);
		exitButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		Button importStudentButton = new Button("Import Students");
		importStudentButton.setStyle(BUTTON_FONT);
		importStudentButton.setTextFill(Color.BLUE);
		importStudentButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

		TextField studentFname = new TextField();
		studentFname.setStyle(TEXT_FIELD_FONT);
		studentFname.setPromptText("First Name");
		
		TextField studentLname = new TextField();
		studentLname.setStyle(TEXT_FIELD_FONT);
		studentLname.setPromptText("Last Name");
	
		TextField studentStreetNum = new TextField();
		studentStreetNum.setStyle(TEXT_FIELD_FONT);
		studentStreetNum.setPromptText("House Number");
		
		TextField studentStreetName = new TextField();
		studentStreetName.setStyle(TEXT_FIELD_FONT);
		studentStreetName.setPromptText("Street Name");
		
		TextField studentCity = new TextField();
		studentCity.setStyle(TEXT_FIELD_FONT);
		studentCity.setPromptText("City ");
	
		TextField studentState = new TextField();
		studentState.setStyle(TEXT_FIELD_FONT);
		studentState.setPromptText("State ");
		
		TextField studentZip = new TextField();
		studentZip.setStyle(TEXT_FIELD_FONT);
		studentZip.setPromptText("Zip Code");
		
		TextField studentPhone = new TextField();
		studentPhone.setStyle(TEXT_FIELD_FONT);
		studentPhone.setPromptText("Phone Number");
		
		
		HBox studentName = new HBox(studentFname, studentLname, majorChoice);
		studentName.setAlignment(Pos.CENTER);
		studentName.getChildren().addAll();
		studentName.setPadding(new Insets(30));
		studentName.setSpacing(20);
		HBox studentAddress = new HBox(studentStreetNum, studentStreetName, studentCity);
		studentAddress.setAlignment(Pos.CENTER);
		studentAddress.getChildren().addAll();
		studentAddress.setPadding(new Insets(20));
		studentAddress.setSpacing(20);
		HBox studentAddress2 = new HBox(studentState, studentZip, studentPhone);
		studentAddress2.setAlignment(Pos.CENTER);
		studentAddress2.getChildren().addAll();
		studentAddress2.setPadding(new Insets(20));
		studentAddress2.setSpacing(20);
		HBox studentSaveButtons = new HBox(addStudentButton, clearProgram);
		studentSaveButtons.setAlignment(Pos.CENTER);
		studentSaveButtons.getChildren().addAll();
		studentSaveButtons.setPadding(new Insets(20));
		studentSaveButtons.setSpacing(20);
		HBox studentButtons = new HBox(importStudentButton,backButton, exitButton);
		studentButtons.setAlignment(Pos.CENTER);
		studentButtons.getChildren().addAll();
		studentButtons.setPadding(new Insets(20));
		studentButtons.setSpacing(20);
		VBox allFields = new VBox(studentText, studentName, studentAddress, studentAddress2, studentSaveButtons,
				studentButtons);
		allFields.setAlignment(Pos.CENTER);
		allFields.setBackground(new Background(bgi));
		addStudent.setContent(allFields);

		backButton.setOnAction(e -> {
			stage.setScene(scene);
		});

		clearProgram.setOnAction(e -> {
			studentFname.clear();
			studentLname.clear();
			studentStreetNum.clear();
			studentStreetName.clear();
			studentCity.clear();
			studentState.clear();
			studentZip.clear();
			studentPhone.clear();
		});

		exitButton.setOnAction(e -> {
			college.save();
			Platform.exit();
		});

		addStudentButton.setOnAction(e -> {
			String firstName = studentFname.getText().trim();
			String lastName = studentLname.getText().trim();
			String streetNumber = studentStreetNum.getText().trim();
			String streetName = studentStreetName.getText().trim();
			String city = studentCity.getText().trim();
			String state = studentState.getText().trim();
			String zip = studentZip.getText().trim();
			String phone = studentPhone.getText().trim().replaceAll("[^0-9]", "");
			boolean phoneMatches = phone.matches("[(]?(\\d{3})[)]?[.-]?(\\d{3})[.-]?(\\d{4})");
			boolean zipMatches = zip.matches("([\\d]{5})");
			if (firstName.isEmpty() || lastName.isEmpty() || streetNumber.isEmpty() || streetName.isEmpty()
					|| city.isEmpty() || state.isEmpty() || zip.isEmpty() || phone.isEmpty()) {
				alert.setTitle("Warning");
				alert.setContentText("You cannot leave any field empty");
				alert.showAndWait();
			} else if (phoneMatches==false || zipMatches==false) {
				alert.setTitle("Warning");
				alert.setContentText("invalid phone number or zip code");
				alert.showAndWait();
			} else {
				Student temp = new Student(new Name(firstName, lastName),
						new Address(streetNumber, streetName, city, state, zip), phone, majorChoice.getValue());
				college.getPersonBag().add(temp);
				college.save();
				alert.setAlertType(AlertType.CONFIRMATION);
				alert.setTitle("Successful");
				alert.setContentText("Student has been added");
				alert.showAndWait();
				studentFname.clear();
				studentLname.clear();
				studentStreetNum.clear();
				studentStreetName.clear();
				studentCity.clear();
				studentState.clear();
				studentZip.clear();
				studentPhone.clear();
			}
		});
		
		importStudentButton.setOnAction(e->{
			FileChooser studentImport = new FileChooser();
			File importStudentFile = studentImport.showOpenDialog(stage2);
			if (importStudentFile!= null) {
				try {

					scannerInput = new Scanner(importStudentFile);

					while (scannerInput.hasNextLine()) {
						String line = scannerInput.nextLine();
						String[] personInfo = line.split(", ");
						Major[]  studentMajor= {Major.COMPUTER_SCIENCE,Major.DATABASE_MANAGEMENT,Major.ENGLISH,Major.HISTORY,
													Major.MATH,Major.PSYCHOLOGY,Major.SCIENCE};
						int index= Integer.parseInt(personInfo[8]);
						Student tempPerson = new Student(new Name(personInfo[0],personInfo[1]),
									new Address(personInfo[2],personInfo[3],personInfo[4],personInfo[5],personInfo[6]),
														personInfo[7],studentMajor[index]);
						
						college.getPersonBag().add(tempPerson);
						college.save();
					}
				} catch (FileNotFoundException e1) {
				}
				}
		});

		Tab addFaculty = new Tab("Add Faculty");

		Text facultyText = new Text();
		facultyText.setText("Add A Faculty Member");
		facultyText.setStyle(LABEL_FONT);
		facultyText.setFill(Color.WHITE);
		Button addFacultyButton = new Button("Add");
		addFacultyButton.setStyle(BUTTON_FONT);
		addFacultyButton.setTextFill(Color.BLUE);
		addFacultyButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		Button clearFacultyProgram = new Button("Clear");
		clearFacultyProgram.setStyle(BUTTON_FONT);
		clearFacultyProgram.setTextFill(Color.BLUE);
		clearFacultyProgram.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		Button backFacultyButton = new Button("Log out");
		backFacultyButton.setStyle(BUTTON_FONT);
		backFacultyButton.setTextFill(Color.BLUE);
		backFacultyButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		Button exitFacultyButton = new Button("Exit");
		exitFacultyButton.setStyle(BUTTON_FONT);
		exitFacultyButton.setTextFill(Color.BLUE);
		exitFacultyButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		Button importFacultyButton = new Button("Import Faculty");
		importFacultyButton.setStyle(BUTTON_FONT);
		importFacultyButton.setTextFill(Color.BLUE);
		importFacultyButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

		TextField facultyFname = new TextField();
		facultyFname.setStyle(TEXT_FIELD_FONT);
		facultyFname.setPromptText("First Name");
		TextField facutlyLname = new TextField();
		facutlyLname.setStyle(TEXT_FIELD_FONT);
		facutlyLname.setPromptText("Last Name");
		TextField facultyStreetNum = new TextField();
		facultyStreetNum.setStyle(TEXT_FIELD_FONT);
		facultyStreetNum.setPromptText("House Number");
		TextField facultyStreetName = new TextField();
		facultyStreetName.setStyle(TEXT_FIELD_FONT);
		facultyStreetName.setPromptText("Street Name");
		facultyStreetName.setPadding(new Insets(20));
		TextField facultyCity = new TextField();
		facultyCity.setStyle(TEXT_FIELD_FONT);
		facultyCity.setPromptText("City ");
		TextField facultyState = new TextField();
		facultyState.setStyle(TEXT_FIELD_FONT);
		facultyState.setPromptText("State ");
		TextField facultyZip = new TextField();
		facultyZip.setStyle(TEXT_FIELD_FONT);
		facultyZip.setPromptText("Zip Code");
		facultyZip.setPadding(new Insets(20));
		TextField facultyPhone = new TextField();
		facultyPhone.setStyle(TEXT_FIELD_FONT);
		facultyPhone.setPromptText("Phone Number");
		TextField getOfficeAddress = new TextField();
		getOfficeAddress.setStyle(TEXT_FIELD_FONT);
		getOfficeAddress.setPromptText("Office Address");
		TextField getSalary = new TextField();
		getSalary.setStyle(TEXT_FIELD_FONT);
		getSalary.setPromptText("Salary ");
		getSalary.setPadding(new Insets(20));
		TextField getTitle = new TextField();
		getTitle.setStyle(TEXT_FIELD_FONT);
		getTitle.setPromptText("Title");

		HBox facultyName = new HBox(facultyFname, facutlyLname);
		facultyName.setAlignment(Pos.CENTER);
		facultyName.setPadding(new Insets(20));
		facultyName.setSpacing(20);
		HBox facultyAddress = new HBox(facultyStreetNum, facultyStreetName, facultyCity);
		facultyAddress.setAlignment(Pos.CENTER);
		facultyAddress.setPadding(new Insets(20));
		facultyAddress.setSpacing(20);
		HBox facultyAddress2 = new HBox(facultyState, facultyZip, facultyPhone);
		facultyAddress2.setAlignment(Pos.CENTER);
		facultyAddress2.setPadding(new Insets(20));
		facultyAddress2.setSpacing(20);
		HBox facultyWorkInfo = new HBox(getOfficeAddress, getSalary, getTitle);
		facultyWorkInfo.setAlignment(Pos.CENTER);
		facultyWorkInfo.setPadding(new Insets(20));
		facultyWorkInfo.setSpacing(20);
		facultyWorkInfo.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		HBox facultySaveButtons = new HBox(importFacultyButton,addFacultyButton, clearFacultyProgram);
		facultySaveButtons.setAlignment(Pos.CENTER);
		facultySaveButtons.setPadding(new Insets(20));
		facultySaveButtons.setSpacing(20);
		HBox facultyButtons = new HBox(backFacultyButton, exitFacultyButton);
		facultyButtons.setAlignment(Pos.CENTER);
		facultyButtons.setPadding(new Insets(20));
		facultyButtons.setSpacing(20);
		VBox facultyBox = new VBox();
		facultyBox.getChildren().add(0, facultyText);
		facultyBox.getChildren().add(1, facultyName);
		facultyBox.getChildren().add(2, facultyAddress);
		facultyBox.getChildren().add(3, facultyAddress2);
		facultyBox.getChildren().add(4, facultyWorkInfo);
		facultyBox.getChildren().add(5, facultyButtons);
		facultyBox.getChildren().add(6, facultySaveButtons);
		facultyBox.setAlignment(Pos.CENTER);
		facultyBox.setBackground(new Background(bgi));
		addFaculty.setContent(facultyBox);

		addFacultyButton.setOnAction(e -> {
			String facultyFirstName = facultyFname.getText().trim();
			String facultyLastName = facutlyLname.getText().trim();
			String fStreetNum = facultyStreetNum.getText().trim();
			String fStreetName = facultyStreetName.getText().trim();
			String fCity = facultyCity.getText().trim();
			String fState = facultyState.getText().trim();
			String fZip = facultyZip.getText().trim();
			String fPhone = facultyPhone.getText().trim();
			boolean facultyPhoneMatches = fPhone.matches("[(]?(\\d{3})[)]?[.-]?(\\d{3})[.-]?(\\d{4})");
			boolean facultyZipMatches = fZip.matches("([\\d]{5})");
			String fOfficeAddress = getOfficeAddress.getText();
			String fSalary = getSalary.getText().trim();
			String fTitle = getTitle.getText().trim();
			if (facultyFirstName.isEmpty() || facultyLastName.isEmpty() || fStreetNum.isEmpty() || fStreetName.isEmpty()
					|| fCity.isEmpty() || fState.isEmpty() || fZip.isEmpty() || fPhone.isEmpty()
					|| fOfficeAddress.isEmpty() || fSalary.isEmpty() || fTitle.isEmpty()) {
				alert.setTitle("Warning");
				alert.setContentText("You cannot leave any field empty");
				alert.showAndWait();
			} else if (facultyPhoneMatches==false || facultyZipMatches==false) {
				alert.setTitle("Warning");
				alert.setContentText("invalid phone number or zip code");
				alert.showAndWait();
			} else {
				Faculty tempF = new Faculty(new Name(facultyFirstName, facultyLastName),
						new Address(fStreetNum, fStreetName, fCity, fState, fZip), fPhone, fOfficeAddress, fSalary,
						fTitle);
				college.getPersonBag().add(tempF);
				college.save();
				alert.setAlertType(AlertType.INFORMATION);
				alert.setTitle("Successful");
				alert.setContentText("Faculty has been added");
				alert.showAndWait();
				facultyFname.clear();
				facutlyLname.clear();
				facultyStreetNum.clear();
				facultyStreetName.clear();
				facultyCity.clear();
				facultyState.clear();
				facultyZip.clear();
				facultyPhone.clear();
				getOfficeAddress.clear();
				getSalary.clear();
				getTitle.clear();
			}
		});
		
		importFacultyButton.setOnAction(e->{
			FileChooser FacultyImport = new FileChooser();
			File importFacultyFile = FacultyImport.showOpenDialog(stage2);
			if (importFacultyFile!= null) {
				try {

					scannerInput = new Scanner(importFacultyFile);

					while (scannerInput.hasNextLine()) {
						String line = scannerInput.nextLine();
						String[] personInfo = line.split(", ");
						Faculty tempPerson = new Faculty(new Name(personInfo[0],personInfo[1]),
									new Address(personInfo[2],personInfo[3],personInfo[4],personInfo[5],personInfo[6]),
														personInfo[7],personInfo[8],personInfo[9],personInfo[10]);
						
						college.getPersonBag().add(tempPerson);
						college.save();
					}
				} catch (FileNotFoundException e1) {
				}
				}
		});

		clearFacultyProgram.setOnAction(e -> {
			facultyFname.clear();
			facutlyLname.clear();
			facultyStreetNum.clear();
			facultyStreetName.clear();
			facultyCity.clear();
			facultyState.clear();
			facultyZip.clear();
			facultyPhone.clear();
			getOfficeAddress.clear();
			getSalary.clear();
			getTitle.clear();
		});

		backFacultyButton.setOnAction(e -> {
			stage.setScene(scene);
		});

		exitFacultyButton.setOnAction(e -> {
			college.save();
			Platform.exit();
		});

		Tab addCourse = new Tab("Add Course");

		Text courseText = new Text();
		courseText.setText("Add A Course\n");
		courseText.setStyle(LABEL_FONT);
		courseText.setFill(Color.WHITE);
		Button addCourseButton = new Button("Add");
		addCourseButton.setStyle(BUTTON_FONT);
		addCourseButton.setTextFill(Color.BLUE);
		addCourseButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		Button clearCourse = new Button("Clear");
		clearCourse.setStyle(BUTTON_FONT);
		clearCourse.setTextFill(Color.BLUE);
		clearCourse.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		Button backCourseButton = new Button("Log out");
		backCourseButton.setStyle(BUTTON_FONT);
		backCourseButton.setTextFill(Color.BLUE);
		backCourseButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		Button exitCourseButton = new Button("Exit");
		exitCourseButton.setStyle(BUTTON_FONT);
		exitCourseButton.setTextFill(Color.BLUE);
		exitCourseButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		Button importCourseButton = new Button("Import Courses");
		importCourseButton.setStyle(BUTTON_FONT);
		importCourseButton.setTextFill(Color.BLUE);
		importCourseButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

		TextField getCourseName = new TextField();
		getCourseName.setStyle(TEXT_FIELD_FONT);
		getCourseName.setPromptText("Course Name");
		TextField getCourseNum = new TextField();
		getCourseNum.setStyle(TEXT_FIELD_FONT);
		getCourseNum.setPromptText("Course Number");
		TextField getNumOfCredits = new TextField();
		getNumOfCredits.setStyle(TEXT_FIELD_FONT);
		getNumOfCredits.setPromptText("Number of Credits");

		HBox courseInput = new HBox(getCourseName, getCourseNum, getNumOfCredits);
		courseInput.setAlignment(Pos.CENTER);
		courseInput.getChildren().addAll();
		courseInput.setPadding(new Insets(20));
		courseInput.setSpacing(20);
		HBox courseButtons = new HBox(importCourseButton,addCourseButton, clearCourse);
		courseButtons.setAlignment(Pos.CENTER);
		courseButtons.getChildren().addAll();
		courseButtons.setPadding(new Insets(20));
		courseButtons.setSpacing(20);
		HBox courseRegularButtons = new HBox(backCourseButton, exitCourseButton);
		courseRegularButtons.setAlignment(Pos.CENTER);
		courseRegularButtons.getChildren().addAll();
		courseRegularButtons.setPadding(new Insets(20));
		courseRegularButtons.setSpacing(20);
		VBox courseBox = new VBox(courseText,courseInput, courseButtons, courseRegularButtons);
		courseBox.setAlignment(Pos.CENTER);
		courseBox.setBackground(new Background(bgi));
		addCourse.setContent(courseBox);

		addCourseButton.setOnAction(e -> {
			String courseId = getCourseNum.getText().trim().toUpperCase();
			String courseName = getCourseName.getText().trim();
			String checkNumOfCredits = getNumOfCredits.getText().trim();
			boolean checkCourseIdNumber = courseId.matches("([a-zA-Z]{3})([\\d]{3})");
			boolean checkCredits = checkNumOfCredits.matches("([\\d]{1})");
			int numOfCredits;
			if (courseId.isEmpty() || courseName.isEmpty() || checkNumOfCredits.isEmpty()) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Fields Cant be blank");
				alert.showAndWait();

			} else if (checkCredits==false) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Number of Credits is incorrect");
				alert.showAndWait();
			} else if (checkCourseIdNumber==false) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("course Number is incorrect");
				alert.showAndWait();
			}
			  else {
				numOfCredits = Integer.parseInt(checkNumOfCredits);
				Course tempCourse = new Course(courseName, courseId, numOfCredits);
				college.getCourseBag().add(tempCourse);
				college.save();
				getNumOfCredits.clear();
				getCourseNum.clear();
				getCourseName.clear();
				alert.setAlertType(AlertType.INFORMATION);
				alert.setTitle("Successful");
				alert.setContentText("Course added Successfully");
				alert.showAndWait();
			}
		});
		
		importCourseButton.setOnAction(e->{
			FileChooser CourseImport = new FileChooser();
			File importCourseFile = CourseImport.showOpenDialog(stage2);
			if (importCourseFile!= null) {
				try {
					scannerInput = new Scanner(importCourseFile);
					while (scannerInput.hasNextLine()) {
						String line = scannerInput.nextLine();
						String[] courseInfo = line.split(", ");
						Course tempCourse = new Course(courseInfo[0],courseInfo[1],Integer.parseInt(courseInfo[2]));
						
						college.getCourseBag().add(tempCourse);;
						college.save();
					}
				} catch (FileNotFoundException e1) {
				}
				}
		});

		backCourseButton.setOnAction(e -> {
			stage.setScene(scene);
		});

		clearCourse.setOnAction(e -> {
			getCourseName.clear();
			getCourseNum.clear();
			getNumOfCredits.clear();
		});

		exitCourseButton.setOnAction(e -> {
			college.save();
			Platform.exit();
		});

		Tab addClassroom = new Tab("Add Classroom");

		ChoiceBox<String> hasProjector = new ChoiceBox<>();
		hasProjector.getItems().add("true");
		hasProjector.getItems().add("false");
		hasProjector.setValue("true");
		hasProjector.setStyle(BUTTON_FONT);
		ChoiceBox<String> hasLab = new ChoiceBox<>();
		hasLab.getItems().add("true");
		hasLab.getItems().add("false");
		hasLab.setValue("true");
		hasLab.setStyle(BUTTON_FONT);
		Text projectorText = new Text();
		projectorText.setText("Has a Projector?  ");
		projectorText.setStyle(LABEL_FONT);
		projectorText.setFill(Color.WHITE);
		Text labText = new Text();
		labText.setText("Has a Computer Lab?  ");
		labText.setStyle(LABEL_FONT);
		labText.setFill(Color.WHITE);
		Text classroomText = new Text();
		classroomText.setText("Add A Classroom\n");
		classroomText.setStyle(LABEL_FONT);
		classroomText.setFill(Color.WHITE);
		Button addClassroomButton = new Button("Add");
		addClassroomButton.setStyle(BUTTON_FONT);
		addClassroomButton.setTextFill(Color.BLUE);
		addClassroomButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		Button clearClassroom = new Button("Clear");
		clearClassroom.setStyle(BUTTON_FONT);
		clearClassroom.setTextFill(Color.BLUE);
		clearClassroom.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		Button backClassroomButton = new Button("Log out");
		backClassroomButton.setStyle(BUTTON_FONT);
		backClassroomButton.setTextFill(Color.BLUE);
		backClassroomButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		Button exitClassroomButton = new Button("Exit");
		exitClassroomButton.setStyle(BUTTON_FONT);
		exitClassroomButton.setTextFill(Color.BLUE);
		exitClassroomButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		Button importClassroomButton = new Button("Import Classrooms");
		importClassroomButton.setStyle(BUTTON_FONT);
		importClassroomButton.setTextFill(Color.BLUE);
		importClassroomButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

		TextField getClassroomNum = new TextField();
		getClassroomNum.setStyle(TEXT_FIELD_FONT);
		getClassroomNum.setPromptText("Classroom Number");
		TextField getBuildingName = new TextField();
		getBuildingName.setStyle(TEXT_FIELD_FONT);
		getBuildingName.setPromptText("Building Name");
		TextField getNumOfSeats = new TextField();
		getNumOfSeats.setStyle(TEXT_FIELD_FONT);
		getNumOfSeats.setPromptText("Number of Seats");

		HBox projectorQuestion = new HBox(projectorText, hasProjector);
		projectorQuestion.setAlignment(Pos.CENTER);
		projectorQuestion.getChildren().addAll();
		projectorQuestion.setPadding(new Insets(20));
		projectorQuestion.setSpacing(20);
		HBox labQuestion = new HBox(labText, hasLab);
		labQuestion.setAlignment(Pos.CENTER);
		labQuestion.getChildren().addAll();
		labQuestion.setPadding(new Insets(20));
		labQuestion.setSpacing(20);
		HBox classroomQuestions = new HBox(getClassroomNum, getBuildingName, getNumOfSeats);
		classroomQuestions.setAlignment(Pos.CENTER);
		classroomQuestions.getChildren().addAll();
		classroomQuestions.setPadding(new Insets(20));
		classroomQuestions.setSpacing(20);
		HBox classroomButtons = new HBox(importClassroomButton,addClassroomButton, clearClassroom);
		classroomButtons.setAlignment(Pos.CENTER);
		classroomButtons.getChildren().addAll();
		classroomButtons.setPadding(new Insets(20));
		classroomButtons.setSpacing(20);
		HBox otherClassroomButtons = new HBox(backClassroomButton, exitClassroomButton);
		otherClassroomButtons.setAlignment(Pos.CENTER);
		otherClassroomButtons.getChildren().addAll();
		otherClassroomButtons.setPadding(new Insets(20));
		otherClassroomButtons.setSpacing(20);

		VBox classroomBox = new VBox(classroomText, projectorQuestion, labQuestion, classroomQuestions, classroomButtons,
				otherClassroomButtons);
		classroomBox.setAlignment(Pos.CENTER);
		classroomBox.setBackground(new Background(bgi));
		addClassroom.setContent(classroomBox);

		addClassroomButton.setOnAction(e -> {
			String roomNum = getClassroomNum.getText().trim().toUpperCase();
			String buildingName = getBuildingName.getText().trim();
			String checkNumOfSeats = getNumOfSeats.getText().trim();
			boolean numOfSeatsBoolean = checkNumOfSeats.matches("([\\d]{2})");
			boolean roomNumberChecker = roomNum.matches("([a-zA-z]{1})([0-9]{3})");
			int numberOfSeats;

			if (roomNum.isEmpty() || buildingName.isEmpty() || checkNumOfSeats.isEmpty()) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Fields cannot be Empty");
				alert.showAndWait();
			} else if (numOfSeatsBoolean==false) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Number of seats are incorrect");
				alert.showAndWait();
			} else if(roomNumberChecker==false) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Room Number is Invalid");
				alert.showAndWait();
			} else {
				numberOfSeats = Integer.parseInt(checkNumOfSeats);
				boolean checkHasProjector = true;
				boolean checkHasLab = true;
				if (hasProjector.getValue().equals("false")) {
					checkHasProjector = false;
				}
				if (hasLab.getValue().equals("false")) {
					checkHasLab = false;
				}
				Classroom tempClassroom = new Classroom(roomNum, checkHasProjector, buildingName, checkHasLab,
						numberOfSeats);
				college.getClassroomBag().add(tempClassroom);
				alert.setAlertType(AlertType.INFORMATION);
				alert.setTitle("Successful");
				alert.setContentText("Classroom has been added");
				alert.showAndWait();
				getClassroomNum.clear();
				getBuildingName.clear();
				getNumOfSeats.clear();
			}
		});
		
		importClassroomButton.setOnAction(e->{
			FileChooser ClassroomImport = new FileChooser();
			File importClassroomFile = ClassroomImport.showOpenDialog(stage2);
			if (importClassroomFile!= null) {
				try {
					scannerInput = new Scanner(importClassroomFile);
					while (scannerInput.hasNextLine()) {
						String line = scannerInput.nextLine();
						String[] classroomInfo = line.split(", ");
						Classroom tempClassroom = new Classroom(classroomInfo[0],Boolean.valueOf(classroomInfo[1]),classroomInfo[2],
													Boolean.valueOf(classroomInfo[3]),Integer.parseInt(classroomInfo[4]));
						
						college.getClassroomBag().add(tempClassroom);
						college.save();
					}
				} catch (FileNotFoundException e1) {
				}
				}
		});

		backClassroomButton.setOnAction(e -> {
			stage.setScene(scene);
		});

		clearClassroom.setOnAction(e -> {
			getClassroomNum.clear();
			getBuildingName.clear();
			getNumOfSeats.clear();

		});

		exitClassroomButton.setOnAction(e -> {
			college.save();
			Platform.exit();
		});

		Tab addTextbook = new Tab("Add Textbook");

		Text addTextbookText = new Text();
		addTextbookText.setText("Add a textbook to the school Database");
		addTextbookText.setStyle(LABEL_FONT);
		addTextbookText.setFill(Color.WHITE);
		Button addTextbookButton = new Button("Add");
		addTextbookButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		addTextbookButton.setStyle(BUTTON_FONT);
		addTextbookButton.setTextFill(Color.BLUE);
		Button clearTextbookButton = new Button("Clear");
		clearTextbookButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		clearTextbookButton.setStyle(BUTTON_FONT);
		clearTextbookButton.setTextFill(Color.BLUE);
		Button exitTextbookButton = new Button("Exit");
		exitTextbookButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		exitTextbookButton.setStyle(BUTTON_FONT);
		exitTextbookButton.setTextFill(Color.BLUE);
		Button backTextbookButton = new Button("Log out");
		backTextbookButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		backTextbookButton.setStyle(BUTTON_FONT);
		backTextbookButton.setTextFill(Color.BLUE);
		Button importTextbookButton = new Button("Import Textbooks");
		importTextbookButton.setStyle(BUTTON_FONT);
		importTextbookButton.setTextFill(Color.BLUE);
		importTextbookButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);

		TextField getTextbookTitle = new TextField();
		getTextbookTitle.setStyle(TEXT_FIELD_FONT);
		getTextbookTitle.setPromptText("Textbook Name");
		TextField getAuthorFirstName = new TextField();
		getAuthorFirstName.setStyle(TEXT_FIELD_FONT);
		getAuthorFirstName.setPromptText("Author first name");
		TextField getAuthorLastName = new TextField();
		getAuthorLastName.setStyle(TEXT_FIELD_FONT);
		getAuthorLastName.setPromptText("Author last name");
		TextField getPublisher = new TextField();
		getPublisher.setStyle(TEXT_FIELD_FONT);
		getPublisher.setPromptText("Publisher");
		TextField getTextbookIsbn = new TextField();
		getTextbookIsbn.setStyle(TEXT_FIELD_FONT);
		getTextbookIsbn.setPromptText("ISBN number");
		TextField getTextbookPrice = new TextField();
		getTextbookPrice.setStyle(TEXT_FIELD_FONT);
		getTextbookPrice.setPromptText("Textbook Price");

		HBox textbookTitleField = new HBox();
		textbookTitleField.getChildren().addAll(getTextbookTitle, getTextbookPrice);
		textbookTitleField.setPadding(new Insets(20));
		textbookTitleField.setAlignment(Pos.CENTER);
		textbookTitleField.setSpacing(20);
		HBox textbookAuthorFields = new HBox();
		textbookAuthorFields.getChildren().addAll(getAuthorFirstName, getAuthorLastName);
		textbookAuthorFields.setPadding(new Insets(20));
		textbookAuthorFields.setAlignment(Pos.CENTER);
		textbookAuthorFields.setSpacing(20);
		HBox textbookISBNFields = new HBox();
		textbookISBNFields.getChildren().addAll(getTextbookIsbn, getPublisher);
		textbookISBNFields.setPadding(new Insets(20));
		textbookISBNFields.setAlignment(Pos.CENTER);
		textbookISBNFields.setSpacing(20);
		HBox textbookButtons = new HBox(importTextbookButton,addTextbookButton, clearTextbookButton);
		textbookButtons.setAlignment(Pos.CENTER);
		textbookButtons.getChildren().addAll();
		textbookButtons.setPadding(new Insets(20));
		textbookButtons.setSpacing(20);
		HBox otherTextbookButtons = new HBox(exitTextbookButton, backTextbookButton);
		otherTextbookButtons.setAlignment(Pos.CENTER);
		otherTextbookButtons.getChildren().addAll();
		otherTextbookButtons.setPadding(new Insets(20));
		otherTextbookButtons.setSpacing(20);
		VBox textbookFields = new VBox(addTextbookText, textbookTitleField, textbookAuthorFields, textbookISBNFields,
				textbookButtons, otherTextbookButtons);
		textbookFields.setAlignment(Pos.CENTER);
		textbookFields.setBackground(new Background(bgi));
		addTextbook.setContent(textbookFields);

		addTextbookButton.setOnAction(e -> {
			String textbookTitle = getTextbookTitle.getText().trim();
			String checkTextbookPrice = getTextbookPrice.getText().trim();
			String textbookIsbn = getTextbookIsbn.getText().trim();
			String authorFirstName = getAuthorFirstName.getText().trim();
			String authorLastName = getAuthorLastName.getText().trim();
			String publisher = getPublisher.getText().trim();
			
			boolean ISBNchecker=textbookIsbn.matches("([0-9]{3})(-)?([0-9]{4})(-)?([0-9]{3})");
			boolean isMatching = checkTextbookPrice.matches("([0-9]+[.])([0-9]{2})");
			if (textbookTitle.isEmpty() || checkTextbookPrice.isEmpty() || textbookIsbn.isEmpty()
					|| authorFirstName.isEmpty() || authorLastName.isEmpty() || publisher.isEmpty()) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Fields Cannot Be Left Empty");
				alert.showAndWait();
			} else if (isMatching == false) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Invalid Price Entered");
				alert.showAndWait();
			}else if(ISBNchecker==false){
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Invalid ISBN Number Entered");
				alert.showAndWait();
			}else {
				Textbook tempBook = new Textbook(textbookTitle, new Name(authorFirstName, authorLastName), publisher,
						textbookIsbn, Double.parseDouble(checkTextbookPrice));
				college.getTextbookBag().add(tempBook);
				college.save();
				getTextbookTitle.clear();
				getTextbookPrice.clear();
				getTextbookIsbn.clear();
				getAuthorFirstName.clear();
				getAuthorLastName.clear();
				getPublisher.clear();
				alert.setAlertType(AlertType.INFORMATION);
				alert.setTitle("Sucessful");
				alert.setContentText("The Textbook Has Been Added");
				alert.showAndWait();
			}

		});
		
		importTextbookButton.setOnAction(e->{
			FileChooser TextbookImport = new FileChooser();
			File importTextbookFile = TextbookImport.showOpenDialog(stage2);
			if (importTextbookFile!= null) {
				try {
					scannerInput = new Scanner(importTextbookFile);
					while (scannerInput.hasNextLine()) {
						String line = scannerInput.nextLine();
						String[] textbookInfo = line.split(", ");
						Textbook tempTextbook = new Textbook(textbookInfo[0],new Name(textbookInfo[1],textbookInfo[2]),
													textbookInfo[3],textbookInfo[4],Double.parseDouble(textbookInfo[5]));
						
						college.getTextbookBag().add(tempTextbook);
						college.save();
					}
				} catch (FileNotFoundException e1) {
			  }
			}
		});

		clearTextbookButton.setOnAction(e -> {
			getTextbookTitle.clear();
			getTextbookPrice.clear();
			getTextbookIsbn.clear();
			getAuthorFirstName.clear();
			getAuthorLastName.clear();
			getPublisher.clear();
		});

		exitTextbookButton.setOnAction(e -> {
			college.save();
			Platform.exit();
		});

		backTextbookButton.setOnAction(e -> {
			stage.setScene(scene);
		});

		Tab additionalFeatures = new Tab("Addition Features");
		
		Text gradeToStudentText = new Text();
		gradeToStudentText.setText("Assign Grade to Student");
		gradeToStudentText.setStyle(TEXT_FIELD_FONT);
		gradeToStudentText.setFill(Color.WHITE);
		Button gradeToStudentButton = new Button("Assign Grade");
		gradeToStudentButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		gradeToStudentButton.setStyle(BUTTON_FONT);
		gradeToStudentButton.setTextFill(Color.BLUE);
		TextField getStudentId = new TextField();
		getStudentId.setPromptText("Student ID");
		getStudentId.setStyle(TEXT_FIELD_FONT);
		TextField getCourseNumberForGrade = new TextField();
		getCourseNumberForGrade.setPromptText("Course Num");
		getCourseNumberForGrade.setStyle(TEXT_FIELD_FONT);
		TextField getLetterGrade = new TextField();
		getLetterGrade.setPromptText("Grade");
		getLetterGrade.setMaxWidth(110);
		getLetterGrade.setStyle(TEXT_FIELD_FONT);
		
		HBox addGradeBox = new HBox();
		addGradeBox.getChildren().addAll(getStudentId, getCourseNumberForGrade,getLetterGrade,gradeToStudentButton);
		addGradeBox.setPadding(new Insets(20));
		addGradeBox.setAlignment(Pos.CENTER);
		addGradeBox.setSpacing(20);
		
		gradeToStudentButton.setOnAction(e->{
		
		String assignGradeStudentId = getStudentId.getText().trim();
		String assignGradeCourseNumber = getCourseNumberForGrade.getText().trim();
		String assignGradeLetterGrade = getLetterGrade.getText().trim().toUpperCase();
		boolean checkGrade = assignGradeLetterGrade.matches("([a-dfA-DF{1}][+]?)");
		if(college.getPersonBag().findPersonIdBoolean(assignGradeStudentId)==false) {
			alert.setAlertType(AlertType.ERROR);
			alert.setTitle("Warning");
			alert.setContentText("Student ID is Invalid");
			alert.show();
		}else if (college.getPersonBag().findById(assignGradeStudentId) instanceof Faculty) {
			alert.setAlertType(AlertType.ERROR);
			alert.setTitle("Warning");
			alert.setContentText("Invalid Student ID ");
			alert.show();
		}else if (college.getPersonBag().checkCoursesTakingBoolean(assignGradeStudentId, assignGradeCourseNumber)==false) {
			alert.setAlertType(AlertType.ERROR);
			alert.setTitle("Warning");
			alert.setContentText("Student is not currently enrolled in this class");
			alert.show();
		}else if (checkGrade==false) {
			alert.setAlertType(AlertType.ERROR);
			alert.setTitle("Warning");
			alert.setContentText("Invalid Letter Grade");
			alert.show();
		}else {
			Grade[] tempTaking = college.getPersonBag().getCoursesTakingById(assignGradeStudentId);
			for(int i =0;i<tempTaking.length;i++) {
				if(tempTaking[i].getCourseNumber().trim().toUpperCase().equalsIgnoreCase(assignGradeCourseNumber)) {
					
					((Student) college.getPersonBag().findById(assignGradeStudentId)).removeCourseTaking(assignGradeCourseNumber);   
					((Student) college.getPersonBag().findById(assignGradeStudentId)).addCoursesTook(new Grade(assignGradeCourseNumber.toUpperCase(),assignGradeLetterGrade.toUpperCase()));
					college.save();
					getStudentId.clear();
					getCourseNumberForGrade.clear();
					getLetterGrade.clear();
					alert.setAlertType(AlertType.INFORMATION);
					alert.setTitle("Successful");
					alert.setContentText("Grade Set For Student ");
					alert.show();
					
				}
			}
		}
		
		});

		

		Text assignFacultyToCourseText = new Text();
		assignFacultyToCourseText.setText("Assign Faculty to Course");
		assignFacultyToCourseText.setStyle(TEXT_FIELD_FONT);
		assignFacultyToCourseText.setFill(Color.WHITE);
		Button assignFacultyToCourse = new Button("Assign Faculty");
		assignFacultyToCourse.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		assignFacultyToCourse.setStyle(BUTTON_FONT);
		assignFacultyToCourse.setTextFill(Color.BLUE);
		TextField getCourseNumber = new TextField();
		getCourseNumber.setPromptText("Enter Course Number");
		getCourseNumber.setStyle(TEXT_FIELD_FONT);
		TextField getFacultyId = new TextField();
		getFacultyId.setPromptText("Enter ID Num");
		getFacultyId.setStyle(TEXT_FIELD_FONT);

		HBox assignFacultyToClassBox = new HBox();
		assignFacultyToClassBox.getChildren().addAll(getCourseNumber, getFacultyId, assignFacultyToCourse);
		assignFacultyToClassBox.setPadding(new Insets(20));
		assignFacultyToClassBox.setAlignment(Pos.CENTER);
		assignFacultyToClassBox.setSpacing(20);

		assignFacultyToCourse.setOnAction(e -> {
			String courseNumberForCourse = getCourseNumber.getText().trim();
			String facultyIdForCourse = getFacultyId.getText().trim();
			boolean checkCourseNumber = courseNumberForCourse.matches("(([a-zA-Z]{3})([\\d]{3}))");
			boolean checkFacultyID = facultyIdForCourse.matches("([\\d]{8})");

			if (courseNumberForCourse.isEmpty() || facultyIdForCourse.isEmpty()) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("All Fields Must Be Filled Out");
				alert.showAndWait();
			}else if (checkCourseNumber==false||checkFacultyID==false) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Invalid course Number or ID number ");
				alert.showAndWait();
			}else if (college.getCourseBag().findByCourseNumberBoolean(courseNumberForCourse) == false) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Invalid course Number ");
				alert.showAndWait();
			} else if (college.getPersonBag().findPersonIdBoolean(facultyIdForCourse) == false) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Invalid Faculty ID Number ");
				alert.showAndWait();
			} else {
				college.getCourseBag().findByCourseNumber(courseNumberForCourse).setFacultyID(facultyIdForCourse);
				college.save();
				getCourseNumber.clear();
				getFacultyId.clear();
				alert.setAlertType(AlertType.CONFIRMATION);
				alert.setTitle("Successful");
				alert.setContentText("You have updated Course number " + courseNumberForCourse);
				alert.showAndWait();
			}
		});

		Text assignCourseToRoomText = new Text();
		assignCourseToRoomText.setText("Assign Course To Room");
		assignCourseToRoomText.setStyle(TEXT_FIELD_FONT);
		assignCourseToRoomText.setFill(Color.WHITE);
		Button assignCourseToRoom = new Button("Assign Course");
		assignCourseToRoom.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		assignCourseToRoom.setStyle(BUTTON_FONT);
		assignCourseToRoom.setTextFill(Color.BLUE);
		TextField getCourseNumberForClassroom = new TextField();
		getCourseNumberForClassroom.setPromptText("Enter Course Number");
		getCourseNumberForClassroom.setStyle(TEXT_FIELD_FONT);
		TextField getRoomNumber = new TextField();
		getRoomNumber.setPromptText("Enter Room Num");
		getRoomNumber.setStyle(TEXT_FIELD_FONT);

		HBox assignCourseToRoomTextBox = new HBox();
		assignCourseToRoomTextBox.getChildren().addAll(getCourseNumberForClassroom, getRoomNumber, assignCourseToRoom);
		assignCourseToRoomTextBox.setPadding(new Insets(20));
		assignCourseToRoomTextBox.setAlignment(Pos.CENTER);
		assignCourseToRoomTextBox.setSpacing(20);
		
		assignCourseToRoom.setOnAction(e -> {
			String courseNumForClass = getCourseNumberForClassroom.getText().trim().toUpperCase();
			String roomNumForClass = getRoomNumber.getText().trim().toUpperCase();

			if (courseNumForClass.isEmpty() || roomNumForClass.isEmpty()) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("All Fields Must Be Filled Out");
				alert.showAndWait();
			} else if (college.getClassroomBag().checkIfRoomIsAvailable(roomNumForClass) == false) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Invalid Room Number ");
				alert.showAndWait();
			} else if (college.getCourseBag().findByCourseNumberBoolean(courseNumForClass) == false) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Invalid Course Number ");
				alert.showAndWait();
			} else {
				college.getClassroomBag().setCourseByRoomNum(
						college.getCourseBag().findByCourseNumber(courseNumForClass), roomNumForClass);
				college.save();
				getCourseNumberForClassroom.clear();
				getRoomNumber.clear();
				alert.setAlertType(AlertType.CONFIRMATION);
				alert.setTitle("Successful");
				alert.setContentText("You have updated the Classroom for the course ");
				alert.showAndWait();
			}
		});

		Text assignTextbookToCourseText = new Text();
		assignTextbookToCourseText.setText("Assign Textbook To Course");
		assignTextbookToCourseText.setStyle(TEXT_FIELD_FONT);
		assignTextbookToCourseText.setFill(Color.WHITE);
		Button assignTextbookToCourse = new Button("Assign Textbook");
		assignTextbookToCourse.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		assignTextbookToCourse.setStyle(BUTTON_FONT);
		assignTextbookToCourse.setTextFill(Color.BLUE);
		TextField getCourseNumberForTextbook = new TextField();
		getCourseNumberForTextbook.setPromptText("Enter Course Number");
		getCourseNumberForTextbook.setStyle(TEXT_FIELD_FONT);
		TextField getISBN = new TextField();
		getISBN.setPromptText("Enter ISBN Num");
		getISBN.setStyle(TEXT_FIELD_FONT);

		HBox assignTextbookToCourseTextBox = new HBox();
		assignTextbookToCourseTextBox.getChildren().addAll(getCourseNumberForTextbook, getISBN, assignTextbookToCourse);
		assignTextbookToCourseTextBox.setPadding(new Insets(20));
		assignTextbookToCourseTextBox.setAlignment(Pos.CENTER);
		assignTextbookToCourseTextBox.setSpacing(20);

		assignTextbookToCourse.setOnAction(e -> {
			String courseNumForTextbook = getCourseNumberForTextbook.getText().trim().toUpperCase();
			String theISBN = getISBN.getText().trim();
			boolean checkTheISBN = theISBN.matches("([0-9]{3})(-)?([0-9]{4})(-)?([0-9]{3})");
			if (courseNumForTextbook.isEmpty() || theISBN.isEmpty()) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("All Fields Must Be Filled Out");
				alert.showAndWait();
			} else if (college.getCourseBag().findByCourseNumberBoolean(courseNumForTextbook) == false) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Invalid Course Number ");
				alert.showAndWait();
			} else if (college.getTextbookBag().isTextbookThereBoolean(theISBN) == false) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Invalid Textbook ISBN ");
				alert.showAndWait();
			}else if(checkTheISBN==false) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Invalid Textbook ISBN ");
				alert.showAndWait();
			} else {
				college.getCourseBag().findByCourseNumber(courseNumForTextbook).setTextBookISBN(theISBN);
				college.save();
				getCourseNumberForTextbook.clear();
				getISBN.clear();
				alert.setAlertType(AlertType.CONFIRMATION);
				alert.setTitle("Successful");
				alert.setContentText("You have updated the Course Textbook ");
				alert.showAndWait();
			}
		});

		Button exportPeoples = new Button("Export Peoples");
		exportPeoples.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		exportPeoples.setStyle(BUTTON_FONT);
		exportPeoples.setTextFill(Color.BLUE);
		Button exportCourses = new Button("Export Courses");
		exportCourses.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		exportCourses.setStyle(BUTTON_FONT);
		exportCourses.setTextFill(Color.BLUE);
		Button exportClassrooms = new Button("Export Classrooms");
		exportClassrooms.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		exportClassrooms.setStyle(BUTTON_FONT);
		exportClassrooms.setTextFill(Color.BLUE);
		Button exportTextbooks = new Button("Export Textbooks");
		exportTextbooks.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		exportTextbooks.setStyle(BUTTON_FONT);
		exportTextbooks.setTextFill(Color.BLUE);

		HBox exportButtons = new HBox();
		exportButtons.getChildren().addAll(exportPeoples, exportCourses, exportClassrooms, exportTextbooks);
		exportButtons.setPadding(new Insets(20));
		exportButtons.setAlignment(Pos.CENTER);
		exportButtons.setSpacing(20);

		exportClassrooms.setOnAction(e -> {
			FileChooser classroomChooser = new FileChooser();
			FileChooser.ExtensionFilter classroomExtFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)",
					"*.txt");
			classroomChooser.getExtensionFilters().add(classroomExtFilter);
			File classroomFile = classroomChooser.showSaveDialog(stage2);
			if (classroomFile != null) {
				try {
					PrintWriter classroomWriter = new PrintWriter(classroomFile);

					for (int i = 0; i < college.getClassroomBag().getClassrromArray().length; i++) {
						classroomWriter.println("Building Name: "
								+ college.getClassroomBag().getClassrromArray()[i].getBuilding() + "		Room #: "
								+ college.getClassroomBag().getClassrromArray()[i].getRoomNumber()
								+ "		Num of Seats: "
								+ college.getClassroomBag().getClassrromArray()[i].getNumberOfSeats());
					}
					classroomWriter.close();
				} catch (FileNotFoundException e1) {
					alert.setAlertType(AlertType.ERROR);
					alert.setTitle("Warning");
					alert.setContentText("Export Failed");
				}
			}
		});

		exportTextbooks.setOnAction(e -> {
			FileChooser textbookChooser = new FileChooser();
			FileChooser.ExtensionFilter textbookExtFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)",
					"*.txt");
			textbookChooser.getExtensionFilters().add(textbookExtFilter);
			File textbookFile = textbookChooser.showSaveDialog(stage2);
			if (textbookFile != null) {
				try {
					PrintWriter textbookWriter = new PrintWriter(textbookFile);

					for (int i = 0; i < college.getTextbookBag().getTextbookArray().length; i++) {
						textbookWriter.println("Title: " + college.getTextbookBag().getTextbookArray()[i].getTitle()
								+ "		ISBN: " + college.getTextbookBag().getTextbookArray()[i].getIsbn()
								+ "			Price: $" + college.getTextbookBag().getTextbookArray()[i].getPrice()
								+ "		Author Name: " + college.getTextbookBag().getTextbookArray()[i].getName());
					}
					textbookWriter.close();
				} catch (FileNotFoundException e1) {
					alert.setAlertType(AlertType.ERROR);
					alert.setTitle("Warning");
					alert.setContentText("Export Failed");
				}
			}
		});

		exportPeoples.setOnAction(e -> {
			FileChooser peoplesChooser = new FileChooser();
			FileChooser.ExtensionFilter peoplesExtension = new FileChooser.ExtensionFilter("TXT files (*.txt)",
					"*.txt");
			peoplesChooser.getExtensionFilters().add(peoplesExtension);
			File peoplesFile = peoplesChooser.showSaveDialog(stage2);

			if (peoplesFile != null) {
				try {
					PrintWriter printPeoples = new PrintWriter(peoplesFile);
					for (int i = 0; i < college.getPersonBag().getPersonBagCopy().length; i++) {
						printPeoples.println("Name: " + college.getPersonBag().getPersonBagCopy()[i].getName()
								+ "		Phone #: " + college.getPersonBag().getPersonBagCopy()[i].getPhone()
								+ "		Address: " + college.getPersonBag().getPersonBagCopy()[i].getAddress());
					}
					printPeoples.close();
				} catch (FileNotFoundException e1) {
					alert.setAlertType(AlertType.ERROR);
					alert.setTitle("Warning");
					alert.setContentText("Export Failed");
				}

			}
		});

		exportCourses.setOnAction(c -> {
			FileChooser coursesChooser = new FileChooser();
			FileChooser.ExtensionFilter coursesExtFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)",
					"*.txt");
			coursesChooser.getExtensionFilters().add(coursesExtFilter);
			File coursesFile = coursesChooser.showSaveDialog(stage2);
			if (coursesFile != null) {

				try {
					PrintWriter printCourses = new PrintWriter(coursesFile);
					for (int i = 0; i < college.getCourseBag().getCourseArray().length; i++) {
						printCourses.println("Course #: " + college.getCourseBag().getCourseArray()[i].getCourseNumber()
								+ "		Course Title: " + college.getCourseBag().getCourseArray()[i].getCourseTitle()
								+ "		Num of Credits: "
								+ college.getCourseBag().getCourseArray()[i].getNumOfCredits());
					}
					printCourses.close();
				} catch (FileNotFoundException e1) {
					alert.setAlertType(AlertType.ERROR);
					alert.setTitle("Warning");
					alert.setContentText("Export Failed");
				}

			}
		});

		VBox allOtherFields = new VBox(gradeToStudentText, addGradeBox, assignFacultyToCourseText,
				assignFacultyToClassBox, assignCourseToRoomText, assignCourseToRoomTextBox, assignTextbookToCourseText,
				assignTextbookToCourseTextBox, exportButtons);
		allOtherFields.setAlignment(Pos.CENTER);
		allOtherFields.setBackground(new Background(bgi));
		additionalFeatures.setContent(allOtherFields);
		
		Tab removalFeatures = new Tab("removal Features");
		
		Text removePersonText = new Text();
		removePersonText.setText("Remove Student or Faculty");
		removePersonText.setStyle(LABEL_FONT);
		removePersonText.setFill(Color.WHITE);
		Button removePerson = new Button("Remove Person");
		removePerson.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		removePerson.setStyle(BUTTON_FONT);
		removePerson.setTextFill(Color.BLUE);
		TextField getPersonId = new TextField();
		getPersonId.setPromptText("Enter ID Num");
		getPersonId.setStyle(TEXT_FIELD_FONT);

		HBox removePersonBox = new HBox();
		removePersonBox.getChildren().addAll(getPersonId,removePerson);
		removePersonBox.setPadding(new Insets(20));
		removePersonBox.setAlignment(Pos.CENTER);
		removePersonBox.setSpacing(20);

		removePerson.setOnAction(e -> {
			String getIdNumber = getPersonId.getText().trim();
			boolean checkIdNumber=getIdNumber.matches("([\\d]{8})");
			if (getIdNumber.isEmpty()) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("All Fields Must Be Filled Out");
				alert.showAndWait();
			}else if(checkIdNumber==false) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Id Number is Invalid");
				alert.showAndWait();
			}else if (college.getPersonBag().findPersonIdBoolean(getIdNumber) == false) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Id Number is Invalid");
				alert.showAndWait();
			} else {
				college.getPersonBag().removeById(getIdNumber);
				college.save();
				getPersonId.clear();
				alert.setAlertType(AlertType.CONFIRMATION);
				alert.setTitle("Successful");
				alert.setContentText("You Have Removed Id Number " + getIdNumber);
				alert.showAndWait();
			}
		});
		
		Text removeCourseText = new Text();
		removeCourseText.setText("Remove a Course From School Database");
		removeCourseText.setStyle(LABEL_FONT);
		removeCourseText.setFill(Color.WHITE);
		TextField getCourseNumRemoveCourse = new TextField();
		getCourseNumRemoveCourse.setStyle(TEXT_FIELD_FONT);
		getCourseNumRemoveCourse.setPromptText("Course Number");
		Button removeCourseButton = new Button("Remove Course");
		removeCourseButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		removeCourseButton.setStyle(BUTTON_FONT);
		removeCourseButton.setTextFill(Color.BLUE);
		
		HBox removeCourseBox = new HBox();
		removeCourseBox.getChildren().addAll(getCourseNumRemoveCourse,removeCourseButton);
		removeCourseBox.setPadding(new Insets(20));
		removeCourseBox.setAlignment(Pos.CENTER);
		removeCourseBox.setSpacing(20);
		
		removeCourseButton.setOnAction(e->{
			String removeCourseNumber = getCourseNumRemoveCourse.getText().trim();
			if(college.getCourseBag().findByCourseNumberBoolean(removeCourseNumber)==false) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Course Number is Invalid");
				alert.showAndWait();
			}else {
				college.getCourseBag().removeByCourseNumber(removeCourseNumber);
				college.save();
				getCourseNumRemoveCourse.clear();
				alert.setAlertType(AlertType.CONFIRMATION);
				alert.setTitle("Successful");
				alert.setContentText("Course Has Been Removed");
				alert.showAndWait();
			}
		});
		
		Text removeTextbookText = new Text();
		removeTextbookText.setText("Remove Textbook From School Database");
		removeTextbookText.setStyle(LABEL_FONT);
		removeTextbookText.setFill(Color.WHITE);
		Button removeTextbook = new Button("Remove Textbook");
		removeTextbook.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		removeTextbook.setStyle(BUTTON_FONT);
		removeTextbook.setTextFill(Color.BLUE);
		TextField getTextbookISBN = new TextField();
		getTextbookISBN.setPromptText("Enter ISBN Num");
		getTextbookISBN.setStyle(TEXT_FIELD_FONT);

		HBox removeTextbookBox = new HBox();
		removeTextbookBox.getChildren().addAll(getTextbookISBN,removeTextbook);
		removeTextbookBox.setPadding(new Insets(20));
		removeTextbookBox.setAlignment(Pos.CENTER);
		removeTextbookBox.setSpacing(20);

		removeTextbook.setOnAction(e -> {
			String isISBNNumber = getTextbookISBN.getText().trim();
			boolean checkISBNNumber = isISBNNumber.matches("([0-9]{3})(-)?([0-9]{4})(-)?([0-9]{3})");
			if (isISBNNumber.isEmpty()) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("All Fields Must Be Filled Out");
				alert.showAndWait();
			}else if(checkISBNNumber==false) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("ISBN Number is Invalid");
				alert.showAndWait();
			}else if(college.getTextbookBag().isTextbookThereBoolean(isISBNNumber)==false) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("ISBN Number is Invalid");
				alert.showAndWait();
			}else {
				college.getTextbookBag().removeByIsbn(isISBNNumber);
				college.save();
				getTextbookISBN.clear();
				alert.setAlertType(AlertType.INFORMATION);
				alert.setTitle("Successful");
				alert.setContentText("Textbook has been removed");
				alert.showAndWait();
			}
		});
		
		Text removeClassroomText = new Text();
		removeClassroomText.setText("Remove Classroom From School Database");
		removeClassroomText.setStyle(LABEL_FONT);
		removeClassroomText.setFill(Color.WHITE);
		Button removeClassroomButton = new Button("Remove Classroom");
		removeClassroomButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		removeClassroomButton.setStyle(BUTTON_FONT);
		removeClassroomButton.setTextFill(Color.BLUE);
		TextField getClassRoomNumber = new TextField();
		getClassRoomNumber.setPromptText("Enter Room Num");
		getClassRoomNumber.setStyle(TEXT_FIELD_FONT);
		
		HBox removeClassroomBox = new HBox();
		removeClassroomBox.getChildren().addAll(getClassRoomNumber,removeClassroomButton);
		removeClassroomBox.setPadding(new Insets(20));
		removeClassroomBox.setAlignment(Pos.CENTER);
		removeClassroomBox.setSpacing(20);
		
		removeClassroomButton.setOnAction(e->{
			String roomNum = getClassRoomNumber.getText().trim().toUpperCase();
			boolean checkRoomNum = roomNum.matches("([a-zA-z]{1})([0-9]{3})");
			if(roomNum.isEmpty()) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("All Fields Must Be Filled Out");
				alert.showAndWait();
			}else if(checkRoomNum==false) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Room Number is Invalid");
				alert.showAndWait();
			}else if(college.getClassroomBag().checkIfRoomIsAvailable(roomNum)==false) {
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Room Number is Invalid");
				alert.showAndWait();
			}else {
				college.getClassroomBag().removeByRoomNumber(roomNum);
				college.save();
				getClassRoomNumber.clear();
				alert.setAlertType(AlertType.INFORMATION);
				alert.setTitle("Successful");
				alert.setContentText("Room Has Been Removed From School");
				alert.showAndWait();
				
			}
		});
		
		
		VBox removalBox = new VBox();
		removalBox.getChildren().addAll(removePersonText,removePersonBox,removeCourseText,removeCourseBox,removeTextbookText
											,removeTextbookBox,removeClassroomText,removeClassroomBox);
		removalBox.setAlignment(Pos.CENTER);
		removalBox.setBackground(new Background(bgi));
		removalFeatures.setContent(removalBox);

		tabPane.getTabs().addAll(addStudent, addFaculty, addCourse, addClassroom, addTextbook, additionalFeatures,removalFeatures);
		scene3 = new Scene(tabPane, 1100, 800);
	}

	public Scene getScene() {
		return scene3;
	}

}
