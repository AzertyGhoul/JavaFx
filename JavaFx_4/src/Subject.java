public class Subject {
    private int subjId;
    private String subjName;
    private int hours;
    private int semester;

    public Subject(String subjId, String subjName, String hours, String semester) {
        this.subjId = Integer.parseInt(subjId);
        this.subjName = subjName;
        this.hours = Integer.parseInt(hours);
        this.semester = Integer.parseInt(semester);
    }

    public int getSubjId() {
        return subjId;
    }

    public String getSubjName() {
        return subjName;
    }

    public int getHours() {
        return hours;
    }

    public int getSemester() {
        return semester;
    }
}
