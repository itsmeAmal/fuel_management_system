<%@page import="com.fms.control.fuelDetailCOntrol"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Add Salary</title>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <!-- Google Fonts -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
        <!-- Bootstrap core CSS -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <!-- Material Design Bootstrap -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.18.0/css/mdb.min.css" rel="stylesheet">

        <!-- JQuery -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <!-- MDB core JavaScript -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.18.0/js/mdb.min.js"></script>
    </head>
    <body>
        <form action="addAndUpdateFuelInfo" method="post">
            <div style="position: absolute; left: 0px; width: 100%; height: 100%; top: 0px; "></div> 

            <div style="position: absolute; left: 5%; top:  5%; width: 400px; height: 60px" class="md-form">
                <h5 class="card-title">Add Fuel Receiving Information</h5>
            </div>
            <div style="position: absolute; left: 5%; top:  15%; width: 300px; height: 60px">
                <div class="dropdown">
                    <div id="fuel_type">
                        <label for="form7">Fuel Type</label>
                        <select class="form-control" name="type" id=form7>
                            <option>DIESEL</option>
                            <option>PETROL 92</option>
                            <option>PETROL 95</option>
                            <option>SUPER DIESEL</option>
                        </select>
                    </div>
                </div>
            </div>

            <div style="position: absolute; left: 5%; top:  25%; width: 300px; height: 60px" class="md-form">
                <input type="text" name="qty" placeholder="Quantity" class="form-control" id="form1" required> 
                <label for="form1">Quantity</label>
            </div>

            <div style="position: absolute; left: 5%; top:  35%; width: 300px; height: 60px" class="md-form">
                <input type="text" name="wastage" placeholder="Wastage" class="form-control" id="form2" required> 
                <label for="form2">Wastage</label>
            </div>

            <div style="position: absolute; left: 5%; top:  47%; width: 300px; height: 60px">
                <div class="dropdown">
                    <div id="fuel_type">
                        <label for="form10">Service Provider</label>
                        <select class="form-control" name="from" id=form10>
                            <option>CPSTL</option>
                            <option>IOC</option>
                            <option>CEYPETCO</option>
                            <option>CORRECTED</option>
                        </select>
                    </div>
                </div>
            </div>
            <div style="position: absolute; left: 5%; top:  57%; width: 300px; height: 60px" class="md-form">
                <input type="text" name="note" placeholder="Note" class="form-control" id="form3" required> 
                <label for="form3">Note</label>
            </div>

            <div style="position: absolute; left: 5%; top:  70%; width: 300px; height: 60px" align="left"> 
                <input type="submit" value="ADD FUEL STOCK INFO" name="save"  class="btn btn-info btn-rounded" id="form6"> 
            </div>

            <div style="position: absolute; left: 20%; top:  70%; width: 300px; height: 60px" align="left"> 
                <input type="submit" value="UPDATE FUEL STOCK INFO" name="update"  class="btn btn-success btn-rounded" id="form8"> 
            </div>
        </form>
        <div style="position: absolute; left: 35%; top: 10%; width: 60%; height: 80%"> 
            <form action="deleteFuelDetail" method="post">
                <table class="table">
                    <thead class="black white-text">
                        <tr>
                            <th scope="col">Date</th>
                            <th scope="col">Fuel Type</th>
                            <th scope="col">Quantity</th>
                            <th scope="col">Wastage</th>
                            <th scope="col">From Station</th>
                            <th scope="col">Note</th>
                            <th scope="col">Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ResultSet rset = fuelDetailCOntrol.getAllFuelDetails();
                            while (rset.next()) {
                        %>
                        <tr>                            
                            <td><%= rset.getDate("fuel_detail_add_date")%></td>
                            <td><%= rset.getString("fuel_detail_fuel_type")%></td>
                            <td><%= rset.getBigDecimal("fuel_detail_qty")%></td>
                            <td><%= rset.getBigDecimal("fuel_detail_wastage")%></td>
                            <td><%= rset.getString("fuel_detail_from")%></td>
                            <td><%= rset.getString("fuel_detail_note")%></td>
                            <td><input type="submit" class="btn btn-danger btn-sm m-0" value="DELETE">
                                <input type="hidden"  value="<%= rset.getString("fuel_detail_fuel_type")%>" name="hidden_fuel_type" >
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html> 