package javafiles;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
@WebServlet("/dserv")
public class doctserv extends HttpServlet {
    ArrayList<dmodel> mylist;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        mylist = new ArrayList<dmodel>();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor", "root", "");
            
            PreparedStatement stat = con.prepareStatement("select * from doctortable");
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
              
                mylist.add(new dmodel( rs.getString("D_user"), rs.getInt("password"), rs.getInt("D_ID"), rs.getString("D_NAME"),rs.getInt("APP_ID"),rs.getString("special") ));
            }
            Gson g = new Gson();
            String send = g.toJson(mylist);
            resp.getWriter().println(send);
            System.out.println("send successfully");
        } catch (Exception e) {
            System.err.println("ERROR" + e);
        }
    }
 

}
