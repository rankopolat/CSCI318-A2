package csci318.demo.service;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import csci318.demo.model.event.UserEvent;
import csci318.demo.repository.CustomerEventRepository;

@Service
public class EventHandler {

    private final CustomerEventRepository customerEventRepository;

    public EventHandler(CustomerEventRepository customerEventRepository) {
        this.customerEventRepository = customerEventRepository;
    }


    @EventListener
    public void handleEvents(UserEvent userEvent) {

        switch (userEvent.getEventType()) {
            case USER_REGISTERED:
                handleUserRegisterEvent(userEvent);
                break;
            case USER_LOGGED_IN:
                handleLoginUserEvent(userEvent);
                break;
            case CART_CREATED:
                handleCartCreatedEvent(userEvent);
                break;
            case PRODUCT_ADDED_TO_CART:
                handleProductAddedEvent(userEvent);
                break;
            case PRODUCT_REMOVED_FROM_CART:
                handleProductRemovedEvent(userEvent);
                break;
        }
    }


    public void handleUserRegisterEvent(UserEvent userEvent) {

        System.out.println("User registered with ID: " + userEvent.getCustomerId());
        customerEventRepository.save(userEvent);
      
    }

    private void handleLoginUserEvent(UserEvent userEvent) {
        System.out.println("User logged in with ID: " + userEvent.getCustomerId());
        customerEventRepository.save(userEvent);
    }

    private void handleCartCreatedEvent(UserEvent userEvent) {
        System.out.println("Cart created for customer ID: " + userEvent.getCustomerId() + " with cart ID: " + userEvent.getCartId());
        customerEventRepository.save(userEvent);
    }

    private void handleProductAddedEvent(UserEvent userEvent) {
        System.out.println("Product added to cart ID: " + userEvent.getCartId() + " with product ID: " + userEvent.getProductId());
        customerEventRepository.save(userEvent);
    }

    private void handleProductRemovedEvent(UserEvent userEvent) {
        System.out.println("Product removed from cart ID: " + userEvent.getCartId() + " with product ID: " + userEvent.getProductId());
        customerEventRepository.save(userEvent);
    }
}
