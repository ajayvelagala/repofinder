<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
    <!DOCTYPE html>    
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Stock Master</title>
<!-- Tell the browser to be responsive to screen width -->

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
	
	
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css">

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
 <div class="row">
<div class="col-md-4">
<%-- <form:form action ="find" modelAttribute="userForm" method="post">
  <div class="form-group" >
    <label for="exampleInputEmail1">Search By Topic</label>
    <form:input name='topic' type="text" class="form-control" path="topic"  placeholder="Enter Topic" />
    
    
  </div>
  
  <div class="form-group" >
    <label for="exampleInputEmail1">Search By Language</label>
    <form:input name ="lang" type="text" class="form-control" path="lang"  placeholder="Enter Languauge"/>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form:form> --%>
</div>
<div class="col-md-6">
</div>
<div class="col-md-2">
<div class="row">
<p style="color:blue">User Name:</p>
<p>${username}</p>&nbsp;&nbsp;		
<a href ="/logout" >Logout</a>
</div>
</div>
</div>	

<br/><br/>	
<table id="example" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
             <th>No</th>
              <th>Date</th>
                <th>User Name</th>
                <th>Search Result</th>
            </tr>
        </thead>
        <tbody>
		  <c:forEach items="${userSearch}" var="results" varStatus="tagStatus">
		    <tr>
		    <td>${results.id}</td>
		    <td>${results.created_date}</td>
		        <td>${results.name}</td>
		        <td><a href='/adminFind?id=<c:out value="${results.search_result}" />' target="_blank">${results.search_result}</a></td>  
		    </tr>
		</c:forEach>
        </tbody>
        <tfoot>
            <tr>
             <th>No</th>
              <th>Date</th>
                <th>User Name</th>
                <th>Search Result</th>
               
            </tr>
        </tfoot>
    </table>
  
	<!-- jQuery 3 -->
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	 <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	 	 <script src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
	<script>
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>	
	

</body>
</html>
    
