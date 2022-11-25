<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
    <div id="top"><p id="status"></p> People's Hospital
        <h3 id="name">Hi,${pid} <a href="/">Logout</a></h3>

    </div>
    <div id="contain1">
        <h1 >MAKE APPOIMENT
            <hr>
        </h1>
        <br>
        <form action="/makeapp" method="post">
            
            <!-- <input id="ipt1"  type="text" placeholder="Appiment Id" name="a_id" ><br> -->
            <input id="ipt1" value=${pid} type="text" placeholder="Patient Id" name="p_id" required><br>
            <input id="ipt1" type="date"  name="date" required><br>
            <input id="ipt1" type="text" placeholder="Hopital Id" name="h_id" required><br>
            <input id="ipt1" type="text" placeholder="Doctor Id" name="d_id" required><br>
            <input id="btn1" type="submit" value="Make Appoiment">
        </form>

    </div>
</body>
</html>