package csci318.cart_service.service;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import csci318.cart_service.controller.DTO.CartDTO;
import csci318.cart_service.controller.DTO.CartItemDTO;
import csci318.cart_service.model.Cart;
import csci318.cart_service.model.CartItems;
import csci318.cart_service.model.event.CartEvent;
import csci318.cart_service.repository.CartRepository;
import csci318.cart_service.controller.DTO.ProductDTO;

@Service
public class CartService {
    
    private final CartRepository cartRepository;
    private final RestTemplate restTemplate;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public CartService(CartRepository cartRepository, RestTemplate restTemplate, ApplicationEventPublisher applicationEventPublisher){
        this.cartRepository = cartRepository;
        this.restTemplate = restTemplate;
        this.applicationEventPublisher = applicationEventPublisher;
    }
    

    public CartDTO createCartForCustomer(Long customerId) {

        Cart cart = new Cart();
        cart.setCustomerId(customerId);
        cart.setItems(new ArrayList<>());

        Date date = new Date();  
        cart.setDate(date);

        cartRepository.save(cart);

        CartEvent createCartEvent = new CartEvent(CartEvent.EventType.CART_CREATED, cart.getId(), null, customerId);
        applicationEventPublisher.publishEvent(createCartEvent);

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


     
    /**
     * Checks if a product exists by querying the product service.
     * 
     * @param productId The ID of the product to check.
     * @return The ProductDTO object if the product exists.
     */
    public final String PRODUCT_URL = "http://localhost:8081/api/products/";

    public ProductDTO checkProduct(Long productId) {

        String url = PRODUCT_URL + productId;
        ProductDTO pdt =restTemplate.getForObject(url, ProductDTO.class);
        System.out.println("ProductDTO: " + pdt.getName());

        return pdt;
         
    }


    
    public Cart AddProductToCart(Long cartId, CartItems cartItems){

        ProductDTO pdt = checkProduct(cartItems.getProductId());
        
        Cart c = getCartByCartId(cartId);
        cartItems.setName(pdt.getName());

        c.addItem(cartItems);
        cartRepository.save(c);

        return c;

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


    public List<CartItemDTO> getProductsFromCart(Long cartId){

        Cart cart = cartRepository.findById(cartId)
            .orElseThrow(() -> new RuntimeException("Cart not found with id: " + cartId));

        List<CartItemDTO> cartItemDTOs = new ArrayList<>();

        for (CartItems c : cart.getItems()) {

            CartItemDTO cI = new CartItemDTO();

            cI.setId(c.getId());
            cI.setProductId(c.getProductId());
            cI.setQuantity(c.getQuantity());
            cI.setName(c.getName());
    
            cartItemDTOs.add(cI);

        }

        return cartItemDTOs;
    }

}
