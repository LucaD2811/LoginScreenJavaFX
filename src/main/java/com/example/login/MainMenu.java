package com.example.login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu extends Application {
    Gebruiker loggedIn;
    MainMenu(Gebruiker gebruiker){
        this.loggedIn = gebruiker;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button backToStart = new Button("Logout");
        backToStart.setOnAction(actionEvent -> {
            LoginScreen loginScreen = new LoginScreen();
            try {
                loginScreen.start(new Stage());
                stage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Pane root = new Pane(backToStart);
        root.setMinSize(300, 400);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Main Menu");
        stage.show();
    }
}
