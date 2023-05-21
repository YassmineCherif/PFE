package com.isg.UserService.controller;


import com.isg.UserService.config.OrderResourceFeign;
import com.isg.UserService.config.ProductResourceFeign;
import com.isg.UserService.model.*;
import com.isg.UserService.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/user-service/")
public class UserController {

	@Autowired
	private SellerRepository sellerRepository;

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private ProductResourceFeign productResourceFeign;

	@Autowired
	private OrderResourceFeign iOrder;
	
	/* Admin */
	/*
	 * Method for adding a super admin
	 */
	@PostMapping("/saveSuperAdmin")
	public Admin saveSuperAdmin(@RequestBody Admin admin) {
		admin.setIsActive(true);
		admin.setRole("super-admin");
		// save the admin
		Admin newAdmin = adminRepository.save(admin);

		return newAdmin;
	}
	/*
	 * Method for adding a new admin
	 */
	@PostMapping("/saveAdmin")
	public Admin saveAdmin( @RequestBody Admin admin) {
		admin.setRole("admin");
		// save the admin
		Admin newAdmin = adminRepository.save(admin);

		return newAdmin;
	}
	/*
	 * Method for retrieving the list of admin
	 */
	@RequestMapping("/allAdmin")
	public List<Admin> allAdmin() {
		
		return adminRepository.findByRole("admin");

	}
	/*
	 * Method for retrieving the super admin 
	 */
	@RequestMapping("/getSuperAdmin")
	public Admin getSuperAdmin() {
		
		return adminRepository.findOneByRole("super-admin");

	}
	/*
	 * Method to retrieve an admin by id
	 */
	@RequestMapping("/getAdmin/{id}")
	public Optional<Admin> getAdmin(@PathVariable("id") String id) {
		// get seller by id
		Optional<Admin> admin = adminRepository.findById(id);

		return admin;

	}
	/*
	 * Method to delete admin by id
	 */
	@RequestMapping("/deleteAdmin/{id}")
	public void deleteAdmin(@PathVariable("id") String id) {
		
		adminRepository.deleteById(id);


	}
	/*
	 * Method to retrieve a admin by its mail and password
	 */
	@RequestMapping("/findSuperAdmin")
	public Admin findSuperAdmin(String mail, String password) {
		// get a admin by it's mail and password
		Admin admin = adminRepository.findByMailAndPassword(mail, password);
		// return the customer
		return admin;

	}
	/* Seller */

	/*
	 * Method for adding a new seller
	 */
	@PostMapping("/saveSeller")
	public Seller saveSeller(@Valid @RequestBody Seller seller) {
		// save the seller
		Seller newSeller = sellerRepository.save(seller);

		return newSeller;
	}
	/*
	 * Method for updating  a  seller
	 */
	@RequestMapping("/updateSeller")
	public Seller updateSellerAccount(String id,Boolean state) {
		// get seller by id
		Optional<Seller> seller = sellerRepository.findById(id);
		// update Seller
		seller.get().setIsActive(state);
		// save the seller
		Seller newSeller = sellerRepository.save(seller.get());

		return newSeller;
	}
	/*
	 * Method for listing all sellers
	 */
	@RequestMapping("/allSellers")
	public List<Seller> getSellers() {
		// return the list of all selles
		return sellerRepository.findAll();

	}
	/*
	 * Method to retrieve a seller by its mail and password
	 */
	@RequestMapping("/findSeller")
	public Seller findSeller(String mail, String password) {
		// get a seller by it's mail and password
		Seller seller = sellerRepository.findByMailAndPassword(mail, password);
		// return the seller
		return seller;

	}
	/*
	 * Method to retrieve a seller by id
	 */
	@RequestMapping("/getSeller/{id}")
	public Optional<Seller> getSeller(@PathVariable("id") String id) {
		// get seller by id
		Optional<Seller> seller = sellerRepository.findById(id);
		// get seller's products
		List<Product> products = productResourceFeign.getBySeller(id);
		// get seller's orders
		List<Order> orders = iOrder.getOrdersBySeller(id);
		// set seller's products
		seller.get().setProducts(products);
		// set seller's orders
		seller.get().setOrders(orders);
		return seller;

	}
	/*
	 * Method for getting products count by sellers - Statistics 
	 */
	@RequestMapping("/DashboradProductsBySellers")
	public List<Statistics> DashboradProductsBySellers() {
		List<Statistics> result = new ArrayList<Statistics>();
		List<Seller> sellers = sellerRepository.findAll();
		for (int i=0 ; i< sellers.size();i++) {
			List<Product> products = productResourceFeign.getBySeller(sellers.get(i).getId());
			Statistics obj = new Statistics(sellers.get(i).getFirstname()+" "+sellers.get(i).getLastname(),products.size());
		      result.add(obj);
			}

		return result;
	}
	/*
	 *  Method for getting orders count by sellers - Statistics 
	 */
	@RequestMapping("/DashboradOrdersBySellers")
	public List<Statistics> DashboradOrdersBySellers() {
		List<Statistics> result = new ArrayList<Statistics>();
		List<Seller> sellers = sellerRepository.findAll();
		for (int i=0 ; i< sellers.size();i++) {
			List<Order> orders = iOrder.getOrdersBySeller(sellers.get(i).getId());
			Statistics obj = new Statistics(sellers.get(i).getFirstname()+" "+sellers.get(i).getLastname(),orders.size());
		      result.add(obj);
			}

		return result;
	}
	/*
     *    Method for getting sellers count - Statistics 
	 */
	@RequestMapping("/DashboradSellersCount")
	public long DashboradSellersCount() {
		return  sellerRepository.count();		
	}
	
	/* Customer */

	/*
	 * Method for adding a new customer
	 */
	@PostMapping("/saveCustomer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		// save the new customer
		Customer newCustomer = customerRepository.save(customer);

		return newCustomer;
	}

	/*
	 * Method for listing all customers
	 */
	@RequestMapping("/allCustomers")
	public List<Customer> getCustomers() {
		// return the list of all customers
		return customerRepository.findAll();

	}
	/*
	 * Method for updating a  customer
	 */
	@RequestMapping("/updateCustomerAccount")
	public Customer updateCustomerAccount(String id,Boolean state) {
		// get customer by id
		Optional<Customer> customer = customerRepository.findById(id);
		// update Customer
		customer.get().setIsActive(state);
		// save the  customer
		Customer newCustomer = customerRepository.save(customer.get());

	   return newCustomer;
	}

	/*
	 * Method to retrieve a customer by id
	 */
	@RequestMapping("/getCustomer/{id}")
	public Optional<Customer> getCustomer(@PathVariable("id") String id) {
		// get customer by id
		Optional<Customer> customer = customerRepository.findById(id);
		// get customer's orders
		List<Order> orders = iOrder.getOrdersByCustomer(id);
		// set customer's orders
		customer.get().setOrders(orders);
		// get customer's reviews
		List<Review> reviews = productResourceFeign.getReviwesByCustomer(id);
		// set customer's reviews
		customer.get().setReviews(reviews);
		// return customer
		return customer;

	}

	/*
	 * Method to retrieve a customer by its mail and password
	 */
	@RequestMapping("/findCustomerForLogin")
	public Customer getCustomerByMailAndPassword(String mail, String password) {
		// get a Customer by it's mail and password
		Customer customer = customerRepository.findByMailAndPassword(mail, password);
		// Verify the account is active
		if(customer != null && customer.getIsActive()) {return customer;}
		// return the customer
		return null;

	}
	/*
	 *  Method for getting orders count by customers - Statistics 
	 */
	@RequestMapping("/DashboradOrdersByCustomers")
	public List<Statistics> DashboradOrdersByCustomers() {
		List<Statistics> result = new ArrayList<Statistics>();
		List<Customer> customers = customerRepository.findAll();
		for (int i=0 ; i< customers.size();i++) {
			List<Order> orders = iOrder.getOrdersByCustomer(customers.get(i).getId());
			Statistics obj = new Statistics(customers.get(i).getFirstname()+" "+customers.get(i).getLastname(),orders.size());
		      result.add(obj);
			}

		return result;
	}
	/*
	 *  Method for getting reviews count by sellers - Statistics 
	 */
	@RequestMapping("/DashboradReviewsByCustomers")
	public List<Statistics> DashboradReviewsByCustomers() {
		List<Statistics> result = new ArrayList<Statistics>();
		List<Customer> customers = customerRepository.findAll();
		for (int i=0 ; i< customers.size();i++) {
			List<Review> reviews = productResourceFeign.getReviwesByCustomer(customers.get(i).getId());
			Statistics obj = new Statistics(customers.get(i).getFirstname()+" "+customers.get(i).getLastname(),reviews.size());
		      result.add(obj);
			}

		return result;
	}
	/*
	 *  Method for getting cutsomers count  - Statistics 
	 */
	@RequestMapping("/DashboradCustomersCount")
	public long DashboradCustomersCount() {
		return  customerRepository.count();		
	}
}
