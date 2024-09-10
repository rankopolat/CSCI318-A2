package csci318.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csci318.demo.model.Cart.Cart;
import csci318.demo.model.Users.Customer;
import csci318.demo.service.UserService;
import csci318.demo.controller.Requests.ProductRequest;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer){
        return userService.registerCustomer(customer);
    }

    @GetMapping("")
    public ResponseEntity<?> getUsers(){
        return userService.getCustomers();
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCustomer(@RequestBody Customer user){
        return userService.loginCustomer(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long id){
        return userService.getCustomer(id);
    }

    @PostMapping("/{customerId}/carts")
     public Cart createCart(@PathVariable Long customerId) {
        return userService.createCartForCustomer(customerId);
    }

    @GetMapping("/{customerId}/carts")
     public Cart getCart(@PathVariable Long customerId) {
        return userService.getCartForCustomer(customerId);
    }

    @PostMapping("/{customerId}/carts/{cartid}/products")
     public Cart addProductToCart(@PathVariable Long customerId, @PathVariable Long cartid, @RequestBody ProductRequest productRequest) {
        return userService.addProductToCart(customerId, cartid, productRequest);
    }

    


    
}
