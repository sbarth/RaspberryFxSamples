package de.saxsys.sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.input.TouchPoint;
import javafx.scene.shape.StrokeLineCap;

import java.net.URL;
import java.util.ResourceBundle;

public class DrawingCanvasController implements Initializable {
    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private ComboBox<StrokeLineCap> lineCapComboBox;

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        canvas.getGraphicsContext2D().setLineWidth(5);
        canvas.getGraphicsContext2D().setLineCap(StrokeLineCap.ROUND);

        lineCapComboBox.setItems(FXCollections.observableArrayList(StrokeLineCap.values()));
        lineCapComboBox.getSelectionModel().select(canvas.getGraphicsContext2D().getLineCap());
    }

    @FXML
    void drawWithMouse(final MouseEvent event) {
        drawLine(event.getX(), event.getY());
    }

    @FXML
    void drawWithTouch(final TouchEvent event) {
        final TouchPoint tp = event.getTouchPoint();
        drawLine(tp.getX(), tp.getY());
    }

    private void drawLine(double x, double y) {
        canvas.getGraphicsContext2D().strokeLine(x, y, x + 1, y + 1);
    }

    @FXML
    void onActionColorPicked() {
        canvas.getGraphicsContext2D().setStroke(colorPicker.getValue());
    }

    @FXML
    void onActionLineCapChoosed() {
        canvas.getGraphicsContext2D().setLineCap(lineCapComboBox.getSelectionModel().getSelectedItem());
    }

    @FXML
    void onActionClearAll() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    @FXML
    void onClose() {
        Platform.exit();
    }
}
