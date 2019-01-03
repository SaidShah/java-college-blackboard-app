package view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import javafx.stage.Stage;
import model.*;

public class App extends Application {
	Button loginBttn;
	Button cancelButton;
	Button createAccountButton;
	final int BUTTON_WIDTH = 240;
	final int BUTTON_HEIGHT = 80;
	final String TEXT_FIELD_FONT = "-fx-font: 24 papyrus";
	final String LABEL_FONT = "-fx-font: 34 papyrus";
	final String BUTTON_FONT = "-fx-font: 19 papyrus";
	College college = new College();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Image image = new Image("file:images/image4.png");
		BackgroundImage bgi = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
		          BackgroundSize.DEFAULT);
		Text text = new Text("Welcome");
		text.setStyle("-fx-font: 80 papyrus");
		text.setFill(Color.RED);
		primaryStage.setTitle("School of Computer Science");
		loginBttn = new Button("Log In");
		loginBttn.setStyle(BUTTON_FONT);
		loginBttn.setTextFill(Color.BLUE);
		loginBttn.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		cancelButton = new Button("Close");
		cancelButton.setStyle(BUTTON_FONT);
		cancelButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		cancelButton.setTextFill(Color.RED);
		createAccountButton = new Button("Create LogIn");
		createAccountButton.setStyle(BUTTON_FONT);
		createAccountButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		createAccountButton.setTextFill(Color.BLUE);

		VBox welcomeTitle = new VBox(30);
		welcomeTitle.getChildren().add(text);
		welcomeTitle.setAlignment(Pos.CENTER);
		HBox loginButtons = new HBox(30);
		loginButtons.setAlignment(Pos.CENTER);
		loginButtons.getChildren().addAll(loginBttn, createAccountButton);
		HBox cancelBttn = new HBox(75);
		cancelBttn.setAlignment(Pos.CENTER);
		cancelBttn.getChildren().add(cancelButton);
		cancelBttn.setPadding(new Insets(20));
		VBox firstPage = new VBox(welcomeTitle, loginButtons, cancelBttn);
		
		firstPage.setAlignment(Pos.CENTER);
		firstPage.setPadding(new Insets(20));
		firstPage.setBackground(new Background(bgi));
		Scene scene1 = new Scene(firstPage, 1100, 800);
		primaryStage.setScene(scene1);
		primaryStage.show();

		LoginPage loginPage = new LoginPage(college, primaryStage,scene1);
		CreateAccount createAccount = new CreateAccount(college, loginBttn,scene1,primaryStage);
		loginBttn.setOnAction(event -> {
			primaryStage.setScene(loginPage.getScene());
		});

		cancelButton.setOnAction(event -> {
			Platform.exit();
		});


		createAccountButton.setOnAction(event -> {
			primaryStage.setScene(createAccount.getScene());
		});


	}

}
