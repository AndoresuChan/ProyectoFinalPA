package com.ufro.marketplace.repositories;

import com.ufro.marketplace.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
