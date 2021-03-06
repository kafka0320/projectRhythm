package tester;

import gameController.GameLoopController;
import javafx.application.Application;
import javafx.stage.Stage;

public class GameLoopTester extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage theStage) {
		theStage.setTitle("gameLoop Example");

		GameLoopController controller = new GameLoopController("SuspensefulThirdDay");
		theStage.setScene(controller.getScene());

		controller.start();

		theStage.show();
	}
}