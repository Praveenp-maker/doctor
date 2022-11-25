package javafiles;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/serv1")
public class servlet1 extends HttpServlet {
    ArrayList<doctormodel> mylist;

    int check = 0;
    int nextad = 0;
    String names;
    String d_or_p;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        mylist = new ArrayList<doctormodel>();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor", "root", "");
            PreparedStatement stat = con.prepareStatement("select * from appointment");
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                 ServletContext context5 = getServletContext();
                    context5.setAttribute("statusflag", rs.getInt("status"));
                PreparedStatement stat1 = con.prepareStatement("select p_name from patient where patientid=?");
                stat1.setString(1, rs.getString("Patientid"));
                ResultSet rs1 = stat1.executeQuery();
                if (rs1.next()) {
                    names = rs1.getString("p_name");
                }
                mylist.add(new doctormodel(rs.getInt("app_id"), rs.getString("Patientid"), rs.getString("app_date"),
                rs.getInt("H_ID"), rs.getInt("D_ID"),rs.getInt("status"),names));
            }
            Gson g = new Gson();
            String send = g.toJson(mylist);
            resp.getWriter().println(send);
            System.out.println(mylist);
        } catch (Exception e) {
            System.err.println("ERROR" + e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("from do post");

        boolean a = false;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor", "root", "");
            String uname = req.getParameter("un");
            String passwd = req.getParameter("ps");
            System.out.println(passwd);
            int pass1 = uname.length() - 1;

            // doctor area
            if ((uname.charAt(0) == 'd' || uname.charAt(0) == 'D')
                    && ((uname.charAt(pass1)) == 'r' || uname.charAt(pass1) == 'R')) {
                System.err.println("he is a dOCTOR");
                d_or_p = "doctor";
                ServletContext context = getServletContext();
                context.setAttribute("company", d_or_p);
                PreparedStatement stat = con
                        .prepareStatement("select d_name,d_id from doctortable where d_user=? AND password=?");
                stat.setString(1, uname);
                stat.setString(2, passwd);

                ResultSet rs = stat.executeQuery();
                if (rs.next()) {
                    req.setAttribute("uname1", rs.getString("d_name"));
                    
                     ServletContext context3 = getServletContext();
                    context3.setAttribute("did", rs.getString("d_id"));
                    RequestDispatcher rd1 = req.getRequestDispatcher("doctor.jsp");
                    rd1.forward(req, resp);
                } else {
                    check += 1;
                    resp.sendRedirect("error.html");
                }
            } else {
                // patient area
                System.out.println("unmame:" + uname + "\n" + "pass" + passwd);
                PreparedStatement stat = con
                        .prepareStatement("select p_name,patientid from patient where p_name=? AND passwd=?");

                stat.setString(1, uname);
                stat.setString(2, passwd);
                d_or_p = "patient";

                ServletContext context = getServletContext();
                context.setAttribute("company", d_or_p);

                ResultSet rs = stat.executeQuery();
                if (rs.next()) {
                    ServletContext context1 = getServletContext();
                    context1.setAttribute("uname1", rs.getString("p_name"));
                    ServletContext context2 = getServletContext();
                    context2.setAttribute("pid", rs.getString("Patientid"));
                    // ServletContext context3 = getServletContext();
                    // context3.setAttribute("pid", rs.getString("Patientid"));
                    resp.sendRedirect("doctor.jsp");

                } else {
                    check += 1;
                    resp.sendRedirect("error.html");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}