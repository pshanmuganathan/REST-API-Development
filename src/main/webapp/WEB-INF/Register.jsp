<h2> Register Page</h2>

<div class="container">

	<form action="${ contextRoot }/add" method="post" id="submitForm">

		<p>
			<label>Name</label> <input name="customerName" type="text" />
		</p>

		<p>
			<label>Password</label> <input name="password" type="text" />
		</p>

		<p>
			<label>EmailID</label> <input name="emailID" type="text" />
		</p>

		<p>
			<label>Contact</label> <input name="contact" type="text" />
		</p>

		<p>
			<label>StAdd</label> <input name="stAdd" type="text" />
		</p>

		<p>
			<label>City</label> <input name="city" type="text" />
		</p>

		<p>
			<label>State</label> <input name="state" type="text" />
		</p>

		<p>
			<label>Zip</label> <input name="zip" type="text" />
		</p>


		<input type="submit" value="Submit Form">
	</form>
	
	<br>
	


				<div id="successregister" class="alert alert-danger" role="alert" style="display:none;">
  Invalid User!
</div>
		

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
			$.ajax({
				
				type : $(this).attr('method'), // method attribute of form
				url : $(this).attr('action'), // action attribute of form
				contentType: "application/json",
				dataType : 'json',
				// convert form data to json format
				data : JSON.stringify(formData),
				
				success: function(data) { 
					$('#successregister').show();
			    },
			    error: function(data,status,er) { 
			        alert("error: "+data+" status: "+status+" er:"+er);
			    }
				});
		});
	</script>
	
</div>
