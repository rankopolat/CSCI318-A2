package csci318.cart_service.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csci318.cart_service.controller.DTO.CartDTO;
import csci318.cart_service.model.Cart;
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

    public CartDTO getCartByCustomerId(Long customerId) {

        Cart c = cartRepository.findByCustomerId(customerId)
            .orElseThrow(() -> new RuntimeException("Cart not found for customer with customer id: " + customerId));

        CartDTO csDto =  new CartDTO();
        csDto.setCustomerId(c.getCustomerId());
        csDto.setId(c.getId());
        csDto.setDate(c.getDate());

        return csDto;

    }


}
