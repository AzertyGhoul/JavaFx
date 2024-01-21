public class Subj_lect {
    private int lecturerId;
    private int subjId;

    public Subj_lect(String lecturerId, String subjId) {
        this.lecturerId = Integer.parseInt(lecturerId);
        this.subjId = Integer.parseInt(subjId);
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public int getSubjId() {
        return subjId;
    }
}
