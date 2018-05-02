<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<br>

<div class="container">


	<div class="row">
	
		<!-- Display the product image -->
		<div class="col-xs-12 col-sm-4">
		
			<div class="thumbnail">
							
				<img src="${images}/${car.modelName}.jpg" class="img img-responsive"/>
						
			</div>
		
		</div>
	
		
		<!-- Display the product description -->	
		<div class="col-xs-12 col-sm-8">
		
			<h3>${car.modelName}</h3>
			<hr/>
			
			<h4>Color: <strong>${car.color} </strong></h4>
			<hr/>
			
			<h4>Price: <strong>$ ${car.price} /-</strong></h4>
			<hr/>
			
			<h4>Car Type: <strong> ${car.cartype}</strong></h4>
			<hr/>
			
			
			<h4>Seller: <strong> ${car.seller} </strong></h4>
			<hr/>
			
				<a href="${contextRoot}/cart/add/${car.carID}" class="btn btn-success">Add to Cart</a>
				
			

			<a href="${contextRoot}/ViewCar" class="btn btn-warning">Back</a>
					
		</div>

	
	</div>

  
</div>
