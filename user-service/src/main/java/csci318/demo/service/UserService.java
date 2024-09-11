package csci318.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import csci318.demo.controller.DTO.CartDTO;
import csci318.demo.controller.DTO.ProductDTO;
import csci318.demo.controller.Requests.ProductRequest;
import csci318.demo.model.Cart.Cart;
import csci318.demo.model.Users.Customer;
import csci318.demo.repository.CustomerRepository;


@Service
public class UserService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public final String CART_URL = "http://localhost:8083/api/carts/";
    public final String PRODUCT_URL = "http://localhost:8081/api/products/";

    // Constructor injection for CustomerRepository.
    @Autowired
    public UserService(CustomerRepository customerRepository, RestTemplate restTemplate){
        this.customerRepository = customerRepository;
        this.restTemplate = restTemplate;
    }

     /**
      * Registers a new customer.
      * 
      * @param c The Customer object to be registered.
      * @return A ResponseEntity containing the result of the registration process.
      */

    public ResponseEntity<?> registerCustomer(Customer c) {

        // Check if the Customer object is null.
        if (c == null) {
            return ResponseEntity.badRequest().body("Customer data is missing");
        }

        // Check if required fields are present.
        if (c.getName() == null || c.getEmail() == null || c.getPassword() == null) {
            return ResponseEntity.badRequest().body("Missing required fields");
        }

        try {
            
            customerRepository.save(c);

            return ResponseEntity.ok(c);
        } 
        catch (Exception e) {
            // Handle any exceptions during registration.
            return ResponseEntity.badRequest().body("Failed to register: " + e.getMessage());
        }
    }


    /**
     * Authenticates a customer based on their email and password.
     * 
     * @param u The Customer object containing email and password credentials.
     * @return A ResponseEntity containing the authenticated customer or an error message.
     */
    public ResponseEntity<?> loginCustomer(Customer u) {

        Customer customer = customerRepository.findByEmail(u.getEmail());

        // Check if the customer exists.
        if (customer != null){
            if(u.getPassword().equals(customer.getPassword())){
                return ResponseEntity.ok(customer);
            }

            // Return an error if the passwords don't match.
            return ResponseEntity.status(999).body("Passwords don't match");
        }

        // Return an error if the user is not found.
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("user not found");

    }


    /**
     * Retrieves a customer by their unique ID.
     * 
     * @param id The UUID of the customer.
     * @return A ResponseEntity containing the customer or an error message.
     */
    public ResponseEntity<?> getCustomer(Long id) {

        Optional<Customer> optionalCustomer = customerRepository.findById(id);
    
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
        }
    }


    /**
     * Retrieves all customers.
     * 
     * @return A ResponseEntity containing a list of all customers.
     */
    public ResponseEntity<?> getCustomers() {

        List<Customer> customers = customerRepository.findAll();
        return ResponseEntity.ok(customers);

    }

    
    
    /**
     * Creates a new cart for a specific customer.
     * 
     * @param customerId The ID of the customer for whom the cart will be created.
     * @return The newly created CartDTO object.
     */
    public CartDTO createCartForCustomer(Long customerId) {

        String url = CART_URL + "/user" + customerId;
        
        return restTemplate.postForObject(url, null, CartDTO.class);
    }



    /**
     * Retrieves a cart for a specific customer.
     * 
     * @param customerId The ID of the customer whose cart is being retrieved.
     * @return The CartDTO object containing cart details.
     */
    public List<CartDTO> getCartsForCustomer(Long customerId) {

        String url = CART_URL + "/user" + customerId;

        CartDTO[] cartArray = restTemplate.getForObject(url, CartDTO[].class);

        return Arrays.asList(cartArray);
    }


    /**
     * Checks if a product exists by querying the product service.
     * 
     * @param productId The ID of the product to check.
     * @return The ProductDTO object if the product exists.
     */
    public ProductDTO checkProduct(Long productId) {

        String url = PRODUCT_URL + productId;

        return restTemplate.getForObject(url, ProductDTO.class);
         
    }



    /**
     * Adds a product to a specific cart.
     * 
     * @param cartId The ID of the cart to which the product will be added.
     * @param productRequest The ProductRequest object containing product details.
     */
    public void addProductToCart(Long cartid, ProductRequest productRequest){

        checkProduct(productRequest.getProductId());

        String url = CART_URL + cartid + "/products";

        try {
            restTemplate.put(url, productRequest);

        } catch (HttpClientErrorException e) {
            throw new RuntimeException("Error adding product to cart: " + e.getMessage());
        }
    }



    /**
     * Retrieves a specific cart for a customer by cart ID.
     * 
     * @param customerId The ID of the customer.
     * @param cartId The ID of the cart to be retrieved.
     * @return The Cart object containing cart details.
     */
    public Cart getCartByIdForCustomer(Long customerId, Long cartId){

        String url = CART_URL + cartId;

        return restTemplate.getForObject(url, Cart.class);

    }




    /**
     * 
     * 
     * 
     */
    public void removeProductFromCart(Long cartId, Long productId){

        String url = CART_URL + cartId + "/products/" + productId;

        try {
            restTemplate.delete(url);
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("Error removing product from cart: " + e.getMessage());
        }

    }


}
