package com.susanafigueroa;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Pos;

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

        // create and configure the circle for the left eye
        Circle leftEye = new Circle(162, 100, 10);
        leftEye.setFill(Color.YELLOW);
        leftEye.setStroke(Color.BLUE);

        // create and configure the text
        Text caption = new Text(110, 240, "");
        caption.setFill(Color.BLUE);
        caption.setFont(Font.font("Verdana", 15));

        // create default mouth
        final Shape mouth = new Arc(125, 150, 45, 35, 0, 0) ;
        ((Arc) mouth).setType(ArcType.OPEN);

        // create a group that holds all the features
        Group group = new Group(face, rightEye, leftEye, mouth, caption);

        // create a button that will make the face smile
        Button smileButton = new Button("Smile");

        // create a button that will make the face frown
        Button frownButton = new Button("Frown");

        // create a button that will make the monotonous emotion
        Button mehButton = new Button("Meh");

        // create and configure a horizontal container to hold the buttons
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);

        // add the buttons to the horizontal container
        buttonBox.getChildren().addAll(smileButton, frownButton, mehButton);

        // create and configure a vertical container to hold the button box and the face group
        VBox root = new VBox(10);
        root.setBackground(Background.EMPTY);
        root.setAlignment(Pos.CENTER);

        // add the button box and the face group to the vertical container
        root.getChildren().addAll(buttonBox, group);

        // create and configure a new scene
        Scene scene = new Scene(root, 250, 275, Color.YELLOW);

        // supply the code that is executed when the smile button is pressed
        smileButton.setOnAction( e -> {
            Shape newMouth = obtainMouth(smileButton);
            group.getChildren().remove(3);
            group.getChildren().add(3, newMouth);
            caption.setText("jijiji");
        });

        // supply the code that is executed when the frown button is pressed
        frownButton.setOnAction( e -> {
            Shape newMouth = obtainMouth(frownButton);
            group.getChildren().remove(3);
            group.getChildren().add(3, newMouth);
            caption.setText("sniiif");
        });

        // supply the code that is executed when the monotonous button is pressed
        mehButton.setOnAction( e -> {
            Shape newMouth = obtainMouth(mehButton);
            group.getChildren().remove(3);
            group.getChildren().add(3, newMouth);
            caption.setText("------");
        });

        // add the scene to the stage
        primaryStage.setScene(scene);

        // title
        primaryStage.setTitle("Emotions");

        // show the stage
        primaryStage.show();
    }

    public Shape obtainMouth(Button button) {

        Shape mouth = null;

        if (button.getText().equals("Smile")) {
            // create and configure a smiling mouth
            mouth = new Arc(125, 150, 45, 35, 0, -180);
            ((Arc) mouth).setType(ArcType.OPEN);
        } else if (button.getText().equals("Frown")) {
            mouth = new Arc(125, 150, 45, 35, 0, 180);
            ((Arc) mouth).setType(ArcType.OPEN);
        } else if (button.getText().equals("Meh")) {
            mouth = new Line(100, 150, 150, 150);
        }

        if (mouth != null) {
            mouth.setFill(Color.YELLOW);
            mouth.setStroke(Color.BLUE);
        }

        return mouth;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
