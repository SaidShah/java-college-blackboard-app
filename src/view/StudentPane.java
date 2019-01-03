package view;

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
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

public class StudentPane {
	final int BUTTON_WIDTH = 240;
	final int BUTTON_HEIGHT = 80;
	final String TEXT_FIELD_FONT = "-fx-font: 24 papyrus";
	final String LABEL_FONT = "-fx-font: 34 papyrus";
	final String BUTTON_FONT = "-fx-font: 19 papyrus";
	Scene scene4;
	Stage stage2 = new Stage();

	public StudentPane(College college, Stage stage,Scene scene, String idNumber) {
		Image image = new Image("file:images/image4.png");
		BackgroundImage bgi = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
		          BackgroundSize.DEFAULT);
		TabPane tabPane = new TabPane();
		
		Tab studentMenu = new Tab("Student Menu");
		
	//	tabPane.setBackground(new Background(bgi));
		TextArea textArea = new TextArea();
		textArea.setMaxHeight(200);
		textArea.setMaxWidth(400);
		textArea.setStyle("-fx-font: 15 papyrus");
		textArea.setEditable(false);
		stage2.sizeToScene();
		Alert alert = new Alert(AlertType.ERROR);
		String studentIdNumber = idNumber;

		Button printCoursesNeeded = new Button("Export New Schedule");
		printCoursesNeeded.setTextFill(Color.BLUE);
		printCoursesNeeded.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		printCoursesNeeded.setStyle(BUTTON_FONT);
		Button printCoursesTaking = new Button("Export Curr. Schedule");
		printCoursesTaking.setTextFill(Color.BLUE);
		printCoursesTaking.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		printCoursesTaking.setStyle(BUTTON_FONT);
		Button addCourse = new Button("Add Course");
		addCourse.setTextFill(Color.BLUE);
		addCourse.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		addCourse.setStyle(BUTTON_FONT);

		Button logOutButton = new Button("Log Out");
		logOutButton.setTextFill(Color.BLUE);
		logOutButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		logOutButton.setStyle(BUTTON_FONT);
		Button saveButton = new Button("Save");
		saveButton.setTextFill(Color.BLUE);
		saveButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		saveButton.setStyle(BUTTON_FONT);

		Button getCoursesToTake = new Button("Next Semester");
		getCoursesToTake.setTextFill(Color.BLUE);
		getCoursesToTake.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		getCoursesToTake.setStyle(BUTTON_FONT);
		Button getGPACoursesTook = new Button("Previous GPA");
		getGPACoursesTook.setTextFill(Color.BLUE);
		getGPACoursesTook.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		getGPACoursesTook.setStyle(BUTTON_FONT);
		Button getGPACoursesTaking= new Button("Current Schedule");
		getGPACoursesTaking.setTextFill(Color.BLUE);
		getGPACoursesTaking.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		getGPACoursesTaking.setStyle(BUTTON_FONT);

		TextField courseNumber = new TextField();
		courseNumber.setStyle(TEXT_FIELD_FONT);
		courseNumber.setPromptText("Course Number eg: CST242");
		courseNumber.setMaxWidth(360);

		Text instructions = new Text("Fill in the Course Number to Add a Course\n");
		instructions.setStyle(TEXT_FIELD_FONT);
		instructions.setFill(Color.WHITE);

		HBox nonGPAbuttons = new HBox(50);
		nonGPAbuttons.setAlignment(Pos.CENTER);
		nonGPAbuttons.getChildren().addAll(printCoursesNeeded,addCourse,printCoursesTaking);
		nonGPAbuttons.setPadding(new Insets(20));
		nonGPAbuttons.setSpacing(20);
		HBox GPAbuttons = new HBox(50);
		GPAbuttons.setAlignment(Pos.CENTER);
		GPAbuttons.getChildren().addAll(getGPACoursesTaking,getCoursesToTake,getGPACoursesTook);
		GPAbuttons.setPadding(new Insets(20));
		GPAbuttons.setSpacing(20);
		HBox settingButtons = new HBox(50);
		settingButtons.setAlignment(Pos.CENTER);
		settingButtons.getChildren().addAll(saveButton,textArea,logOutButton);
		settingButtons.setPadding(new Insets(20));
		settingButtons.setSpacing(20);
		VBox allButtons = new VBox(instructions,courseNumber,nonGPAbuttons,settingButtons,GPAbuttons);
		allButtons.setAlignment(Pos.CENTER);
		allButtons.setBackground(new Background(bgi));
		studentMenu.setContent(allButtons);
		
		


		logOutButton.setOnAction(event->{
			stage.setScene(scene);
			college.save();
		});

		addCourse.setOnAction(event->{

			String numberOfCourse=courseNumber.getText().trim();
			boolean numberMatches = numberOfCourse.matches("(([a-zA-Z]{3})([\\d]{3}))");
			if(numberOfCourse.isEmpty()) {
				alert.setTitle("Warning");
				alert.setContentText("All fields must be filled out");
				alert.showAndWait();
			}else if(college.getCourseBag().findByCourseNumberBoolean(numberOfCourse)==false) {
				alert.setTitle("Warning");
				alert.setContentText("Course Number is Invalid");
				alert.showAndWait();
			}else if(numberMatches==false) {
				alert.setTitle("Warning");
				alert.setContentText("Please check the Course Number");
				alert.showAndWait();
			}else if (college.getPersonBag().checkCoursesTakingBoolean(studentIdNumber, numberOfCourse)==true){
				alert.setTitle("Warning");
				alert.setContentText("You are already Taking that course");
				alert.showAndWait();
			}else if (college.getPersonBag().checkCoursesTookBoolean(studentIdNumber, numberOfCourse)==true){
				alert.setTitle("Warning");
				alert.setContentText("You are already Took that course");
				alert.showAndWait();
			}else if (college.getPersonBag().checkCoursesToTakeBoolean(studentIdNumber, numberOfCourse)==true){
				alert.setTitle("Warning");
				alert.setContentText("The Course is already on your schedule");
				alert.showAndWait();
			}else {
				((Student) college.getPersonBag().findById(studentIdNumber)).addCoursesToTake(new Grade(numberOfCourse.toUpperCase()));    
				courseNumber.clear();
			}
		});

		saveButton.setOnAction(event->{
			college.save();
		});

		printCoursesTaking.setOnAction(event->{
			Grade[] tempCoursesTaking1=college.getPersonBag().getCoursesTakingById(idNumber);
			FileChooser coursesTakingChooser = new FileChooser();
			FileChooser.ExtensionFilter coursesTakingExtFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)",
					"*.txt");
			coursesTakingChooser.getExtensionFilters().add(coursesTakingExtFilter);
			File coursesTakingFile = coursesTakingChooser.showSaveDialog(stage2);
			if (coursesTakingFile != null) {

				try {
					PrintWriter printingCoursesTaking = new PrintWriter(coursesTakingFile);
					for (int i = 0; i < tempCoursesTaking1.length; i++) {
						printingCoursesTaking.println("Course Number:	"+tempCoursesTaking1[i].getCourseNumber().toUpperCase());
					}
					printingCoursesTaking.close();
				} catch (FileNotFoundException e1) {
					alert.setAlertType(AlertType.ERROR);
					alert.setTitle("Warning");
					alert.setContentText("Export Failed");
				}

			}
		});

		printCoursesNeeded.setOnAction(event->{
			Grade[] tempCoursesToTake= college.getPersonBag().getCoursesToTakeById(studentIdNumber);
			FileChooser coursesToTakeChooser = new FileChooser();
			FileChooser.ExtensionFilter coursesToTakeExtFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)",
					"*.txt");
			coursesToTakeChooser.getExtensionFilters().add(coursesToTakeExtFilter);
			File coursesToTakeFile = coursesToTakeChooser.showSaveDialog(stage2);
			if (coursesToTakeFile != null) {

				try {
					PrintWriter printingCoursesToTake = new PrintWriter(coursesToTakeFile);
					for (int i = 0; i < tempCoursesToTake.length; i++) {
						printingCoursesToTake.println("Course Number:	"+tempCoursesToTake[i].getCourseNumber().toUpperCase());
					}
					printingCoursesToTake.close();
				} catch (FileNotFoundException e1) {
					alert.setAlertType(AlertType.ERROR);
					alert.setTitle("Warning");
					alert.setContentText("Export Failed");
				}

			}
		});


		getCoursesToTake.setOnAction(event->{
			textArea.clear();
			Grade[] coursesToTake= college.getPersonBag().getCoursesToTakeById(studentIdNumber);
			textArea.appendText("  Course Number\n");
			for(int i =0;i<coursesToTake.length;i++) {
				textArea.appendText("  "+coursesToTake[i].getCourseNumber().toUpperCase()+"\n");
			}
		});


		getGPACoursesTaking.setOnAction(event->{
			textArea.clear();
			Grade[] tempCoursesTaking=college.getPersonBag().getCoursesTakingById(idNumber);
			textArea.appendText("Course Number\n");
			for(int i =0;i<tempCoursesTaking.length;i++){
				textArea.appendText(tempCoursesTaking[i].getCourseNumber().toUpperCase()+"\n");
			}
		});

		getGPACoursesTook.setOnAction(event->{
			textArea.clear();
			Grade[] tempCoursesTook = college.getPersonBag().getCoursesTookById(idNumber);
			textArea.appendText("Course Number"+"  	 "+"Grade\n");
			for(int i =0;i<tempCoursesTook.length;i++){
				textArea.appendText(tempCoursesTook[i].getCourseNumber().toUpperCase()+" 			  "+
					tempCoursesTook[i].getLetterGrade().toUpperCase()+"\n");

			}

			textArea.appendText("Overall GPA: "+"    "+
					college.getPersonBag().getGPACoursesTookById(studentIdNumber, college.getCourseBag()));

		});

		Text courseViewLabel = new Text();
		courseViewLabel.setText("Courses Available For  "+college.getPersonBag().findById(idNumber).getName().getFirstName()+" "
										+ college.getPersonBag().findById(idNumber).getName().getLastName());
		courseViewLabel.setStyle(LABEL_FONT);
		courseViewLabel.setFill(Color.WHITE);
		
		
		
		TextArea courseView = new TextArea();
		courseView.setMaxSize(650, 900);
		courseView.setMinSize(550, 600);
		courseView.setStyle("-fx-font: 15 papyrus");
		courseView.setEditable(false);

		
		Tab allCourses = new Tab("Courses Available");
		allCourses.setOnSelectionChanged(e->{
			Course[] tempCoursesForCourseView = college.checkAllClasses(idNumber);
			courseView.clear();
			courseView.appendText("Course Number			Course Description\n");
			for(int i= 0;i<tempCoursesForCourseView.length;i++) {
				courseView.appendText(tempCoursesForCourseView[i].getCourseNumber().toUpperCase()+"					"+
							tempCoursesForCourseView[i].getCourseTitle().trim()+"	\n");
			}
		});

		VBox showAllCourses = new VBox();
		showAllCourses.setBackground(new Background(bgi));
		showAllCourses.getChildren().addAll(courseViewLabel,courseView);
		showAllCourses.setAlignment(Pos.CENTER);
		allCourses.setContent(showAllCourses);
		
		
		
		
		tabPane.getTabs().addAll(studentMenu,allCourses);
		scene4 = new Scene(tabPane,1100,800);
	}

	public Scene getScene() {
		return scene4;
	}
}
