import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private Database database = new Database();

    public void init(Stage primaryStage) {
        database.createTables();
        BorderPane root = new BorderPane();

        Button showStud = new Button("Show students");
        Region spacer = new Region();
        Button showLecturer = new Button("Show lecturer");
        Region spacer1 = new Region();
        Button showSubject = new Button("Show subject");
        Region spacer2 = new Region();
        Button showSubjLect = new Button("Show SubjectLect");
        Region spacer3 = new Region();
        Button showUniversity = new Button("Show University");
        Region spacer4 = new Region();
        Button showExamMarks = new Button("Show ExamMarks");


        showStud.setOnAction(e -> {
            root.setCenter(getTableViewStud());
        });

        showLecturer.setOnAction(e -> {
            Stage tempStage = new Stage();
            VBox box = new VBox(getTableViewLect());
            Scene scene = new Scene(box);
            tempStage.setScene(scene);
            tempStage.show();
        });

        showSubject.setOnAction(e -> {
            root.setCenter(getTableViewSubj());
        });

        showSubjLect.setOnAction(e -> {
            Stage tempStage = new Stage();
            VBox box = new VBox(getTableViewSubjLect());
            Scene scene = new Scene(box);
            tempStage.setScene(scene);
            tempStage.show();
        });

        showUniversity.setOnAction(e -> {
            root.setCenter(getTableViewUniversity());
        });

        showExamMarks.setOnAction(e -> {
            Stage tempStage = new Stage();
            VBox box = new VBox(getTableViewExamMarks());
            Scene scene = new Scene(box);
            tempStage.setScene(scene);
            tempStage.show();
        });

        HBox buttonBox = new HBox();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        HBox.setHgrow(spacer1, Priority.ALWAYS);
        HBox.setHgrow(spacer2, Priority.ALWAYS);
        HBox.setHgrow(spacer3, Priority.ALWAYS);
        HBox.setHgrow(spacer4, Priority.ALWAYS);
        buttonBox.getChildren().addAll(showStud, spacer, showLecturer, spacer1, showSubject, spacer2,
                showSubjLect, spacer3, showUniversity, spacer4, showExamMarks);
        root.setTop(buttonBox);

        primaryStage.setScene(new Scene(root));
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
    };

    public TableView<Student> getTableViewStud() {
        TableView<Student> studentsTable = new TableView<>();
        TableColumn<Student, String> surnameCol = new TableColumn<>("Surname");
        TableColumn<Student, String> nameCol = new TableColumn<>("Name");
        TableColumn<Student, Integer> stipendCol = new TableColumn<>("Stipend");
        TableColumn<Student, Integer> kursCol = new TableColumn<>("Kurs");
        TableColumn<Student, String> cityCol = new TableColumn<>("City");
        TableColumn<Student, String> birthdayCol = new TableColumn<>("Birthday");
        TableColumn<Student, Integer> univer = new TableColumn<>("UniverId");

        surnameCol.setCellValueFactory(new PropertyValueFactory<Student, String>("surname"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        stipendCol.setCellValueFactory(new PropertyValueFactory<Student, Integer>("stipend"));
        kursCol.setCellValueFactory(new PropertyValueFactory<Student, Integer>("kurs"));
        cityCol.setCellValueFactory(new PropertyValueFactory<Student, String>("city"));
        birthdayCol.setCellValueFactory(new PropertyValueFactory<Student, String>("birthday"));
        univer.setCellValueFactory(new PropertyValueFactory<Student, Integer>("univer"));
        studentsTable.getColumns().addAll(surnameCol, nameCol, stipendCol, kursCol, cityCol, birthdayCol, univer);
        studentsTable.setItems(database.getTableStudent());

        studentsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        double columnWidth = 100.0 / studentsTable.getColumns().size();
        studentsTable.getColumns().forEach(column -> column.setPrefWidth(columnWidth));

        return studentsTable;
    };

    public TableView<Lecturer> getTableViewLect() {
        TableView<Lecturer> lecturerTable = new TableView<>();
        TableColumn<Lecturer, Integer> lecturer_idCol = new TableColumn<>("Lecturer_ID");
        TableColumn<Lecturer, String> surnameCol = new TableColumn<>("Surname");
        TableColumn<Lecturer, String> nameCol = new TableColumn<>("Name");
        TableColumn<Lecturer, String> cityCol = new TableColumn<>("City");
        TableColumn<Lecturer, Integer> univer = new TableColumn<>("UniverId");

        lecturer_idCol.setCellValueFactory(new PropertyValueFactory<Lecturer, Integer>("lecturerId"));
        surnameCol.setCellValueFactory(new PropertyValueFactory<Lecturer, String>("surname"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Lecturer, String>("name"));
        cityCol.setCellValueFactory(new PropertyValueFactory<Lecturer, String>("city"));
        univer.setCellValueFactory(new PropertyValueFactory<Lecturer, Integer>("univer"));
        lecturerTable.getColumns().addAll(lecturer_idCol, surnameCol, nameCol, cityCol, univer);
        lecturerTable.setItems(database.getTableLecturer());

        lecturerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        double columnWidth = 100.0 / lecturerTable.getColumns().size();
        lecturerTable.getColumns().forEach(column -> column.setPrefWidth(columnWidth));

        return lecturerTable;
    };

    public TableView<Subject> getTableViewSubj() {
        TableView<Subject> subjectTable = new TableView<>();
        TableColumn<Subject, Integer> subjIdColumn = new TableColumn<>("Subj_Id");
        TableColumn<Subject, String> subjNameColumn = new TableColumn<>("Subj_Name");
        TableColumn<Subject, Integer> subjHoursColumn = new TableColumn<>("Hours");
        TableColumn<Subject, Integer> semesterColumn = new TableColumn<>("Semester");

        subjIdColumn.setCellValueFactory(new PropertyValueFactory<Subject, Integer>("subjId"));
        subjNameColumn.setCellValueFactory(new PropertyValueFactory<Subject, String>("subjName"));
        subjHoursColumn.setCellValueFactory(new PropertyValueFactory<Subject, Integer>("hours"));
        semesterColumn.setCellValueFactory(new PropertyValueFactory<Subject, Integer>("semester"));
        subjectTable.getColumns().addAll(subjIdColumn, subjNameColumn, subjHoursColumn, semesterColumn);
        subjectTable.setItems(database.getTableSubject());

        subjectTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        double columnWidth = 100.0 / subjectTable.getColumns().size();
        subjectTable.getColumns().forEach(column -> column.setPrefWidth(columnWidth));

        return subjectTable;
    }

    public TableView<Subj_lect> getTableViewSubjLect() {
        TableView<Subj_lect> subj_lectTable = new TableView<>();
        TableColumn<Subj_lect, Integer> lecturerIdColumn = new TableColumn<>("Lecturer_Id");
        TableColumn<Subj_lect, Integer> subjIdColumn = new TableColumn<>("Subj_Id");

        lecturerIdColumn.setCellValueFactory(new PropertyValueFactory<Subj_lect, Integer>("lecturerId"));
        subjIdColumn.setCellValueFactory(new PropertyValueFactory<Subj_lect, Integer>("subjId"));

        subj_lectTable.getColumns().addAll(lecturerIdColumn, subjIdColumn);
        subj_lectTable.setItems(database.getTableSubj_lects());

        subj_lectTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        double columnWidth = 100.0 / subj_lectTable.getColumns().size();
        subj_lectTable.getColumns().forEach(column -> column.setPrefWidth(columnWidth));

        return subj_lectTable;
    }

    public TableView<University> getTableViewUniversity() {
        TableView<University> universityTableView = new TableView<>();
        TableColumn<University, Integer> univerCol = new TableColumn<>("Univer");
        TableColumn<University, String> univerNameCol = new TableColumn<>("Univer Name");
        TableColumn<University, Integer> ratingColumn = new TableColumn<>("Rating");
        TableColumn<University, String> cityColumn = new TableColumn<>("City");

        univerCol.setCellValueFactory(new PropertyValueFactory<University, Integer>("univer"));
        univerNameCol.setCellValueFactory(new PropertyValueFactory<University, String>("univerName"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<University, Integer>("rating"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<University, String>("city"));

        universityTableView.getColumns().addAll(univerCol, univerNameCol, ratingColumn, cityColumn);
        universityTableView.setItems(database.getTableUniversities());

        universityTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        double columnWidth = 100.0 / universityTableView.getColumns().size();
        universityTableView.getColumns().forEach(column -> column.setPrefWidth(columnWidth));

        return universityTableView;
    }

    public TableView<Exam_marks> getTableViewExamMarks() {
        TableView<Exam_marks> examMarksTable = new TableView<>();
        TableColumn<Exam_marks, Integer> examIdColumn = new TableColumn<>("Exam_Id");
        TableColumn<Exam_marks, Integer> studentIdCol = new TableColumn<>("Student_Id");
        TableColumn<Exam_marks, Integer> subjIdCol = new TableColumn<>("Subj_Id");
        TableColumn<Exam_marks, Integer> markCol = new TableColumn<>("Mark");
        TableColumn<Exam_marks, String> examDateCol = new TableColumn<>("Exam_Date");

        examIdColumn.setCellValueFactory(new PropertyValueFactory<Exam_marks, Integer>("examId"));
        studentIdCol.setCellValueFactory(new PropertyValueFactory<Exam_marks, Integer>("studentId"));
        subjIdCol.setCellValueFactory(new PropertyValueFactory<Exam_marks, Integer>("subjId"));
        markCol.setCellValueFactory(new PropertyValueFactory<Exam_marks, Integer>("mark"));
        examDateCol.setCellValueFactory(new PropertyValueFactory<Exam_marks, String>("examDate"));

        examMarksTable.getColumns().addAll(examIdColumn, studentIdCol, subjIdCol, markCol, examDateCol);
        examMarksTable.setItems(database.getTableExamMarks());

        examMarksTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        double columnWidth = 100.0 / examMarksTable.getColumns().size();
        examMarksTable.getColumns().forEach(column -> column.setPrefWidth(columnWidth));

        return examMarksTable;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    };

    public static void main(String[] args) {
        launch(args);
    };
}
