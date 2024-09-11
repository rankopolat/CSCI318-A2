package csci318.cart_service.service;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csci318.cart_service.controller.DTO.CartDTO;
import csci318.cart_service.model.Cart;
import csci318.cart_service.model.CartItems;
import csci318.cart_service.repository.CartRepository;

@Service
public class CartService {
    
    @Autowired
    private CartRepository cartRepository;

    public CartDTO createCartForCustomer(Long customerId) {

        Cart cart = new Cart();
        cart.setCustomerId(customerId);
        cart.setItems(new ArrayList<>());

        Date date = new Date();  
        cart.setDate(date);

        cartRepository.save(cart);

        CartDTO cd = new CartDTO();
        cd.setCustomerId(cart.getCustomerId());
        cd.setId(cart.getId());
        cd.setDate(date);
        
        return cd;

    }

    public List<CartDTO> getCartsByCustomerId(Long customerId) {

        List<Cart> carts = cartRepository.findByCustomerId(customerId);

        if (carts.isEmpty()) {
            throw new RuntimeException("No carts found for customer with customer id: " + customerId);
        }

        List<CartDTO> cartDTOs = new ArrayList<>();

        for (Cart cart : carts) {
            CartDTO csDto = new CartDTO();
            csDto.setCustomerId(cart.getCustomerId());
            csDto.setId(cart.getId());
            csDto.setDate(cart.getDate());
    
            cartDTOs.add(csDto);
        }

        return cartDTOs;

    }



    public Cart getCartByCartId(Long cartId){

        Cart c = cartRepository.findById(cartId)
        .orElseThrow(() -> new RuntimeException("Cart not found with id: " + cartId));

        return c;
    }



    
    public Cart AddProductToCart(Long cartId, CartItems cartItems){

        Cart c = getCartByCartId(cartId);
        c.addItem(cartItems);

        return cartRepository.save(c);

    }


    public boolean removeProduct(Long cartId, Long productId) {

        Cart cart = cartRepository.findById(cartId).orElse(null);

        if (cart == null) {
            return false;
        }

        List<CartItems> items = cart.getItems();
        if (items == null || items.isEmpty()) {
            return false;
        }
        
        CartItems productToRemove = items.stream()
        .filter(item -> item.getId().equals(productId))
        .findFirst()
        .orElse(null);

        if (productToRemove != null) {

            cart.removeItem(productToRemove);
            cartRepository.save(cart);
            return true;
        }

        return false; 
    }


}
