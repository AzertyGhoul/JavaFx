public class University {
    private int univer;
    private String univerName;
    private int rating;
    private String city;

    public University(String univer, String univerName, String rating, String city) {
        this.univer = Integer.parseInt(univer);
        this.univerName = univerName;
        this.rating = Integer.parseInt(rating);
        this.city = city;
    }

    public int getUniver() {
        return univer;
    }

    public String getUniverName() {
        return univerName;
    }

    public int getRating() {
        return rating;
    }

    public String getCity() {
        return city;
    }
}
