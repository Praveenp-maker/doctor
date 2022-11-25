<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
                integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
                crossorigin="anonymous" referrerpolicy="no-referrer"></script>
            <link rel="stylesheet" href="index.css">
            <title>Document</title>
        </head>

        <body >
            <div id="top">Your Appoiments</div>
            <center><button onclick="datewice(${did})"> Click to view</button></center>
            <div id="appodiv">
                <table id="astatus" >
                    <tr>
                        <th>Application Id</th>
                        <th>patient id</th>
                        <th>patient name</th>
                        <th>Date of Appoiment</th>
                        <th>Decision</th>
                    </tr>
                </table>
            </div>
            
            <script src="doctor.js"></script>
        </body>

        </html>