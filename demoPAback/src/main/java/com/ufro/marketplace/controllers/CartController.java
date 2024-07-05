package com.ufro.marketplace.controllers;

import com.ufro.marketplace.models.Cart;
import com.ufro.marketplace.models.CartItem;
import com.ufro.marketplace.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{userId}")
    public ResponseEntity<Cart> createCart(@PathVariable Long userId) {
        Cart cart = cartService.createCart(userId);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/{cartId}/items")
    public ResponseEntity<CartItem> addItemToCart(@PathVariable Long cartId, @RequestBody CartItem cartItem) {
        CartItem addedItem = cartService.addItemToCart(cartId, cartItem);
        return ResponseEntity.ok(addedItem);
    }

    @GetMapping("/{cartId}/items")
    public ResponseEntity<List<CartItem>> getCartItems(@PathVariable Long cartId) {
        List<CartItem> cartItems = cartService.getCartItems(cartId);
        return ResponseEntity.ok(cartItems);
    }

    @DeleteMapping("/{cartId}/items/{itemId}")
    public ResponseEntity<Void> removeItemFromCart(@PathVariable Long cartId, @PathVariable Long itemId) {
        cartService.removeItemFromCart(cartId, itemId);
        return ResponseEntity.ok().build();
    }
}
