package javafiles;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/makeapp")
public class appiment extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor", "root", "");
            // int app_id = Integer.parseInt(req.getParameter("a_id"));
            String p_id = req.getParameter("p_id");
            // LocalDate date1 = LocalDate.parse();
            String date_ap = req.getParameter("date");
            int h_id = Integer.parseInt(req.getParameter("h_id"));
            int d_id = Integer.parseInt(req.getParameter("d_id"));
            PreparedStatement stat = con.prepareStatement("insert into appointment values(?,?,?,?,?)");
            stat.setString(2, p_id);
            stat.setString(3, date_ap);
            stat.setInt(4, h_id);
            stat.setInt(5, d_id);
            stat.setInt(1, 0);

            System.out.println("start execute");
            stat.executeUpdate();
            System.out.println("exit execute");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("working bro");
        Gson g=new Gson();
        String requestData = req.getReader().lines().collect(Collectors.joining());
        doctormodel statuslist = g.fromJson(requestData, doctormodel.class);
        // System.out.println(statuslist.getApp_id());
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor", "root", "")) {
            PreparedStatement stat = con.prepareStatement("update appointment set status=1 where app_id=?");
            stat.setInt(1,statuslist.getApp_id() );
            stat.executeUpdate();
            System.out.println("execute successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
