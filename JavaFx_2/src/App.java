import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {
    GraphicsContext gc;
    private String shape = "";

    @Override
    public void start(final Stage primaryStage) {
        MenuItem circle = new MenuItem("Circle");
        MenuItem rect = new MenuItem("Rect");
        MenuItem triangle = new MenuItem("Oval");
        Menu menu = new Menu("Choose");

        circle.setOnAction(e -> {
            shape = "Circle";
            menu.setText(shape);
        });

        rect.setOnAction(e -> {
            shape = "Rect";
            menu.setText(shape);
        });

        triangle.setOnAction(e -> {
            shape = "Oval";
            menu.setText(shape);
        });

        menu.getItems().add(circle);
        menu.getItems().add(rect);
        menu.getItems().add(triangle);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);

        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        Scene scene = new Scene(root, 400,
                425);
        primaryStage.setTitle("SuperPaint");
        primaryStage.setScene(scene);
        primaryStage.show();

        Canvas canvas = new Canvas(400, 400);
        gc = canvas.getGraphicsContext2D();
        root.setCenter(canvas);

        canvas.setOnMouseClicked(e -> {
            switch (shape) {
                case "Circle":
                    System.out.println("Circle");
                    drawCircle(e.getX(), e.getY());
                    break;

                case "Rect":
                    System.out.println("Rect");
                    drawRect(e.getX(), e.getY());
                    break;

                case "Oval":
                    System.out.println("Oval");
                    drawOval(e.getX(), e.getY());
                    break;

                default:
                    break;
            }
        });

    };

    private void drawCircle(double x, double y) {
        gc.setFill(Color.AQUA);
        gc.fillOval(x - 20, y - 20, 40, 40);
    };

    private void drawRect(double x, double y) {
        gc.setFill(Color.RED);
        gc.fillRect(x - 20, y - 20, 40, 40);
    };

    private void drawOval(double x, double y) {
        gc.setFill(Color.BISQUE);
        gc.fillOval(x - 40, y - 20, 80, 40);
    };

    public static void main(String[] args) {
        launch(args);
    };
}