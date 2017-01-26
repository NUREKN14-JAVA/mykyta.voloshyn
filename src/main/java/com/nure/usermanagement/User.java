package main.java.com.nure.usermanagement;

/**
 * Created by VSV on 21/01/17.
 */
import java.util.Calendar;
import java.util.Date;


public class User {
    private Long id;
    private String firstname;
    private String lastName;
    private Date dateOfBirthd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirthd;
    }

    public void setDateOfBirth(Date dateOfBirthd) {
        this.dateOfBirthd = dateOfBirthd;
    }

    public Object getFullName() {
        return getLastName() + ", " + getFirstName();
    }

    public int getAge() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int currentYear = calendar.get(Calendar.YEAR);
        calendar.setTime(getDateOfBirth());
        int year = calendar.get(Calendar.YEAR);
        return currentYear - year;
    }
}


