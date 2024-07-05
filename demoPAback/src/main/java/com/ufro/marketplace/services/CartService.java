package com.ufro.marketplace.services;

import com.ufro.marketplace.models.Cart;
import com.ufro.marketplace.models.CartItem;
import com.ufro.marketplace.models.User;
import com.ufro.marketplace.repositories.CartItemRepository;
import com.ufro.marketplace.repositories.CartRepository;
import com.ufro.marketplace.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserRepository userRepository;

    public Cart createCart(Long userId) {
        Cart cart = new Cart();
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        cart.setUser(user);
        return cartRepository.save(cart);
    }

    public CartItem addItemToCart(Long cartId, CartItem cartItem) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        cartItem.setCart(cart);
        return cartItemRepository.save(cartItem);
    }

    public List<CartItem> getCartItems(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        return List.copyOf(cart.getCartItems());
    }

    public void removeItemFromCart(Long cartId, Long itemId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        CartItem cartItem = cartItemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("CartItem no encontrado"));
        cart.getCartItems().remove(cartItem);
        cartItemRepository.delete(cartItem);
    }
}
