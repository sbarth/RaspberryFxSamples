package de.saxsys.sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GesturesDemoApp extends Application {
    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        Button closeButton = new Button("X");
        closeButton.setOnAction(e -> Platform.exit());
        closeButton.setFocusTraversable(false);


        Rectangle rectangle = new Rectangle(400, 200);
        rectangle.setFill(Color.CORNFLOWERBLUE);
        rectangle.setStroke(Color.CORNFLOWERBLUE.darker());
        rectangle.setStrokeWidth(20);
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);



        rectangle.setOnZoom(event -> {
            rectangle.setScaleX(rectangle.getScaleX() * event.getZoomFactor());
            rectangle.setScaleY(rectangle.getScaleY() * event.getZoomFactor());

            event.consume();
        });


        rectangle.setOnRotate(event -> {
            rectangle.setRotate(rectangle.getRotate() + event.getAngle());

            event.consume();
        });


        rectangle.setOnSwipeDown(event -> {
            final Paint fill = rectangle.getFill();

            if(fill instanceof Color) {
                rectangle.setFill(((Color) fill).darker());
            }
        });

        rectangle.setOnSwipeUp(event -> {
            final Paint fill = rectangle.getFill();

            if(fill instanceof Color) {
                rectangle.setFill(((Color) fill).brighter());
            }
        });


        final StackPane parent = new StackPane(rectangle, closeButton);
        StackPane.setAlignment(closeButton, Pos.TOP_RIGHT);

        final Scene scene = new Scene(parent, 800, 640);
        scene.setOnKeyPressed(event -> {
            if(event.isControlDown() && KeyCode.C.equals(event.getCode())) {
                Platform.exit();
            }
        });

        scene.setCursor(Cursor.NONE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
