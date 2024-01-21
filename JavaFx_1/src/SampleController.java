import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SampleController implements Initializable {

    @FXML // обязательное указание
    private Button button1;

    @FXML
    private TextArea textArea;

    @FXML
    private TextField textField;

    @FXML
    private ListView<String> List;

    String[] items = { "Java", "Java", "Java", "Java", "Java" };

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        List.getItems().addAll(items);
    }

    @FXML
    private void handleMouseEnter(MouseEvent event) {
        textField.setText(event.getSource().toString());
    }

    @FXML
    private void handleButtonOnPress(ActionEvent event) {
        System.out.println("Hello");
    }

    @FXML
    private void handle(MouseEvent event) {
        textArea.appendText("Hello!!");
    }

    @FXML
    private void handleRadioButton(ActionEvent event) {
        RadioButton selRadio = (RadioButton) event.getSource();
        System.out.println(selRadio);

        selRadio.getScene().getStylesheets().clear();
        selRadio.getScene().getRoot().getStylesheets().clear();

        switch (selRadio.getText()) {
            case "Style1":
                selRadio.getScene().getStylesheets().add(getClass().getResource("Style1.css").toExternalForm());
                break;

            case "Style2":
                selRadio.getScene().getStylesheets().add(getClass().getResource("Style2.css").toExternalForm());
                break;

            case "Style3":
                selRadio.getScene().getStylesheets().add(getClass().getResource("Style3.css").toExternalForm());
                break;

            case "Style4":
                selRadio.getScene().getStylesheets().add(getClass().getResource("Style4.css").toExternalForm());
                break;
        }
    }
};