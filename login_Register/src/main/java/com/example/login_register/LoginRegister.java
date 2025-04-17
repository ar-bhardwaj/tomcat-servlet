package com.example.login_register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/login")
public class LoginRegister extends HttpServlet {
    ArrayList<Login> lg = new ArrayList<>();
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(!username.matches("^[A-Z][a-z]{3,}")|| !isValidPassword(password)){
            req.setAttribute("error", "Username or password is incorrect");
            req.getRequestDispatcher("login.jsp").forward(req, res);
            return;
        }


        Login l =new Login(username,password);
        lg.add(l);

    }
    private boolean isValidPassword(String password) {
        if (password == null || password.length() < 8)
            return false;

        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasOneSpecial = password.replaceAll("[a-zA-Z0-9]", "").length() == 1;

        return hasUppercase && hasDigit && hasOneSpecial;
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println(lg.toString());
    }
}
