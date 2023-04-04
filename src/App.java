/*
* File: App.java
* Author: Berkovics Gellért
* Copyright: 2023, Berkovics Gellért
* Group: Szoft I/1/N
* Date: 2023-04-04
* Github: https://github.com/berkovics/dolgozat2_lapterfogat.git
* Licenc: GNU GPL
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    TextField dsideField;
    TextField volumeField;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        StackPane stackPane = new StackPane();
        VBox vBox1 = new VBox();
        HBox titleHBox = new HBox();
        HBox dsideHBox = new HBox();
        HBox buttonHBox = new HBox();
        HBox volumeHBox = new HBox();
        HBox aboutHBox = new HBox();

        // Kocka térfogat számítás
        Label titleLabel = new Label("Kocka térfogat számítás");
        titleHBox.getChildren().add(titleLabel);
        titleHBox.setPadding(new Insets(10, 10, 10, 10));
        titleHBox.setAlignment(Pos.CENTER);

        // Lapátló
        Label dsideLabel = new Label("Lapátló");
        dsideField = new TextField();
        dsideHBox.getChildren().addAll(dsideLabel, dsideField);
        dsideHBox.setPadding(new Insets(10, 10, 10, 10));
        HBox.setMargin(dsideLabel, new Insets(0, 10, 0, 10));
        HBox.setMargin(dsideField, new Insets(0, 10, 0, 10));
        dsideLabel.setMinWidth(100);
        dsideLabel.setAlignment(Pos.CENTER_RIGHT);

        // calcbutton
        Button calcButton = new Button("Számít");
        buttonHBox.getChildren().add(calcButton);
        buttonHBox.setPadding(new Insets(10, 10, 10, 10));
        buttonHBox.setAlignment(Pos.CENTER);
        calcButton.setOnAction(e -> {
            startCalcButton();
        });

        // Térfogat eredmény
        Label volumeLabel = new Label("Térfogat");
        volumeField = new TextField();
        volumeHBox.getChildren().addAll(volumeLabel, volumeField);
        volumeHBox.setPadding(new Insets(10, 10, 10, 10));
        HBox.setMargin(volumeLabel, new Insets(0, 10, 0, 10));
        HBox.setMargin(volumeField, new Insets(0, 10, 0, 10));
        volumeLabel.setMinWidth(100);
        volumeLabel.setAlignment(Pos.CENTER_RIGHT);

        // Névjegy about
        Label aboutLabel = new Label("Berkovics Gellért, Szoft I/1/N, 2023-04-04");
        aboutHBox.getChildren().add(aboutLabel);
        aboutHBox.setPadding(new Insets(10, 10, 10, 10));
        aboutHBox.setAlignment(Pos.CENTER);

        vBox1.getChildren().add(titleHBox);
        vBox1.getChildren().add(dsideHBox);
        vBox1.getChildren().add(buttonHBox);
        vBox1.getChildren().add(volumeHBox);
        vBox1.getChildren().add(aboutHBox);

        Scene scene = new Scene(vBox1);
        stage.setScene(scene);
        stage.show();

    }

    private void startCalcButton() {
        String dsideStr = dsideField.getText();

        double dside = Double.parseDouble(dsideStr);
        Double volume = calcVolume(dside);

        volumeField.setText(volume.toString());
    }

    private double calcVolume(double dside) {
        double volume = Math.pow(dside, 3) / Math.sqrt(8);
        return volume;
    }
}
