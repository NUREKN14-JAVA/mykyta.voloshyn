package nure.ua.hulko.daria.main.java.web;


import nure.ua.hulko.daria.main.java.User;
import nure.ua.hulko.daria.main.java.db.DaoFactory;
import nure.ua.hulko.daria.main.java.db.DatabaseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Created by Darusya Gulko on 15.12.2016.
 */
public class AddServlet  extends EditServlet {

    protected void processUser(User user) throws DatabaseException {
        DaoFactory.getInstance().getUserDao().create(user);
    }

    protected void showPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }
}