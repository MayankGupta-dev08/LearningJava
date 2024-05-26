package dev.mayankg.design.patterns.behavioural.mediator.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

class Client extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        UIMediator mediator = new UIMediator();
        Slider slider = new Slider(mediator);
        TextBox box = new TextBox(mediator);
        Label label = new Label(mediator);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(20);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(label, 0, 0);
        grid.add(slider, 0, 1);
        grid.add(box, 0, 2);
        Scene scene = new Scene(grid, 500, 500);
        primaryStage.setTitle("Mediator Pattern");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}