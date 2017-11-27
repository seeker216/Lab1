package boundary;
	
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		primaryStage.setTitle("实验1");
		Pane myPane = (Pane)FXMLLoader.load(getClass().getResource("index.fxml"));
        Scene myScene = new Scene(myPane);
        primaryStage.setScene(myScene);
        primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
