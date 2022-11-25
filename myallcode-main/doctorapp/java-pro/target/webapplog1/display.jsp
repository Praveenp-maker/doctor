<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <link rel="stylesheet" href="display.css">
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
                integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
                crossorigin="anonymous" referrerpolicy="no-referrer"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
            <script type="text/javascript"
                src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
            <link rel="stylesheet" type="text/css"
                href="https://cdn.datatables.net/r/dt/dt-1.10.22/datatables.min.css" />
            <script type="text/javascript" src="https://cdn.datatables.net/r/dt/dt-1.10.22/datatables.min.js"></script>

        </head>

        <body id="body" onload="view()">
            <div id="top">Sathya-hospital <label>+</lable>
    
            <div id="tbl">
                <table id="mytable">
                    <thead>
                        <tr>
                            <th>Application Id</th>
                            <th>Patient Id</th>
                            <th>patient name</th>
                            <th>Date Of application</th>
                            <th>Hospital Id</th>
                            <th>Doctor Id</th>
                        </tr>

                    </thead>
                  
                </table></button>
            </div><br>
            <!-- <center><button onclick="view()">Click to view</button></center> -->



            <script>
                $(document).ready(function () {
                    $('#mytable').DataTable();
                   

                });
            </script>
            <script src="display1.js"></script>

        </body>

        </html>