package csci318.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import csci318.demo.model.Users.Customer;
import csci318.demo.repository.CustomerRepository;


@Service
public class UserService {

    private final CustomerRepository customerRepository;

    // Constructor injection for CustomerRepository.
    @Autowired
    public UserService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
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
}
