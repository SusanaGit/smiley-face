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

        // create and configure the circle for the right eye
        Circle rightEye = new Circle(86, 100, 10);
        rightEye.setFill(Color.YELLOW);
        rightEye.setStroke(Color.BLUE);

        // create a group that holds all the features
        Group root = new Group(face, rightEye);

        // create and configure a new scene
        Scene scene = new Scene(root, 250, 275, Color.YELLOW);

        // add the scene to the stage
        primaryStage.setScene(scene);

        // show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
