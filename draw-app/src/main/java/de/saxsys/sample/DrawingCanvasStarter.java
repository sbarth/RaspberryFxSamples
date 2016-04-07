package de.saxsys.sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.net.URL;

public class DrawingCanvasStarter extends Application {
    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        URL fxmlLocation = this.getClass().getResource("drawingCanvas.fxml");



        fxmlLoader.setLocation(fxmlLocation);
        final Parent root = fxmlLoader.load();

        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();

        final Scene scene = new Scene(root, visualBounds.getWidth(), visualBounds.getHeight());
        stage.setScene(scene);
        stage.show();
    }
}
