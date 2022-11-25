package javafiles;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/servdate")
public class checkdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap hmap = new HashMap<>();
        ArrayList<doctormodel> al=new ArrayList<doctormodel>();

        String requestData = req.getReader().lines().collect(Collectors.joining());
        Gson g = new Gson();
        doctormodel statuslist = g.fromJson(requestData, doctormodel.class);
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor", "root", "");
            PreparedStatement stat = con.prepareStatement("select DISTINCT(d_id),d_name,special from doctortable");
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                System.out.println();
                PreparedStatement stat2 = con
                        .prepareStatement("SELECT COUNT(D_ID) from appointment WHERE D_ID=? AND APP_DATE=?");
                stat2.setInt(1, rs.getInt(1));
                stat2.setString(2, statuslist.getApp_date());
                ResultSet ans = stat2.executeQuery();
                while (ans.next()) {
                    al.add(new doctormodel(rs.getInt(1), ans.getInt(1),rs.getString(2),rs.getString(3)));
                }
            }
            
            String send = g.toJson(al);
            resp.getWriter().println(send);
            System.out.println("send successfully");
        } catch (Exception e) {
            System.err.println("ERROR" + e);
        }
    }

}
