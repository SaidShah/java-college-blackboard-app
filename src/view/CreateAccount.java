package view;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
import model.*;

public class CreateAccount {
	final int BUTTON_WIDTH = 240;
	final int BUTTON_HEIGHT = 80;
	final String TEXT_FIELD_FONT = "-fx-font: 24 papyrus";
	final String LABEL_FONT = "-fx-font: 34 papyrus";
	final String BUTTON_FONT = "-fx-font: 19 papyrus";
	Scene scene3;

	public CreateAccount(College college,Button loginButton,Scene scene,Stage stage) {
		Image image = new Image("file:images/image4.png");
		BackgroundImage bgi = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
		          BackgroundSize.DEFAULT);
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(25, 25, 25, 25));
		gridpane.setHgap(20);
		gridpane.setVgap(30);
		gridpane.setBackground(new Background(bgi));
		Text warningText = new Text();
		warningText.setFill(Color.WHITE);
		warningText.setStyle(TEXT_FIELD_FONT);


		Label idLabel = new Label("Id Number");
		idLabel.setStyle(LABEL_FONT);
		idLabel.setTextFill(Color.WHITE);
		TextField getIdNumber = new TextField();
		getIdNumber.setStyle(TEXT_FIELD_FONT);
		getIdNumber.setPromptText("Id Number");

		Label phoneNumberLabel = new Label("Phone Number");
		phoneNumberLabel.setStyle(LABEL_FONT);
		phoneNumberLabel.setTextFill(Color.WHITE);
		TextField getPhoneNumber = new TextField();
		getPhoneNumber.setStyle(TEXT_FIELD_FONT);
		getPhoneNumber.setPromptText("Phone Number");

		Label passwordLabel = new Label("New Password");
		passwordLabel.setStyle(LABEL_FONT);
		passwordLabel.setTextFill(Color.WHITE);
		TextField getPassword = new TextField();
		getPassword.setStyle(TEXT_FIELD_FONT);
		getPassword.setPromptText("Password");

		Label confirmPasswordLabel = new Label("Confirm Password");
		confirmPasswordLabel.setStyle(LABEL_FONT);
		confirmPasswordLabel.setTextFill(Color.WHITE);
		TextField getConfirmedPassword = new TextField();
		getConfirmedPassword.setStyle(TEXT_FIELD_FONT);
		getConfirmedPassword.setPromptText("Confirm Password");

		Button createAccount = new Button("Create");
		createAccount.setTextFill(Color.BLUE);
		createAccount.setStyle(BUTTON_FONT);
		createAccount.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		Button backButton = new Button("Back");
		backButton.setTextFill(Color.BLUE);
		backButton.setStyle(BUTTON_FONT);
		backButton.setPrefSize(BUTTON_WIDTH+70, BUTTON_HEIGHT);
		Button close = new Button("Close");
		close.setTextFill(Color.BLUE);
		close.setStyle(BUTTON_FONT);
		close.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		gridpane.addColumn(0, idLabel, phoneNumberLabel, passwordLabel, confirmPasswordLabel);
		gridpane.addColumn(1, getIdNumber, getPhoneNumber, getPassword, getConfirmedPassword);
		gridpane.addRow(5, createAccount,backButton, close);
		gridpane.addRow(6, warningText);
		gridpane.setAlignment(Pos.CENTER);
		
		scene3 = new Scene(gridpane, 1000, 800);
		close.setOnAction(event -> {
			Platform.exit();
		});

		backButton.setOnAction(event->{
			stage.setScene(scene);
		});

		createAccount.setOnAction(event -> {

			String idNumber = getIdNumber.getText().trim();
			String phoneNumber = getPhoneNumber.getText().trim().replaceAll("[^0-9]", "");
			String password = getPassword.getText().trim();
			String confirmedPassword = getConfirmedPassword.getText().trim();
			Person p;

			if (idNumber.isEmpty() || phoneNumber.isEmpty() || password.isEmpty() || confirmedPassword.isEmpty()) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("All fields must be filled out");
				alert.showAndWait();
			} else if ((p = college.getPersonBag().findById(idNumber)) != null) {
				String currentPhoneNumber = p.getPhone().replaceAll("[^0-9]", "");
				if (college.getPersonBag().findPersonIdBoolean(idNumber) && phoneNumber.equals(currentPhoneNumber)) {
					if (password.equals(confirmedPassword)) {
						college.getPersonBag().findById(idNumber).setPassword(confirmedPassword);
						college.save();
						loginButton.fire();

					} else {
						warningText.setText("Passwords do not match");
						warningText.setVisible(true);

					}
				} else {
					warningText.setText("Your are not Registered");
					warningText.setVisible(true);

				}
			}
		});

	}

	public Scene getScene() {
		return scene3;
	}
}
