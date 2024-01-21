import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ThreadControlGUI extends Application {

    ThreadControl threadA = null;
    ThreadControl threadB = null;
    BorderPane root = new BorderPane();

    public VBox threadA() {

        VBox firstThread = new VBox();
        VBox boxForThreadInterface = new VBox();

        HBox boxForButtons = new HBox();
        Button startFirst = new Button("Start");
        Button stopFirst = new Button("Stop");
        Button pauseFirst = new Button("Pause");
        Button resumeFirst = new Button("Resume");
        Region spacer1 = new Region();
        Region spacer2 = new Region();
        Region spacer3 = new Region();
        HBox.setHgrow(spacer1, Priority.ALWAYS);
        HBox.setHgrow(spacer2, Priority.ALWAYS);
        HBox.setHgrow(spacer3, Priority.ALWAYS);
        boxForButtons.getChildren().addAll(startFirst, spacer1, stopFirst, spacer2, pauseFirst, spacer3, resumeFirst);
        boxForButtons.setPadding(new Insets(0, 20, 20, 20));

        TextField messageTextField = new TextField();
        messageTextField.setPromptText("Enter name of thread");
        TextField delayTextField = new TextField();
        delayTextField.setPromptText("Set delay in Seconds");
        Label state = new Label("Stream is missing");
        TextArea messageFromThread = new TextArea();

        boxForThreadInterface.setAlignment(Pos.CENTER);
        boxForThreadInterface.getChildren().addAll(boxForButtons, messageTextField, delayTextField, state);
        firstThread.getChildren().addAll(boxForThreadInterface, messageFromThread);

        startFirst.setOnAction(e -> {
            threadA = new ThreadControl(messageTextField.getText(), Integer.parseInt(delayTextField.getText()),
                    messageFromThread);
            if (threadA.getState() == Thread.State.NEW) {
                threadA.start();
                state.setText("Thread : " + messageTextField.getText() + " Active with " +
                        delayTextField.getText() + "s delay");
            }
        });

        stopFirst.setOnAction(e -> {
            threadA.stopThread();
            state.setText("Stream is missing");
        });

        pauseFirst.setOnAction(e -> {
            threadA.pause();
            state.setText("Thread : " + threadA.getMessage() + " Paused");
        });

        resumeFirst.setOnAction(e -> {
            threadA.resumeD();
            state.setText("Thread : " + threadA.getMessage() + " Active with " +
                    delayTextField.getText() + "s delay");
        });

        return firstThread;
    }

    public VBox threadB() {
        VBox secondThread = new VBox();
        VBox boxForThreadInterface = new VBox();

        HBox boxForButtons = new HBox();
        Button startSecond = new Button("Start");
        Button stopSecond = new Button("Stop");
        Button pauseSecond = new Button("Pause");
        Button resumeSecond = new Button("Resume");
        Region spacer1 = new Region();
        Region spacer2 = new Region();
        Region spacer3 = new Region();
        HBox.setHgrow(spacer1, Priority.ALWAYS);
        HBox.setHgrow(spacer2, Priority.ALWAYS);
        HBox.setHgrow(spacer3, Priority.ALWAYS);
        boxForButtons.getChildren().addAll(startSecond, spacer1, stopSecond, spacer2, pauseSecond, spacer3,
                resumeSecond);
        boxForButtons.setPadding(new Insets(0, 20, 20, 20));

        TextField messageTextField = new TextField();
        messageTextField.setPromptText("Enter name of thread");
        TextField delayTextField = new TextField();
        delayTextField.setPromptText("Set delay in Seconds");
        Label state = new Label("Stream is missing");
        TextArea messageFromThread = new TextArea();

        boxForThreadInterface.setAlignment(Pos.CENTER);
        boxForThreadInterface.getChildren().addAll(boxForButtons, messageTextField, delayTextField, state);
        secondThread.getChildren().addAll(boxForThreadInterface, messageFromThread);

        startSecond.setOnAction(e -> {
            threadB = new ThreadControl(messageTextField.getText(), Integer.parseInt(delayTextField.getText()),
                    messageFromThread);
            if (threadB.getState() == Thread.State.NEW) {
                threadB.start();
                state.setText(
                        "Thread : " + messageTextField.getText() + " Active with "
                                + delayTextField.getText() + "s delay");
            }
        });

        stopSecond.setOnAction(e -> {
            threadB.stopThread();
            state.setText("Stream is missing");
        });

        pauseSecond.setOnAction(e -> {
            threadB.pause();
            state.setText("Thread : " + threadB.getMessage() + " Paused");
        });

        resumeSecond.setOnAction(e -> {
            threadB.resumeD();
            ;
            state.setText("Thread : " + threadB.getMessage() + " Active with "
                    + delayTextField.getText() + "s delay");
        });

        return secondThread;
    }

    public HBox multiThread(Stage primaryStage) {
        TextField messageForThread = new TextField();
        TextField delayForThread = new TextField();
        TextArea messageFromThreads = new TextArea();
        messageForThread.setPromptText("Enter name of thread");
        delayForThread.setPromptText("Enter delay for thread");
        messageFromThreads.setPromptText("Please stop all threads before closing the program");

        HBox boxForNewThread = new HBox();
        Region spacer6 = new Region();
        Region spacer7 = new Region();
        HBox.setHgrow(spacer6, Priority.ALWAYS);
        HBox.setHgrow(spacer7, Priority.ALWAYS);

        HBox boxForRootBottom = new HBox();
        Region spacer5 = new Region();
        HBox.setHgrow(spacer5, Priority.ALWAYS);

        VBox boxOfThreads = new VBox();
        boxOfThreads.setMinSize(477, 200);
        boxOfThreads.setMaxSize(477, 200);

        Button newThread = new Button("New thread");

        boxForNewThread.getChildren().addAll(newThread, spacer6, messageForThread, spacer7, delayForThread);
        boxOfThreads.getChildren().addAll(boxForNewThread);

        newThread.setOnAction(e -> {
            ThreadControl thread = new ThreadControl(messageForThread.getText(),
                    Integer.parseInt(delayForThread.getText()), messageFromThreads);

            HBox boxForLabelThread = new HBox();
            Region spacer1 = new Region();
            Region spacer2 = new Region();
            Region spacer3 = new Region();
            Region spacer4 = new Region();
            HBox.setHgrow(spacer1, Priority.ALWAYS);
            HBox.setHgrow(spacer2, Priority.ALWAYS);
            HBox.setHgrow(spacer3, Priority.ALWAYS);
            HBox.setHgrow(spacer4, Priority.ALWAYS);

            boxForLabelThread.setPadding(new Insets(20, 0, 0, 0));

            Label threadInfo = new Label(messageForThread.getText());
            Button startThread = new Button("Start");
            Button stopThread = new Button("Stop");
            Button pauseThread = new Button("Pause");
            Button resumeThread = new Button("Resume");

            startThread.setOnAction(event -> {
                if (thread.getState() == Thread.State.NEW) {
                    thread.start();
                    threadInfo.setText(
                            "Thread : " + thread.getMessage() + " Active with "
                                    + thread.getDelay() + "s delay");
                }
            });

            stopThread.setOnAction(event -> {
                thread.stopThread();
                boxOfThreads.getChildren().remove(boxForLabelThread);
            });

            pauseThread.setOnAction(event -> {
                thread.pause();
                threadInfo.setText("Thread : " + thread.getMessage() + " Paused");
            });

            resumeThread.setOnAction(event -> {
                thread.resumeD();
                threadInfo.setText(
                        "Thread : " + thread.getMessage() + " Active with "
                                + thread.getDelay() + "s delay");
            });

            boxForLabelThread.getChildren().addAll(threadInfo, spacer1, startThread, spacer2, stopThread, spacer3,
                    pauseThread, spacer4, resumeThread);
            boxOfThreads.getChildren().add(boxForLabelThread);

        });

        boxForRootBottom.getChildren().addAll(boxOfThreads, spacer5, messageFromThreads);
        return boxForRootBottom;
    }

    public void start(Stage primaryStage) {

        HBox box = new HBox();
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        box.getChildren().addAll(threadA(), spacer, threadB());
        root.setTop(box);
        root.setBottom(multiThread(primaryStage));
        root.setPadding(new Insets(20, 20, 20, 20));
        primaryStage.setScene(new Scene(root));
        primaryStage.setWidth(1100);
        primaryStage.setHeight(600);
        primaryStage.setResizable(false);
        primaryStage.show();

        primaryStage.setOnCloseRequest(e -> {
            if (threadA != null) {
                threadA.stopThread();
            }

            if (threadB != null) {
                threadB.stopThread();
            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
