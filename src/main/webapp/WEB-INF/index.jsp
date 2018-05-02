<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Simple Sidebar - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="${ css }/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${ css }/myapp.css" rel="stylesheet">
    

</head>
<script type="text/javascript">

window.contextRoot = '${contextRoot}';
</script>

<body>

    <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="${ contextRoot }/">
                        Car Zone
                    </a>
                </li>
                <li>
                    <a href="${ contextRoot }/Register">Register</a>
                </li>
                <li>
                    <a href="${ contextRoot }/Login">Login</a>
                </li>
              
                <li>
                    <a href="${ contextRoot }/Services">About Us</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
            
            <c:if test="${index == true }">
	
					<h1>Car Zone</h1>
                <p>Car Zone is a leading two-sided digital automotive marketplace that creates meaningful connections between buyers and sellers.Launched in 1998 and headquartered in Chicago, the company empowers consumers with resources and information to make informed buying decisions around The 4Ps of Automotive MarketingTM: Product, Price, Place and Person, by connecting advertising partners with in-market car shoppers and providing data-driven intelligence to increase inventory turn and gain market share. A pioneer in online automotive classifieds, the company has evolved into one of the largest digital automotive platforms, connecting thousands of local dealers across the country with millions of consumers. Through trusted expert content, on-the-lot mobile features and intelligence, millions of new and used vehicle listings, a comprehensive set of pricing and research tools, and the largest database of consumer reviews in the industry, Car Zone is transforming the car shopping experience.</p>
                

				</c:if>
				
              <c:if test="${Register == true }">

				<%@include file="Register.jsp"%>
			</c:if>
			 <c:if test="${Services == true }">

				<%@include file="Services.jsp"%>
			</c:if>
			
			 <c:if test="${Login == true }">

				<%@include file="Login.jsp"%>
			</c:if>
			
			 <c:if test="${Admin == true }">

				<%@include file="Admin.jsp"%>
			</c:if>
			
			<c:if test="${AddCar == true }">

				<%@include file="AddCar.jsp"%>
			</c:if>
			
			<c:if test="${DeleteCar == true }">

				<%@include file="DeleteCar.jsp"%>
			</c:if>
			
			<c:if test="${AddCarPart == true }">

				<%@include file="AddCarPart.jsp"%>
			</c:if>
			
			<c:if test="${DeleteCarPart == true }">

				<%@include file="DeleteCarPart.jsp"%>
			</c:if>
			
			<c:if test="${Customer == true }">

				<%@include file="Customer.jsp"%>
			</c:if>
			
			<c:if test="${ViewCar == true }">

				<%@include file="ViewCar.jsp"%>
			</c:if>
			
			<c:if test="${ViewCarPart == true }">

				<%@include file="ViewCarPart.jsp"%>
			</c:if>
			
			<c:if test="${SingleProduct == true }">

				<%@include file="SingleProduct.jsp"%>
			</c:if>
			
				<c:if test="${ViewCart == true }">

				<%@include file="ViewCart.jsp"%>
			</c:if>
			
			
			
				<c:if test="${CheckOut == true }">

				<%@include file="CheckOut.jsp"%>
			</c:if>
			
			<c:if test="${SingleProductPart == true }">

				<%@include file="SingleProductPart.jsp"%>
			</c:if>
			<c:if test="${OrderList == true }">

				<%@include file="ViewOrders.jsp"%>
			</c:if>
              <br>
              <br>
                <a href="#menu-
" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Bootstrap core JavaScript -->
    <script src="${ js }/jquery.min.js"></script>
    <script src="${ js }/bootstrap.bundle.min.js"></script>
  

    <!-- Menu Toggle Script -->
    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>

</body>

</html>

