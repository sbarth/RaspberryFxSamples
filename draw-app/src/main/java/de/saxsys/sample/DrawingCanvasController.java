package de.saxsys.sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
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
    private Canvas drawingCanvas;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private ComboBox<StrokeLineCap> lineCapComboBox;

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        drawingCanvas.getGraphicsContext2D().setLineWidth(5);
        drawingCanvas.getGraphicsContext2D().setLineCap(StrokeLineCap.ROUND);

        lineCapComboBox.setItems(FXCollections.observableArrayList(StrokeLineCap.values()));
        lineCapComboBox.getSelectionModel().select(drawingCanvas.getGraphicsContext2D().getLineCap());
    }

    @FXML
    void onMouseMoved(final MouseEvent event) {
        drawingCanvas.getGraphicsContext2D().strokeLine(event.getX(), event.getY(), event.getX() + 1, event.getY() + 1);
    }

    @FXML
    void onTouchMoved(final TouchEvent event) {
        final TouchPoint tp = event.getTouchPoint();
        drawingCanvas.getGraphicsContext2D().strokeLine(tp.getX(), tp.getY(), tp.getX() + 1, tp.getY() + 1);
    }

    @FXML
    void onActionColorPicked() {
        drawingCanvas.getGraphicsContext2D().setStroke(colorPicker.getValue());
    }

    @FXML
    void onActionLineCapChoosed() {
        drawingCanvas.getGraphicsContext2D().setLineCap(lineCapComboBox.getSelectionModel().getSelectedItem());
    }

    @FXML
    void onActionClearAll() {
        drawingCanvas.getGraphicsContext2D().clearRect(0, 0, drawingCanvas.getWidth(), drawingCanvas.getHeight());
    }

    @FXML
    void onClose() {
        Platform.exit();
    }
}
