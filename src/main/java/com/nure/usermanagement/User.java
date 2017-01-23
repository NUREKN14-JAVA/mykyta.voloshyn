package main.java;

/**
 * Created by VSV on 21/01/17.
 */
import java.util.Calendar;
import java.util.Date;


public class User {
    private long id;
    private String firstname;
    private String lastName;
    private Date dateOfBirthd;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirthd() {
        return dateOfBirthd;
    }

    public void setDateOfBirthd(Date dateOfBirthd) {
        this.dateOfBirthd = dateOfBirthd;
    }

    public Object getFullName() {
        return getLastName() + ", " + getFirstname();
    }

    public int getAge() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int currentYear = calendar.get(Calendar.YEAR);
        calendar.setTime(getDateOfBirthd());
        int year = calendar.get(Calendar.YEAR);
        return currentYear - year;
    }
}


