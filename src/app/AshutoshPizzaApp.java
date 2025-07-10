package app;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.PizzaOrderingScene;

public class AshutoshPizzaApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        PizzaOrderingScene sceneBuilder = new PizzaOrderingScene();
        primaryStage.setScene(sceneBuilder.createScene());
        primaryStage.setTitle("Ashutosh's Pizza Palace");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
