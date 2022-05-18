package com.example.login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginScreen extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        TextField textField = new TextField();
        Label error = new Label("");
        Button login = new Button("Login");
        Button register = new Button("Register");
        HBox buttons = new HBox(login, register);
        buttons.setSpacing(25);
        PasswordField passwordField = new PasswordField();
        VBox LoginBoxes = new VBox(textField, passwordField, buttons, error);
        LoginBoxes.relocate(75, 150);
        LoginBoxes.setSpacing(25);

        register.setOnAction(actionEvent -> {
            RegisterScherm registerScherm = new RegisterScherm();
            try {
                registerScherm.start(new Stage());
                stage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        login.setOnAction(actionEvent -> {
            if(AlleGebruikers.gebruikers == null){
                RegisterScherm registerScherm = new RegisterScherm();
                try {
                    registerScherm.start(new Stage());
                    stage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                for(int i = 0; i< AlleGebruikers.gebruikers.size(); i++) {
                    if (AlleGebruikers.gebruikers.get(i).getUsername().equals(textField.getText()) && AlleGebruikers.gebruikers.get(i).getPassword().equals(passwordField.getText())) {
                        MainMenu mainMenu = new MainMenu(AlleGebruikers.gebruikers.get(i));
                        try {
                            mainMenu.start(new Stage());
                            stage.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                error.setText("Username or password\n does not match!");
            }
        });

        Pane root = new Pane(LoginBoxes);
        root.setMinSize(300, 400);
        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}