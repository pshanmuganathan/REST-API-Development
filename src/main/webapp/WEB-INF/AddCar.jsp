<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<br>

<form class="form-horizontal" action="${ contextRoot }/addCar" method="post" id="submitForm">
<fieldset>

<!-- Form Name -->
<legend>Adding a car</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="dfsdf">Model Name</label>  
  <div class="col-md-4">
  <input id="modelName" name="modelName" type="text" placeholder="" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Color</label>  
  <div class="col-md-4">
  <input id="color" name="color" type="text" placeholder="" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Manufactured Year</label>  
  <div class="col-md-4">
  <input id="yearofmfg" name="yearofmfg" type="text" placeholder="" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Seller</label>  
  <div class="col-md-4">
  <c:if test="${Admin == true }">
  <input id="price" name="seller" type="text" value="Admin"placeholder="" class="form-control input-md" disabled>
   </c:if> 
   <c:if test="${Seller == true }">
  <input id="price" name="seller" type="text" value="${Username}" placeholder="" class="form-control input-md" disabled>
   </c:if> 
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Price</label>  
  <div class="col-md-4">
  <input id="seller" name="price" type="text" placeholder="" class="form-control input-md">
    
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="CarType">Car Type</label>
  <div class="col-md-4">
    <select id="cartype" name="cartype" class="form-control">
      <option value="1">New</option>
      <option value="2">Old</option>
    </select>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Add Car</button>
  </div>
</div>

</fieldset>
</form>

<script>
		$('#submitForm').submit(function(e) {
			// reference to form object
			var form = this;
			// for stopping the default action of element
			e.preventDefault();
			// mapthat will hold form data
			var formData = {}
			//iterate over form elements
			$.each(this, function(i, v) {
				var input = $(v);
				// populate form data as key-value pairs
				// with the name of input as key and its value as value
				formData[input.attr("name")] = input.val();
				
			});
			formData[$( "#cartype" ).attr("name")] = $( "#cartype option:selected" ).text();
			$.ajax({
				type : $(this).attr('method'), // method attribute of form
				url : $(this).attr('action'), // action attribute of form
				contentType : "application/json",
				dataType : 'json',
				// convert form data to json format
				data : JSON.stringify(formData),
				success: function(data) { 
			        alert("Successfully added!");
			    },
			    error: function(data,status,er) { 
			        alert("error: "+data+" status: "+status+" er:"+er);
			    }
				});
		});
	</script>
