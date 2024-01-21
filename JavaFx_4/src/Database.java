import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {

    private Connection conn = null;
    private Statement stmt = null;

    public Database() {
        try {
            Class.forName("org.h2.Driver");
            try {
                conn = DriverManager.getConnection("jdbc:h2:" + "D:/Lab/JavaFx_4/src" + "/myDb", "sa", "");
                stmt = conn.createStatement();

            } catch (SQLException er) {
                System.out.println("Trouble with connection");
            }
        } catch (Exception e) {
        }
    }

    public void createTables() {
        try {
            // Student table
            stmt.executeUpdate("CREATE TABLE Student ( student_id Integer PRIMARY KEY ,"
                    + "surname Text NOT NULL," + "name Text NOT NULL," +
                    "stipend Integer," + "kurs Integer," + "city Text," +
                    "birthday Text," + "univer Integer)");
            // Student table data
            String queryStud = "INSERT INTO Student(student_id, surname, name, stipend, kurs, city, birthday, univer) VALUES"
                    +
                    "(1, 'Иванов', 'Иван', 150, 1, 'Орел', '3/12/1982', 10)," +
                    "(3, 'Петров', 'Петр', 200, 3, 'Курск', '1/12/1980', 10)," +
                    "(6, 'Сидоров', 'Вадим', 150, 4, 'Москва', '7/06/1979', 22)," +
                    "(10, 'Кузнецов', 'Борис', 0, 2, 'Брянск', '8/12/1981', 10)," +
                    "(12, 'Зайцева', 'Ольга', 250, 2, 'Липецк', '1/05/1981', 10)," +
                    "(32, 'Котов', 'Павел', 150, 5, 'Белгород', '', 14)";
            stmt.executeUpdate(queryStud);

            // Letcurer table
            stmt.executeUpdate("CREATE TABLE Lecturer" +
                    "(lecturer_id Integer Primary Key AUTO_INCREMENT NOT NULL ," +
                    "surname Text ," +
                    "name Text ," +
                    "city Text ," +
                    "univer Integer )");
            // Lecturer table data
            String queryLec = "INSERT INTO Lecturer(lecturer_id, surname,name,city, univer) VALUES" +
                    "(24, 'Колесников', 'Борис', 'Воронеж', 10)," +
                    "(48, 'Никонов', 'Иван', 'Воронеж', 10)," +
                    "(74, 'Лагутин', 'Павел', 'Москва', 22)," +
                    "(108, 'Струков', 'Николай', 'Москва', 22)," +
                    "(276, 'Николаев', 'Виктор', 'Воронеж', 10)";
            stmt.executeUpdate(queryLec);

            // Subject table
            stmt.executeUpdate("CREATE TABLE Subject" +
                    "(subj_id Integer Primary Key NOT NULL ," +
                    "subj_name Text ," +
                    "hours Integer ," +
                    "semester Integer )");
            // Subject table data
            String querySubj = "INSERT INTO Subject(subj_id, subj_name, hours, semester) VALUES" +
                    "(10, 'Информатика', 56, 1)," +
                    "(22, 'Физика', 34, 1)," +
                    "(43, 'Математика', 56, 2)," +
                    "(46, 'История', 34, 4)," +
                    "(73, 'Физкультура', 34, 5)";
            stmt.executeUpdate(querySubj);

            // University table
            stmt.executeUpdate("CREATE TABLE University " +
                    "(univ_id Integer Primary Key NOT NULL ," +
                    "univ_name Text ," +
                    "rating Integer ," +
                    "city Text )");
            // University table data
            String queryUniv = "INSERT INTO University(univ_id, univ_name, rating, city) VALUES" +
                    "(10, 'ВГУ', 296, 'Воронеж')," +
                    "(11, 'НГУ', 345, 'Новосибирск')," +
                    "(14, 'БГУ', 326, 'Белгород')," +
                    "(15, 'ТГУ', 368, 'Томск')," +
                    "(18, 'ВГМА', 327, 'Воронеж')," +
                    "(22, 'МГУ', 606, 'Москва')";
            stmt.executeUpdate(queryUniv);

            // Exam_marks table
            stmt.executeUpdate("CREATE TABLE Exam_marks" +
                    "( exam_id Integer Primary Key NOT NULL ," +
                    "student_id Integer ," +
                    "subj_id Integer ," +
                    "mark Integer ," +
                    "exam_date Text )");
            // Exam_marks table data
            String queryExam = "INSERT INTO Exam_marks(exam_id, student_id, subj_id, mark, exam_date) VALUES" +
                    "(34, 32, 10, 4, '23/01/2000')," +
                    "(43, 6, 22, 4, '18/01/2000')," +
                    "(75, 55, 10, 5, '05/01/2000')," +
                    "(145, 12, 10, 5, '12/01/2000')," +
                    "(238, 12, 73, 3, '17/06/1999')," +
                    "(639, 55, 22, 2, '22/06/1999')";
            stmt.executeUpdate(queryExam);

            // Subj_lect table
            stmt.executeUpdate("CREATE TABLE Subj_lect" +
                    "(lecturer_id Integer ," +
                    "subj_id Integer )");
            // Subj_lect table data
            String querySubj_lect = "INSERT INTO Subj_lect(lecturer_id, subj_id) VALUES" +
                    "(24, 22)," +
                    "(48, 46)," +
                    "(74, 73)";
            stmt.executeUpdate(querySubj_lect);

        } catch (SQLException e) {
            System.out.println("Trouble with create tables");
        }
    }

    public ObservableList<Student> getTableStudent() {
        ArrayList<Student> students = new ArrayList<Student>();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("select * from student");
            while (rs.next()) {
                students.add(new Student(rs.getString("surname"), rs.getString("name"),
                        rs.getString("stipend"),
                        rs.getString("kurs"), rs.getString("city"), rs.getString("birthday"),
                        rs.getInt("univer")));
            }
        } catch (SQLException e) {
            System.out.println("Trouble with get table Student");
        }

        ObservableList<Student> data = FXCollections.observableArrayList(students);
        return data;
    }

    public ObservableList<Lecturer> getTableLecturer() {
        ArrayList<Lecturer> letcurers = new ArrayList<Lecturer>();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("select * from Lecturer");
            while (rs.next()) {
                letcurers.add(new Lecturer(rs.getString("lecturer_id"), rs.getString("surname"), rs.getString("name"),
                        rs.getString("city"), rs.getString("univer")));
            }
        } catch (SQLException e) {
            System.out.println("Trouble with get table Lecturer");
        }

        ObservableList<Lecturer> data = FXCollections.observableArrayList(letcurers);
        return data;
    }

    public ObservableList<Subject> getTableSubject() {
        ArrayList<Subject> subjects = new ArrayList<Subject>();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("select * from Subject");
            while (rs.next()) {
                subjects.add(new Subject(rs.getString("subj_id"), rs.getString("subj_name"),
                        rs.getString("hours"), rs.getString("semester")));
            }
        } catch (SQLException e) {
            System.out.println("Trouble with get table Subject");
        }

        ObservableList<Subject> data = FXCollections.observableArrayList(subjects);
        return data;
    }

    public ObservableList<Subj_lect> getTableSubj_lects() {
        ArrayList<Subj_lect> subj_lects = new ArrayList<Subj_lect>();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("select * from Subj_lect");
            while (rs.next()) {
                subj_lects.add(new Subj_lect(rs.getString("lecturer_id"), rs.getString("subj_id")));
            }
        } catch (SQLException e) {
            System.out.println("Trouble with get table Subj_Lect");
        }

        ObservableList<Subj_lect> data = FXCollections.observableArrayList(subj_lects);
        return data;
    }

    public ObservableList<University> getTableUniversities() {
        ArrayList<University> universities = new ArrayList<University>();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("select * from University");
            while (rs.next()) {
                universities.add(new University(rs.getString("univ_id"), rs.getString("univ_name"),
                        rs.getString("rating"), rs.getString("city")));
            }
        } catch (SQLException e) {
            System.out.println("Trouble with get table University");
        }

        ObservableList<University> data = FXCollections.observableArrayList(universities);
        return data;
    }

    public ObservableList<Exam_marks> getTableExamMarks() {
        ArrayList<Exam_marks> markrs = new ArrayList<Exam_marks>();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("select * from Exam_marks");
            while (rs.next()) {
                markrs.add(new Exam_marks(rs.getString("exam_id"), rs.getString("student_id"),
                        rs.getString("subj_id"), rs.getString("mark"), rs.getString("exam_date")));
            }
        } catch (SQLException e) {
            System.out.println("Trouble with get table Exam_marks");
        }

        ObservableList<Exam_marks> data = FXCollections.observableArrayList(markrs);
        return data;
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection close");
            } catch (SQLException e) {
                System.out.println("Trouble with close connection");
            }
        }
    }
}
