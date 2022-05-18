package com.example.login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterScherm extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        TextField username = new TextField();
        TextField naam = new TextField();
        PasswordField password = new PasswordField();
        Button confirm = new Button("Confirm");
        Button login = new Button("Back to Login");

        username.setPromptText("Username");
        username.setFocusTraversable(false);
        naam.setPromptText("Full name");
        naam.setFocusTraversable(false);
        password.setPromptText("Password");
        password.setFocusTraversable(false);


        HBox buttons = new HBox(confirm, login);
        buttons.setSpacing(25);
        VBox fields = new VBox(username, naam, password, buttons);
        fields.relocate(75, 150);
        fields.setSpacing(25);

        login.setOnAction(actionEvent -> {
            LoginScreen main = new LoginScreen();
            try {
                main.start(new Stage());
                stage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        confirm.setOnAction(actionEvent -> {
            AlleGebruikers.gebruikers.add(new Gebruiker(naam.getText(), username.getText(), password.getText()));
            LoginScreen loginScreen = new LoginScreen();
            try {
                loginScreen.start(new Stage());
                stage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        Pane root = new Pane(fields);
        root.setMinSize(300, 400);
        Scene scene = new Scene(root);
        stage.setTitle("Register");
        stage.setScene(scene);
        stage.show();
    }
}
