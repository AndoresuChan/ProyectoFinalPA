package com.ufro.marketplace.repositories;

import com.ufro.marketplace.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
