import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class App extends Application {
    private BarChart<String, Number> bc; // объект-диаграмма
    private ArrayList<String> dataSeries = new ArrayList<>();
    private TextField textFieldForCategory = new TextField();
    private TextField textFieldForData = new TextField();
    private TextField textFieldForName = new TextField();

    public void init(Stage primaryStage) {
        BorderPane root = new BorderPane();
        primaryStage.setScene(new Scene(root));
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        textFieldForName.setPromptText("Enter name");
        textFieldForData.setPromptText("Enter data");
        textFieldForCategory.setPromptText("Enter category");

        bc = new BarChart<String, Number>(xAxis, yAxis);
        bc.setTitle("Lab 3");
        xAxis.setLabel("Category");
        yAxis.setLabel("Data");

        for (int i = 1; i <= 3; i++) {
            XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
            series.setName(Integer.toString(i));
            dataSeries.add(Integer.toString(i));
            series.getData()
                    .add(new XYChart.Data<String, Number>(Integer.toString(i), Math.round(Math.random() * 20) + 5));
            bc.getData().add(series);
        }

        Button Something = new Button("Add or Change");
        Something.setOnAction(e -> {
            if (!(textFieldForName.getText().equals("") || textFieldForData.getText().equals("")
                    || textFieldForCategory.getText().equals(""))) {

                try {
                    bc.getData()
                            .get(dataSeries.indexOf(textFieldForName.getText().trim()));
                    XYChart.Series<String, Number> series = bc.getData()
                            .get(dataSeries.indexOf(textFieldForName.getText().trim()));
                    series.getData()
                            .add(new XYChart.Data<String, Number>(textFieldForCategory.getText().trim(),
                                    Integer.parseInt(textFieldForData.getText())));
                    System.out.println(bc.getData());
                } catch (Exception err) {
                    XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
                    dataSeries.add(textFieldForName.getText().trim());
                    series.setName(textFieldForName.getText().trim());
                    series.getData()
                            .add(new XYChart.Data<String, Number>(textFieldForCategory.getText(),
                                    Integer.parseInt(textFieldForData.getText())));
                    bc.getData().add(series);
                }
            }
        });

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        Region spacer2 = new Region();
        HBox.setHgrow(spacer2, Priority.ALWAYS);
        Region spacer3 = new Region();
        HBox.setHgrow(spacer3, Priority.ALWAYS);

        HBox hBoxChange = new HBox();
        hBoxChange.setPadding(new Insets(20, 20, 20, 20));
        hBoxChange.getChildren().addAll(Something, spacer, textFieldForName, spacer2, textFieldForCategory, spacer3,
                textFieldForData);

        root.setBottom(hBoxChange);
        root.setCenter(bc);
    };

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}