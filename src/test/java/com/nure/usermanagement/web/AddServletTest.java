package nure.ua.hulko.daria.test.java.web;

import nure.ua.hulko.daria.main.java.User;
import nure.ua.hulko.daria.main.java.web.AddServlet;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Darusya Gulko on 15.12.2016.
 */
public class AddServletTest extends MockServletTestCase {

    protected void setUp() throws Exception {
        super.setUp();
        createServlet(AddServlet.class);
    }

    public void testAdd() {
        Date date = new Date();
        User newUser = new User("John", "Doe", date);
        User user = new User(new Long(1000), "John", "Doe", date);
        getMockUserDao().expectAndReturn("create", newUser, user);

        addRequestParameter("firstName", "John");
        addRequestParameter("lastName", "Doe");
        addRequestParameter("date", DateFormat.getDateInstance().format(date));
        addRequestParameter("okButton", "Ok");
        doPost();
    }

    public void testAddEmptyFirstName() {
        Date date = new Date();
        addRequestParameter("lastName", "Doe");
        addRequestParameter("date", DateFormat.getDateInstance().format(date));
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Could not find error message in session scope", errorMessage);
    }

    public void testAddEmptyLastName() {
        Date date = new Date();
        addRequestParameter("firstName", "John");
        addRequestParameter("date", DateFormat.getDateInstance().format(date));
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Could not find error message in session scope", errorMessage);
    }

    public void testAddEmptyDate() {
        Date date = new Date();
        addRequestParameter("firstName", "John");
        addRequestParameter("lastName", "Doe");
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Could not find error message in session scope", errorMessage);
    }

    public void testAddEmptyDateIncorrect() {
        Date date = new Date();
        addRequestParameter("firstName", "John");
        addRequestParameter("lastName", "Doe");
        addRequestParameter("date", "hsdfkjshdfk");
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Could not find error message in session scope", errorMessage);
    }
}
