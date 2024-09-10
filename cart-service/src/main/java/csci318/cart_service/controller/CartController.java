package csci318.cart_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csci318.cart_service.controller.DTO.CartDTO;
import csci318.cart_service.model.Cart;
import csci318.cart_service.model.CartItems;
import csci318.cart_service.service.CartService;

@RestController
@RequestMapping("/api/users/{customerId}/carts")
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @PostMapping("")
    public CartDTO createCartForCustomer(@PathVariable Long customerId) {
        return cartService.createCartForCustomer(customerId);
    }

    @GetMapping("")
    public CartDTO getCart(@PathVariable Long customerId) {
        return cartService.getCartByCustomerId(customerId);
    }

    
}
