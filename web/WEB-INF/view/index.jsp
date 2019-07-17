<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 7/17/2019
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <ul>
    <li><a href="/test" >TEST</a></li>
    <li><a href="/addUpdate" >Add</a></li>
    <li><a href="/addUpdate/1" >Edit</a></li>
  </ul>
  <form method="post" action="/sent">
    <input type="number" name="rate"  placeholder="rate">
    <input type="number" name="sent" placeholder="sent khong bat buoc">
    <input type="submit" value="chuyen">



  </form>

  <h2>DANG KY</h2>
  <form method="post" action="/register">
    <input type="email" name="email"  placeholder="email"> <span>*</span>
    <input type="number" name="address" placeholder="address" >
    <input type="submit" value="Dang ky">



  </form>
  ${unit}  :   ${resout}




  </body>
</html>
