<template>
  <div class="product-item-grid">
    <router-link :to="{ name: 'ProductDetail', params: { id: id } }">
      <img :src="image" alt="Product Image" class="product-image" />
    </router-link>
    <div class="product-details">
      <h2>{{ name }}</h2>
      <p class="price">${{ price.toFixed(2) }}</p>
      <button class="basket-button">Añadir Al Carrito</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ProductItemGrid',
  props: {
    id: {
      type: Number,
      required: true
    },
    name: {
      type: String,
      required: true
    },
    price: {
      type: Number,
      required: true
    },
    image: {
      type: String,
      required: true
    }
  }
};
</script>

<style scoped>
.product-item-grid {
  display: flex;
  flex-direction: column;
  align-items: center;
  border: 1px solid #ccc;
  background-color: #7887D3;
  padding: 10px;
  border-radius: 10px;
  overflow: hidden;
  transition: transform 0.3s;
}

.product-item-grid:hover {
  transform: scale(1.05);
}

.product-image {
  width: 100%;
  height: 300px;
  object-fit: contain;
  margin-bottom: 10px;
  border-radius: 10px;
}

.product-details {
  text-align: center;
  width: 100%;
}

.product-details h2 {
  margin: 0.5;
  font-size: 0.9rem;
  background-color: #474D8C;
  color: white;
  padding: 4px;
  border-radius: 5px;
}

.price {
  font-size: 0.8rem;
  font-weight: bold;
  color: white;
  background-color: #474D8C;
  padding: 4px;
  border-radius: 5px;
}

.basket-button {
  background-color: #4CAF50;
  color: white;
  border: none;
  padding: 5px;
  cursor: pointer;
  border-radius: 5px;
  width: 80%;
  margin-top: 5px;
  transition: all 0.5s ease;
}

.basket-button:hover {
  background-color: #45a049;
  transform: scale(1.01);
}
</style>
