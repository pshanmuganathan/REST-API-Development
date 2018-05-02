package com.ps.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ps.WebService.CarPartService;
import com.ps.WebService.CarService;
import com.ps.WebService.CartService;
import com.ps.WebService.CustomerService;
import com.ps.WebService.OrderService;
import com.ps.model.CarModel;
import com.ps.model.CarPart;
import com.ps.model.CartModel;
import com.ps.model.Customer;
import com.ps.model.OrderModel;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerservice;

	@Autowired
	CarService carservice;

	@Autowired
	CarPartService carpartservice;

	@Autowired
	CartService cartservice;

	@Autowired
	OrderService orderservice;

	// ------------------------->Index<------------------->
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title", "HomePage");
		mv.addObject("index", true);

		return mv;
	}
	
	// ------------------------->Services Page<------------------->
	@RequestMapping(value = "/Services")
	public ModelAndView Services() {

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title", "HomePage");
		mv.addObject("Services", true);

		return mv;
	}

	// ------------------------->User Register<------------------->
	@RequestMapping(value = "/Register")
	public ModelAndView Register() {

		ModelAndView mv = new ModelAndView("index");

		mv.addObject("title", "Resgister");
		mv.addObject("Register", true);

		return mv;
	}

	// ------------------------->Add User API<------------------->
	@RequestMapping(value = "/add", method = RequestMethod.POST,headers = "Accept=application/json")
	public @ResponseBody Customer add(@RequestBody Customer customer) {

		System.out.println("DETAILS------------------>" + customer.getCustomerName() + customer.getCity()
				+ customer.getContact() + customer.getEmailID() + customer.getStAdd() + customer.getPassword()
				+ customer.getState() + customer.getZip());
		customerservice.Register(customer);
		return customer;
	}

	// ------------------------->Get User API<------------------->
	@RequestMapping(value = "/user/", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Customer> getListUser() {
		List<Customer> customers = customerservice.getListUser();

		return customers;
	}

	// ------------------------->Admin Page<------------------->
	@RequestMapping(value = "/Admin")
	public ModelAndView Admin() {

		ModelAndView mv = new ModelAndView("index");

		mv.addObject("title", "Resgister");
		mv.addObject("Admin", true);

		return mv;
	}

	// ------------------------->Login Page<------------------->
	@RequestMapping(value = "/Login")
	public ModelAndView Login() {

		ModelAndView mv = new ModelAndView("index");

		mv.addObject("title", "Resgister");
		mv.addObject("Login", true);

		return mv;
	}

	// ------------------------->Login Redirect<------------------->
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getuserdeatils(
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password, HttpServletRequest request) {

		int flag = 0;
		ModelAndView mv = null;

		List<Customer> customers = customerservice.getListUser();

		if (username.equals("admin") && password.equals("admin")) {
			flag = 1 ;
			mv = new ModelAndView("index");

			mv.addObject("title", "Resgister");
			mv.addObject("Admin", true);
		} else {

			for (Customer cust : customers) {

				if (username.equals(cust.getCustomerName()) && password.equals(cust.getPassword())) {
					flag = 1;
					HttpSession ses = request.getSession(true);
					ses.setAttribute("Name", cust.getCustomerName());
					mv = new ModelAndView("index");
					mv.addObject("title", "Resgister");
					mv.addObject("Customer", true);
				}
			}
		}
		if(flag == 0){
			 mv = new ModelAndView("index");

			mv.addObject("Invalid", true);
			mv.addObject("Login", true);

		}

		return mv;

	}

	// ------------------------->Add New Car<------------------->
	@RequestMapping(value = "/AddCar")
	public ModelAndView AddCar() {

		ModelAndView mv = new ModelAndView("index");

		mv.addObject("title", "Resgister");
		mv.addObject("Admin", true);
		mv.addObject("AddCar", true);

		return mv;
	}

	// ------------------------->Add New Car API<------------------->
	@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	public @ResponseBody CarModel addCartodb(@RequestBody CarModel carModel) {

		carservice.RegisterCar(carModel);
		return carModel;
	}

	// ------------------------->Delete a Car<------------------->
	@RequestMapping(value = "/DeleteCar")
	public ModelAndView DeleteCar() {

		ModelAndView mv = new ModelAndView("index");

		mv.addObject("title", "Resgister");
		mv.addObject("DeleteCar", true);

		return mv;
	}

	// ------------------------->Delete a Car API<------------------->
	@RequestMapping(value = "/deletecar/{id}", method = RequestMethod.GET)
	public ModelAndView deleteCar(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("index");

		carservice.deleteCar(id);
		mv.addObject("title", "Resgister");
		mv.addObject("DeleteCar", true);
		return mv;
	}

	// ------------------------->Get Cars API<------------------->

	@RequestMapping(value = "/cars/", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<CarModel> getListCar() {
		List<CarModel> cars = carservice.getListCar();

		return cars;
	}

	// ------------------------->Add New Car Part<------------------->
	@RequestMapping(value = "/AddCarPart")
	public ModelAndView AddCarPart() {

		ModelAndView mv = new ModelAndView("index");

		mv.addObject("title", "Resgister");
		mv.addObject("AddCarPart", true);

		return mv;
	}

	// ------------------------->Add New Car Part API<------------------->
	@RequestMapping(value = "/addCarPart", method = RequestMethod.POST)
	public @ResponseBody CarPart addCarParttodb(@RequestBody CarPart carPart) {

		carpartservice.RegisterCarPart(carPart);
		return carPart;
	}

	// ------------------------->Delete a Car<------------------->
	@RequestMapping(value = "/DeleteCarPart")
	public ModelAndView DeleteCarPart() {

		ModelAndView mv = new ModelAndView("index");

		mv.addObject("title", "Resgister");
		mv.addObject("DeleteCarPart", true);

		return mv;
	}

	// ------------------------->Delete a Car Part API<------------------->
	@RequestMapping(value = "/deletecarpart/{id}", method = RequestMethod.GET)
	public ModelAndView deleteCarPart(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("index");

		carpartservice.deleteCarPart(id);
		mv.addObject("title", "Resgister");
		mv.addObject("DeleteCarPart", true);
		return mv;
	}

	// ------------------------->Get Car Parts API<------------------->

	@RequestMapping(value = "/carparts/", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<CarPart> getListCarPart() {
		List<CarPart> carpart = carpartservice.getListCarPart();

		return carpart;
	}

	// ------------------------->View Cars<------------------->
	@RequestMapping(value = "/ViewCar")
	public ModelAndView ViewCar() {

		ModelAndView mv = new ModelAndView("index");

		mv.addObject("title", "Resgister");
		mv.addObject("ViewCar", true);

		return mv;
	}

	// ------------------------->View Car Parts<------------------->
	@RequestMapping(value = "/ViewCarPart")
	public ModelAndView ViewCarPart() {

		ModelAndView mv = new ModelAndView("index");

		mv.addObject("title", "Resgister");
		mv.addObject("ViewCarPart", true);

		return mv;
	}

	// ------------------------->View Specific Car<------------------->
	@RequestMapping(value = "/Viewcar/carID/{id}", method = RequestMethod.GET)
	public ModelAndView ViewSpecificCar(@PathVariable("id") int id) {
		CarModel car = carservice.getCarinfo(id);
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("car", car);
		mv.addObject("SingleProduct", true);

		return mv;
	}

	// ------------------------->Add Cart(Car)<------------------->
	@RequestMapping(value = "/cart/add/{id}", method = RequestMethod.GET)
	public ModelAndView AddCart(@PathVariable("id") int id, HttpServletRequest request) {
		CarModel car = carservice.getCarinfo(id);

		CartModel cartmodel = new CartModel();
		cartmodel.setModelName(car.getModelName());
		cartmodel.setPrice(car.getPrice());
		cartmodel.setSeller(car.getSeller());
		cartmodel.setYearofmfg(car.getYearofmfg());
		Object s = request.getSession(false).getAttribute("Name");
		String b = s.toString();
		cartmodel.setCustomerName(b);
		cartservice.RegisterCart(cartmodel);
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("car", car);
		mv.addObject("SingleProduct", true);

		return mv;
	}

	// ------------------------->Add Cart(CarPart)<------------------->
	@RequestMapping(value = "/cart/part/add/{id}", method = RequestMethod.GET)
	public ModelAndView AddCartPart(@PathVariable("id") int id, HttpServletRequest request) {
		CarPart car = carpartservice.getCarinfo(id);

		CartModel cartmodel = new CartModel();
		cartmodel.setModelName(car.getPartName());
		cartmodel.setPrice(car.getPrice());
		cartmodel.setSeller("Admin");
		cartmodel.setYearofmfg(car.getYearofmfg());
		Object s = request.getSession(false).getAttribute("Name");
		String b = s.toString();
		cartmodel.setCustomerName(b);
		cartservice.RegisterCart(cartmodel);
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("car", car);
		mv.addObject("SingleProductPart", true);

		return mv;
	}

	// ------------------------->View Cart<------------------->
	@RequestMapping(value = "/ViewCart")
	public ModelAndView ViewCart(HttpServletRequest request) {

		int total = 0;
		ModelAndView mv = new ModelAndView("index");
		Object s = request.getSession(false).getAttribute("Name");
		String b = s.toString();
		mv.addObject("Session", b);

		List<CartModel> cartmodel = cartservice.getListCart(b);
		for (CartModel temp : cartmodel) {

			String price = temp.getPrice();
			total = total + Integer.parseInt(price);

		}
		mv.addObject("total", total);
		mv.addObject("title", "Resgister");
		mv.addObject("ViewCart", true);
		System.out.println("CHECK---------->" + b);
		return mv;
	}

	// ------------------------->View Cart API<------------------->
	@RequestMapping(value = "/cart/{username}", method = RequestMethod.GET)
	public @ResponseBody List<CartModel> ViewCartApi(@PathVariable("username") String username) {

		List<CartModel> cartmodel = cartservice.getListCart(username);

		return cartmodel;
	}

	// ------------------------->Delete a Cart API<------------------->
	@RequestMapping(value = "/deletecart/{id}", method = RequestMethod.GET)
	public ModelAndView deleteCart(@PathVariable("id") int id, HttpServletRequest request) {

		int total = 0;
		ModelAndView mv = new ModelAndView("index");

		cartservice.deleteCart(id);
		Object s = request.getSession(false).getAttribute("Name");
		String b = s.toString();
		mv.addObject("Session", b);

		List<CartModel> cartmodel = cartservice.getListCart(b);
		for (CartModel temp : cartmodel) {

			String price = temp.getPrice();
			total = total + Integer.parseInt(price);

		}
		mv.addObject("total", total);
		mv.addObject("title", "Resgister");
		mv.addObject("ViewCart", true);
		System.out.println("CHECK---------->" + b);
		return mv;
	}

	// ------------------------->CheckOut Page<------------------->
	@RequestMapping(value = "/CheckOut")
	public ModelAndView CheckOut() {

		ModelAndView mv = new ModelAndView("index");

		mv.addObject("title", "Resgister");
		mv.addObject("CheckOut", true);

		return mv;
	}

	// ------------------------->PlaceOrder<------------------->
	@RequestMapping(value = "/PlaceOrder")
	public ModelAndView PlaceOrder(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("index");
		Object s = request.getSession(false).getAttribute("Name");
		String b = s.toString();

		List<CartModel> cartmodel = cartservice.getListCart(b);
		OrderModel orderModel = new OrderModel();
		for (CartModel cart : cartmodel) {
			orderModel.setModelName(cart.getModelName());
			orderModel.setPrice(cart.getPrice());
			orderModel.setSeller(cart.getSeller());
			orderModel.setCustomerName(cart.getCustomerName());
			orderModel.setYearofmfg(cart.getYearofmfg());
			System.out.println("INSIDE LOOP------------------->" + cart.getModelName());
			orderservice.RegisterOrder(orderModel);
			cartservice.deleteCart(cart.getCartID());
		}

		mv.addObject("title", "Resgister");
		mv.addObject("Customer", true);

		return mv;
	}

	// ------------------------->View Specific Car Part<------------------->
	@RequestMapping(value = "/ViewcarPart/carID/{id}", method = RequestMethod.GET)
	public ModelAndView ViewSpecificCarPart(@PathVariable("id") int id) {
		CarPart car = carpartservice.getCarinfo(id);
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("car", car);
		mv.addObject("SingleProductPart", true);

		return mv;
	}

	// ------------------------->Sell Car<------------------->
	@RequestMapping(value = "/SellCar", method = RequestMethod.GET)
	public ModelAndView ViewSpecificCarPart(HttpServletRequest request) {
		Object s = request.getSession(false).getAttribute("Name");
		String b = s.toString();
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("Seller", true);
		mv.addObject("Username", b);
		mv.addObject("AddCar", true);

		return mv;
	}
	
	// ------------------------->ViewOrders<------------------->
	@RequestMapping(value = "/ViewOrders")
	public ModelAndView OrderList() {

		ModelAndView mv = new ModelAndView("index");

		mv.addObject("title", "Resgister");
		mv.addObject("OrderList", true);

		return mv;
	}

	// ------------------------->View Orders API<------------------->
	@RequestMapping(value = "/vieworders/", method = RequestMethod.GET)
	public @ResponseBody List<OrderModel> ViewOrders() {

		List<OrderModel> ordermodel = orderservice.getListOrders();

		return ordermodel;
	}
}
