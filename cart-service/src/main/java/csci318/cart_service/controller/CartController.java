package csci318.cart_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import csci318.cart_service.controller.DTO.CartDTO;
import csci318.cart_service.model.Cart;
import csci318.cart_service.model.CartItems;
import csci318.cart_service.service.CartService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @PostMapping("/users/{customerId}/carts")
    public CartDTO createCartForCustomer(@PathVariable Long customerId) {
        return cartService.createCartForCustomer(customerId);
    }

    @GetMapping("/users/{customerId}/carts")
    public List<CartDTO> getCarts(@PathVariable Long customerId) {
        return cartService.getCartsByCustomerId(customerId);
    }

    @GetMapping("/users/carts/{cartId}")
    public Cart getCartByCartId(@PathVariable Long cartId) {
        return cartService.getCartByCartId(cartId);
    }

    @PutMapping("/users/carts/{cartId}/products")
    public Cart AddProductToCart(@PathVariable Long cartId, @RequestBody CartItems cartItems){
        return cartService.AddProductToCart(cartId, cartItems);
    }

    @DeleteMapping("/users/carts/{cartId}/products/{productId}")
    public ResponseEntity<?> RemoveProductFromCart(@PathVariable Long cartId, @PathVariable Long productId){

        boolean removed = cartService.removeProduct(cartId, productId);

        if (removed) {
            return ResponseEntity.ok("Product removed from cart");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found in cart");
        }
    }


    
}
