public class Student {
    private String surname;
    private String name;
    private int stipend;
    private int kurs;
    private String city;
    private String birthday;
    private int univer;

    public Student(String surname, String name, String stipend, String kurs, String city, String birthday,
            int univer) {
        this.surname = surname;
        this.name = name;
        this.stipend = Integer.parseInt(stipend);
        this.kurs = Integer.parseInt(kurs);
        this.city = city;
        this.birthday = birthday;
        this.univer = univer;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getStipend() {
        return stipend;
    }

    public int getKurs() {
        return kurs;
    }

    public String getCity() {
        return city;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getUniver() {
        return univer;
    }
}
