<template>
    <div class="cart-item">
      <img :src="item.image" alt="product image" class="product-image" />
      <div class="product-details">
        <h3>{{ item.name }}</h3>
        <p>{{ item.price }}</p>
      </div>
      <button class="remove-button" @click="$emit('remove', item.id)">X</button>
    </div>
  </template>
  
  <script>
  export default {
    name: 'CartItem',
    props: {
      item: Object
    }
  };
  </script>
  
  <style scoped>
  .cart-item {
    display: flex;
    align-items: center;
    background-color: #b3a0f4;
    padding: 10px;
    border-radius: 8px;
    margin-bottom: 10px;
    position: relative;
  }
  
  .product-image {
    width: 50px;
    height: 50px;
    object-fit: cover;
    border-radius: 5px;
  }
  
  .product-details {
    flex-grow: 1;
    margin-left: 10px;
  }
  
  .remove-button {
    background-color: red;
    color: white;
    border: none;
    border-radius: 50%;
    width: 30px;
    height: 30px;
    cursor: pointer;
    position: absolute;
    right: 10px;
  }
  </style>
  