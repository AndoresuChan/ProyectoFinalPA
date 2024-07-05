<template>
  <div class="product-detail-container">
    <div v-if="product" class="product-detail">
      <img :src="product.image" alt="Product Image" class="product-image" />
      <div class="product-info">
        <h2 class="product-name">{{ product.name }}</h2>
        <p class="supplier">{{ product.supplier }}</p>
        <p class="price">Precio: {{ product.price }}</p>
      </div>
      <div class="description">
        <h3>Descripción:</h3>
        <p>{{ product.description }}</p>
      </div>
      <button @click="addToCart(product.id)" class="add-to-cart-button">Añadir al carrito</button>
    </div>
    <div v-else>
      <p>Cargando...</p>
    </div>
  </div>
</template>

<script>
import api from '@/services/api'; 

export default {
  name: 'ProductDetail',
  data() {
    return {
      product: null
    };
  },
  created() {
    const productId = this.$route.params.id;
    this.fetchProduct(productId);
  },
  methods: {
    async fetchProduct(productId) {
      try {
        const response = await api.get(`/products/${productId}`);
        this.product = response.data;
      } catch (error) {
        console.error('Error fetching product:', error);
      }
    },
    addToCart(productId) {
      console.log('Añadir al carrito:', productId);
    }
  }
};
</script>

<style scoped>
.product-detail-container {
  display: flex;
  justify-content: center;
  margin-top: 40px; 
}

.product-detail {
  background-color: #7887D3;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  max-width: 1000px;
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: auto auto 1fr auto auto;
  gap: 20px;
  align-items: start;
}

.product-image {
  grid-column: 1 / 2;
  grid-row: 1 / 3;
  width: 100%;
  max-width: 300px;
  border-radius: 10px;
}

.product-info {
  grid-column: 2 / 3;
  grid-row: 1 / 3;
}

.product-name {
  font-size: 1.8rem;
  background-color: #474D8C;
  color: white;
  padding: 6px;
  border-radius: 5px;
  text-align: center;
}

.supplier {
  font-size: 1.5rem;
  background-color: #474D8C;
  color: white;
  padding: 6px;
  border-radius: 5px;
}

.price {
  font-size: 1.5rem;
  font-weight: bold;
  color: white;
  background-color: #474D8C;
  padding: 6px;
  border-radius: 5px;
  text-align: center;
}

.description {
  grid-column: 1 / 3;
  grid-row: 4 / 5;
  background-color: #474D8C;
  color: white;
  padding: 10px;
  border-radius: 10px;
}

.add-to-cart-button {
  grid-column: 1 / 3;
  grid-row: 5 / 6;
  background-color: #4CAF50;
  color: white;
  border: none;
  padding: 10px 20px;
  cursor: pointer;
  border-radius: 5px;
  font-size: 1rem;
  margin-top: 20px;
  transition: all 0.3s ease;
  text-align: center;
}

.add-to-cart-button:hover {
  background-color: #45a049;
  transform: scale(1.02);
}
</style>
