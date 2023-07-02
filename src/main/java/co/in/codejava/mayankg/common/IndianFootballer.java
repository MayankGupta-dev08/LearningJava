package co.in.codejava.mayankg.common;

public class IndianFootballer implements Footballers {
    private String firstName;
    private String lastName;
    private int jerseyNum;
    private String position;

    public IndianFootballer(String firstName, String lastName, int jerseyNum, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jerseyNum = jerseyNum;
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getJerseyNum() {
        return jerseyNum;
    }

    public void setJerseyNum(int jerseyNum) {
        this.jerseyNum = jerseyNum;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "IndianFootballer: [" +
                "'" + firstName + " " +
                lastName + "', |" +
                jerseyNum + "|, ==>" +
                position + "]";
    }
}
