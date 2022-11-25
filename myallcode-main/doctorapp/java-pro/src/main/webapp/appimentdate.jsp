<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <link rel="stylesheet" href="index.css">
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
                integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
                crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        </head>

        <body>

            <div id="top">
                <p id="status">

                    </p> People's Hospital

                <h3 id="name">Hi,${uname1} <a href="/">Logout</a></h3>
            </div>
            
            <div id="datediv">
                <p id="datep">Check Appoiment Date</p>
                <div id="date">
                    <h3>SELECT DATE: </h3>
                    <input type="date" name="mydate" id="iptdate" required>
                    <button id="idate" onclick="gotodate()">search</button>

                </div>
            </div>
            <script src="display1.js"></script>
        </body>

        </html>