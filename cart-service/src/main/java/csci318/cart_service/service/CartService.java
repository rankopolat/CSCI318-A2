package csci318.cart_service.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csci318.cart_service.model.Cart;
import csci318.cart_service.repository.CartRepository;

@Service
public class CartService {
    
    @Autowired
    private CartRepository cartRepository;

    public Cart createCartForCustomer(Long customerId) {

        Cart cart = new Cart();
        cart.setCustomerId(customerId);
        cart.setItems(new ArrayList<>());
        
        return cartRepository.save(cart);

    }

    public Cart getCartByCustomerId(Long customerId) {

        return cartRepository.findByCustomerId(customerId)
            .orElseThrow(() -> new RuntimeException("Cart not found for customer with customer id: " + customerId));

    }


}
