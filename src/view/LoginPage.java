package view;

import model.*; 
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginPage {
	final int BUTTON_WIDTH = 240;
	final int BUTTON_HEIGHT = 80;
	final String TEXT_FIELD_FONT = "-fx-font: 24 papyrus";
	final String LABEL_FONT = "-fx-font: 34 papyrus";
	final String BUTTON_FONT = "-fx-font: 19 papyrus";
	Scene scene2;

	public LoginPage(College college,Stage stage,Scene scene) {
		Image image = new Image("file:images/image4.png");
		BackgroundImage bgi = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
		          BackgroundSize.DEFAULT);
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(25, 25, 25, 25));
		gridpane.setHgap(30);
		gridpane.setVgap(30);
		gridpane.setBackground(new Background(bgi));
		Text alertText = new Text("Invalid ID or PASSWORD");
		alertText.setStyle(TEXT_FIELD_FONT);
		alertText.setFill(Color.RED);
		alertText.setVisible(false);

		Label passwordLabel = new Label("Password");
		passwordLabel.setStyle(LABEL_FONT);
		passwordLabel.setTextFill(Color.WHITE);
		TextField password = new TextField();
		password.setStyle(TEXT_FIELD_FONT);
		password.setPromptText("Password");

		Label userNameLabel = new Label("Id Number");
		userNameLabel.setStyle(LABEL_FONT);
		userNameLabel.setTextFill(Color.WHITE);
		TextField userName = new TextField();

		userName.setStyle(TEXT_FIELD_FONT);
		userName.setPromptText("Id Number");
		Button signIn = new Button("Sign In");
		signIn.setTextFill(Color.BLUE);
		signIn.setPrefSize(BUTTON_WIDTH+100, BUTTON_HEIGHT);
		signIn.setStyle(BUTTON_FONT);
		Button back = new Button("Back");
		back.setTextFill(Color.BLUE);
		back.setStyle(BUTTON_FONT);
		back.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		Button close = new Button("Close");
		close.setTextFill(Color.BLUE);
		close.setStyle(BUTTON_FONT);
		close.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		gridpane.add(passwordLabel, 0, 2);
		gridpane.add(password, 1, 2);
		gridpane.add(userNameLabel, 0, 1);
		gridpane.add(userName, 1, 1);
		gridpane.add(signIn, 1, 3);
		gridpane.add(close, 0, 3);
		gridpane.add(back, 2, 3);
		gridpane.add(alertText, 1, 4);
		gridpane.setAlignment(Pos.CENTER);
		scene2 = new Scene(gridpane, 1100, 800);
		back.setOnAction(event -> {
			password.clear();
			userName.clear();
			stage.setScene(scene);
		});

		close.setOnAction(event -> {
			Platform.exit();
		});
		
		

		signIn.setOnAction(event -> {
			
			String passwordField = password.getText().trim();
			String idNumber = userName.getText().trim();
			if (college.getPersonBag().findPersonIdBoolean(idNumber)
					&& college.getPersonBag().findPersonPasswordBoolean(passwordField)
					&& college.getPersonBag().findById(idNumber).getPassword() != null
					&& college.getPersonBag().findById(idNumber).getPassword().equals(passwordField)) {
				if (college.getPersonBag().findById(idNumber) instanceof Student) {
					StudentPane studentPane = new StudentPane(college,stage,scene,idNumber);
					stage.setScene(studentPane.getScene());
					userName.clear();
					password.clear();
					
				} else if (college.getPersonBag().findById(idNumber) instanceof Faculty) {
					FacultyPane facultyPane = new FacultyPane(college,stage,scene);
					stage.setScene(facultyPane.getScene());
					userName.clear();
					password.clear();
				}

			} else {
				alertText.setVisible(true);
				userName.clear();
				password.clear();
			}
		});

	}
	


	public Scene getScene() {
		return scene2;
	}
}
