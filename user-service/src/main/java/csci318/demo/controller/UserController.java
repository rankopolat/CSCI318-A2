package csci318.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csci318.demo.model.Cart.Cart;
import csci318.demo.model.Users.Customer;
import csci318.demo.service.UserService;
import csci318.demo.controller.DTO.CartDTO;
import csci318.demo.controller.Requests.ProductRequest;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer){
        return userService.registerCustomer(customer);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers(){
        return userService.getCustomers();
    }

    @PostMapping("/users/login")
    public ResponseEntity<?> loginCustomer(@RequestBody Customer user){
        return userService.loginCustomer(user);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long id){
        return userService.getCustomer(id);
    }

    @PostMapping("/users/{customerId}/carts")
     public CartDTO createCart(@PathVariable Long customerId) {
        return userService.createCartForCustomer(customerId);
    }

    @GetMapping("/users/{customerId}/carts")
     public List<CartDTO> getCarts(@PathVariable Long customerId) {
        return userService.getCartsForCustomer(customerId);
    }

    @GetMapping("/users/{customerId}/carts/{cartId}")
     public Cart getCart(@PathVariable Long customerId, @PathVariable Long cartId) {
        return userService.getCartByIdForCustomer(customerId, cartId);
    }

    @GetMapping("/users/carts/{cartid}/products")
     public void getProductsFromCart(@PathVariable Long cartid, @RequestBody ProductRequest productRequest) {
        //this will need to return a list of products in the cart
        // userService.getProductsFromCart(cartid, productRequest);
    }

    @PutMapping("/users/carts/{cartid}/products")
     public void addProductToCart(@PathVariable Long cartid, @RequestBody ProductRequest productRequest) {
        userService.addProductToCart(cartid, productRequest);
    }

    @DeleteMapping("/users/carts/{cartid}/products/{productId}")
     public void removeProductFromCart(@PathVariable Long cartid, @PathVariable Long productId) {
        userService.removeProductFromCart(cartid, productId);
    }

    
}
