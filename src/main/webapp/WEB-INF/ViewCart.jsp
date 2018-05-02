<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />




<input type="hidden" id="currentuser" name="currentuser" value="${Session}">

<div class="container">
	<h2>Your Cart</h2>
	<div class="row">
		<div class="col-xs-12">

			<table id="listcartable" class="table table-striped table-borderd">

				<thead>

					<tr>
						<th>ToDO</th>
						
						<th>ModelName</th>
						
						<th>Year</th>
						<th>Price</th>
						
						<th>Seller</th>

					</tr>


				</thead>



			</table>
		</div>
	</div>
	<div class="row">
	<br>
	<h4>TOTAL : ${total}</h4>
	<a href="${contextRoot}/CheckOut" class="btn btn-success">Place Order</a>
	</div>
</div>


<script src="${ js }/jquery.min.js"></script>
<script src="${ js }/bootstrap.bundle.min.js"></script>
<script src="${ js }/jquery.dataTables.js"></script>




<script>
	var products = [ [ '1', 'sds', 'asd', 'asdasd', 'ad', 'asd', 'ad' ] ]

	var $table = $('#listcartable');
	
	var username = $('#currentuser').val();

	var jsonUrl = window.contextRoot + '/cart/' + username;
	
	var total = [];

	if ($table.length) {

		$table
				.DataTable({
					"bJQueryUI" : false,
					"bScrollCollapse" : true,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'cartID',
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="' + window.contextRoot + '/deletecart/' + data + '">Remove</a>';
									return str;
								}
							},
							{
								data : 'modelName'
							},
							{
								data : 'yearofmfg'
							}, {
								data : 'price'
								
							}, {
								data : 'seller'
							}, 

					]

				});
	}
	console.log(total);
	
	
</script>