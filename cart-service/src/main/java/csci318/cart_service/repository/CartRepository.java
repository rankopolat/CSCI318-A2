package csci318.cart_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import csci318.cart_service.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long>{

    Optional<Cart> findByCustomerId(Long customerId);

}
