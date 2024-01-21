public class Exam_marks {
    private int examId;
    private int studentId;
    private int subjId;
    private int mark;
    private String examDate;

    public Exam_marks(String examId, String studentId, String subjId, String mark, String examDate) {
        this.examId = Integer.parseInt(examId);
        this.studentId = Integer.parseInt(studentId);
        this.subjId = Integer.parseInt(subjId);
        this.mark = Integer.parseInt(mark);
        this.examDate = examDate;
    };

    public int getExamId() {
        return examId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getSubjId() {
        return subjId;
    }

    public int getMark() {
        return mark;
    }

    public String getExamDate() {
        return examDate;
    }
}
