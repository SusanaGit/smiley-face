package com.susanafigueroa;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class SmileyFace extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // create and configure the main circle for the face
        Circle face = new Circle(125, 125, 80);
        face.setFill(Color.YELLOW);
        face.setStroke(Color.RED);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
