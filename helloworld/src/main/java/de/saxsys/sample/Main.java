package de.saxsys.sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final Label helloWorldLabel = new Label("Hello World!");

        Button closeButton = new Button("X");
        closeButton.setOnAction(e -> Platform.exit());



        final StackPane parent = new StackPane(helloWorldLabel, closeButton);

        StackPane.setAlignment(closeButton, Pos.TOP_RIGHT);


        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();

        final Scene scene = new Scene(parent, visualBounds.getWidth(), visualBounds.getHeight());

        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
