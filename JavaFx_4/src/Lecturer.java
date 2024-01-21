public class Lecturer {
    private int lecturerId;
    private String surname;
    private String name;
    private String city;
    private int univer;

    public Lecturer(String lecturerId, String surname, String name, String city, String univer) {
        this.lecturerId = Integer.parseInt(lecturerId);
        this.surname = surname;
        this.name = name;
        this.city = city;
        this.univer = Integer.parseInt(univer);
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getUniver() {
        return univer;
    }
}
