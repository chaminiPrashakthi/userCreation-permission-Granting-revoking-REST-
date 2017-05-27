<%-- 
    Document   : revoking
    Created on : Nov 8, 2016, 5:30:46 PM
    Author     : Chamini
--%>

<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>privileges granting</title>
        <meta charset="UTF-8">
        
        <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $("button").click(function(){
                    var window = [];
                    $.each($("input[name='window']:checked"), function(){            
                        window.push($(this).val());
                    });
                        alert(" " + window.join(","));
                });
            });
        </script>
    </head>
    
    <body>
         <h1>Create A New User</h1>
        
        <form id="create" action="webresources/entity.user/create" method="POST"></form>
        <form id="window" action="webresources/entity.user/window" method="POST"></form>
        
            User Name:<br>
            <input type="text" name="username" style="width: 200px" form="create"><br>
            Password:<br>
            <input type="password" name="password" style="width: 200px" form="create"><br><br>
            <h3>Give the following Privileges</h3> <br>
            <label><input type="checkbox" value="Activity" name="window" form="window"> Activity</label><br>
            
            <input type="checkbox" name="S" value="SELECT" form="create"> Select
            <input type="checkbox" name="I" value="INSERT" form="create"> Insert
            <input type="checkbox" name="U" value="UPDATE" form="create"> Update
            <input type="checkbox" name="D" value="DELETE" form="create"> Delete<BR><Br>
           
            <label><input type="checkbox" value="Promotion" name="window" form="window"> Promotion</label><br>
           
            <input type="checkbox" name="S" value="SELECT" form="create"> Select
            <input type="checkbox" name="I" value="INSERT" form="create"> Insert
            <input type="checkbox" name="U" value="UPDATE" form="create"> Update
            <input type="checkbox" name="D" value="DELETE" form="create"> Delete<BR><Br> 

            <label><input type="checkbox" value="Tab3" name="window" form="window"> Tab3</label><br>
           
            <input type="checkbox" name="S" value="SELECT" form="create"> Select
            <input type="checkbox" name="I" value="INSERT" form="create"> Insert
            <input type="checkbox" name="U" value="UPDATE" form="create"> Update
            <input type="checkbox" name="D" value="DELETE" form="create"> Delete<BR><Br> 

            
            <input type="submit" value="Submit" form="create"><Br><Br>
            <a href="revoking.jsp">go to revoking permission</a>

    </body>
</html>