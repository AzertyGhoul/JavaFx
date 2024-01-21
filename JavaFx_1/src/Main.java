import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root, 600, 600); // создаем сцену
		primaryStage.setResizable(false);
		primaryStage.setTitle("Hello World"); // создаем окно с заголовком
		primaryStage.setScene(scene); // вставляем в окно сцену
		primaryStage.show(); // показываем окно
	}

	public static void main(String[] args) {
		launch(args);
	}
}
