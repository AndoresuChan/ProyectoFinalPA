<template>
    <div class="cart-container">
  
      <h2>Carro de Compras</h2>
  
      <div class="cart-items">
        <CartItem
          v-for="item in cartItems"
          :key="item.id"
          :item="item"
          @remove="removeItem"
        />
      </div>
  
      <div class="cart-summary">
        <p>Total de productos: {{ cartItems.length }}</p>
        <p>Total a pagar: ${{ calculateTotal() }}</p>
        <button class="checkout-button" @click="checkout">Pagar</button>
      </div>
  
    </div>
  </template>
  
  <script>
  import api from '@/services/api';
  import CartItem from '@/components/BasketItem.vue';
  
  export default {
    name: 'Cart',
    components: {
      CartItem
    },
    data() {
      return {
        cartItems: [],
        cartId: 1
      };
    },
    created() {
      this.fetchCartItems();
    },
    methods: {
      async fetchCartItems() {
        try {
          const response = await api.get(`/cart/${this.cartId}/items`);
          this.cartItems = response.data;
        } catch (error) {
          console.error('Error fetching cart items:', error);
        }
      },
      async removeItem(itemId) {
        try {
          await api.delete(`/cart/${this.cartId}/item/${itemId}`);
          this.cartItems = this.cartItems.filter(item => item.id !== itemId);
        } catch (error) {
          console.error('Error removing item:', error);
        }
      },
      async checkout() {
        try {
          console.log('Comprando productos...');
          this.cartItems = [];
        } catch (error) {
          console.error('Error checking out:', error);
        }
      },
      calculateTotal() {
        let total = 0;
        this.cartItems.forEach(item => {
          total += item.price;
        });
        return total;
      }
    }
  };
  </script>
  
  <style scoped>
  .cart-container {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
  }
  
  .cart-items {
    margin-bottom: 20px;
  }
  
  .cart-summary {
    background-color: #b3a0f4;
    padding: 20px;
    border-radius: 8px;
    text-align: center;
  }
  
  .cart-summary p {
    margin: 10px 0;
  }
  
  .checkout-button {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  </style>
  